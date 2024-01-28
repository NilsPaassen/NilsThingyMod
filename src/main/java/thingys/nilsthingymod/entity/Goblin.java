package thingys.nilsthingymod.entity;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Goblin extends WanderingTraderEntity implements GeoEntity {


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public Goblin(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"Walking",5,this::walkAnimController));
    }

    /*Anim Controllers*/
    protected static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("animation.goblin.walk");
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.goblin.idle").thenWait(500);
    protected <E extends Goblin> PlayState walkAnimController(final AnimationState<E> event) {
        if (event.isMoving()) {
            return event.setAndContinue(WALK_ANIM);
        } else if (!isNavigating()) {
            return event.setAndContinue(IDLE);
        }

        return PlayState.STOP;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    /*Sounds*/
    @Override
    public float getSoundPitch() {
        return this.isBaby() ? (this.random.nextFloat() - this.random.nextFloat()) * 0.3F + 2F : (this.random.nextFloat() - this.random.nextFloat()) * 0.4F + 1.9F;
    }
}
