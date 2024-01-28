package thingys.nilsthingymod.entity.redpanda;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import thingys.nilsthingymod.NilsThingyMod;
import thingys.nilsthingymod.entity.Goblin;
import thingys.nilsthingymod.entity.Redpanda;

public class RedpandaModel extends GeoModel<Redpanda> {

    private final Identifier modelResource = new Identifier(NilsThingyMod.MODID,"geo/entity/redpanda.geo.json");
    private final Identifier textureResource = new Identifier(NilsThingyMod.MODID,"textures/entity/redpanda.png");
    private final Identifier animationResource = new Identifier(NilsThingyMod.MODID,"animations/redpanda.animation.json");

    @Override
    public Identifier getModelResource(Redpanda animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(Redpanda animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(Redpanda animatable) {
        return animationResource;
    }

    @Override
        public void setCustomAnimations(Redpanda animatable, long id, AnimationState<Redpanda> animationState){
         CoreGeoBone head = getAnimationProcessor().getBone("head");

         if (head != null){

            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX((entityModelData.headPitch() + (animatable.isSitting() || animatable.isPanicking() ? -90:0)) * MathHelper.RADIANS_PER_DEGREE);
             if (animatable.isSitting() || animatable.isPanicking()) {
                 head.setRotZ(-1 * entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
             } else {
                 head.setRotY(entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
             }

         }
    }
}
