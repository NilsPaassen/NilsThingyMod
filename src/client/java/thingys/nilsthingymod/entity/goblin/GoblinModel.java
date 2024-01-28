package thingys.nilsthingymod.entity.goblin;


import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.entity.Goblin;


public class GoblinModel extends GeoModel<Goblin> {

    private final Identifier modelResource = new Identifier(NilsThingyMod.MODID,"geo/entity/goblin.geo.json");
    private final Identifier textureResource = new Identifier(NilsThingyMod.MODID,"textures/entity/goblin.png");
    private final Identifier animationResource = new Identifier(NilsThingyMod.MODID,"animations/goblin.animation.json");


    @Override
    public Identifier getModelResource(Goblin animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(Goblin animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(Goblin animatable) {
        return animationResource;
    }




    @Override
        public void setCustomAnimations(Goblin animatable, long id, AnimationState<Goblin> animationState){
        CoreGeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityModelData.netHeadYaw()  * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
