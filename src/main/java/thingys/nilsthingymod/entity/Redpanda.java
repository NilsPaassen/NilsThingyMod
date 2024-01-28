package thingys.nilsthingymod.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import thingys.nilsthingymod.NilsThingyMod;

import java.util.UUID;
import java.util.function.Predicate;

public class Redpanda extends TameableEntity implements GeoEntity {

    public Redpanda(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0d)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3d);
    }


    private long lastDamageTimeRP;


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return NilsThingyMod.REDPANDA.create(world);
    }

    /*Anim Controllers*/
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"Predicate",5,this::predicate));
    }
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    protected static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("animation.redpanda.walk");
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.redpanda.idle").thenWait(500);
    protected static final RawAnimation STANDING_IDLE = RawAnimation.begin().thenLoop("animation.redpanda.standing.idle");
    protected static final RawAnimation STANDING_WALK = RawAnimation.begin().thenLoop("animation.redpanda.standing.walk");
    protected <E extends Redpanda> PlayState predicate(final AnimationState<E> event) {
        if (event.isMoving()) {
            if (this.getWorld().getTime() - lastDamageTimeRP < 150L){
                return event.setAndContinue(STANDING_WALK);
            } else {
                setPanicking(false);
            }
            return event.setAndContinue(WALK_ANIM);
        } else if (isSitting()) {
            return event.setAndContinue(STANDING_IDLE);
        } else if (!isNavigating()) {
            return event.setAndContinue(IDLE);
        }

        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    //Prevent fall damage
    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {}

    @Override



    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, true));
        this.goalSelector.add(7, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 2.0));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.goalSelector.add(2,new EscapeDangerGoal(this, 1.25));

    }





    /*Tameable Entity*/
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.GLOW_BERRIES) || stack.isOf(Items.SWEET_BERRIES) || stack.isOf(Items.APPLE);
    }

    public static final TrackedData<Boolean> SITTING = DataTracker.registerData(Redpanda.class, TrackedDataHandlerRegistry.BOOLEAN);
    public boolean isSitting(){
        return this.dataTracker.get(SITTING);
    }
    public void setSit(boolean sitting){
        this.dataTracker.set(SITTING,sitting);
        super.setSitting(sitting);
    }
    public static final TrackedData<Boolean> PANICKING = DataTracker.registerData(Redpanda.class, TrackedDataHandlerRegistry.BOOLEAN);
    public boolean isPanicking(){
        return this.dataTracker.get(PANICKING);
    }
    public void setPanicking(boolean panicking){
        this.dataTracker.set(PANICKING,panicking);
    }
    @Override
    public Team getScoreboardTeam(){
        return super.getScoreboardTeam();
    }

    @Override
   protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(SITTING,false);
        this.dataTracker.startTracking(PANICKING,false);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(60.0);
            this.setHealth(60.0F);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4d);
        } else {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(8.0);
        }
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return super.canBeLeashedBy(player);
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if(isBreedingItem(itemStack) && !isPanicking() && isTamed()){
            return super.interactMob(player,hand);
        }

        if (isBreedingItem(itemStack) && !isTamed()){
            if (!this.getWorld().isClient()) {
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }

                if (!this.getWorld().isClient()) {
                    if (this.random.nextInt(3) == 0) {
                        super.setOwner(player);
                        this.navigation.recalculatePath();
                        this.setTarget(null);
                        this.getWorld().sendEntityStatus(this, (byte) 7);
                        setSit(true);
                    } else {
                        this.getWorld().sendEntityStatus(this, (byte) 6);
                    }
                }

            }
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.getWorld().isClient() && hand == Hand.MAIN_HAND){
            setSit(!isSitting());
            return  ActionResult.SUCCESS;
        }

        if (isBreedingItem(itemStack)){
            return ActionResult.PASS;
        }

        return super.interactMob(player,hand);
    }



    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("isSitting", this.dataTracker.get(SITTING));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(SITTING, nbt.getBoolean("isSitting"));
    }

    public EntityView method_48926() {
        return this.getWorld();
    }


    @Override
    public boolean damage(DamageSource source, float amount) {
        lastDamageTimeRP = this.getWorld().getTime();
        setPanicking(true);
        return super.damage(source,amount);
    }

    @Override
    public int getXpToDrop() {
        return 3;
    }
}
