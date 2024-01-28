package thingys.nilsthingymod.entity.redpanda;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import thingys.nilsthingymod.entity.Redpanda;

public class RedpandaRenderer extends GeoEntityRenderer<Redpanda> {
    public RedpandaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RedpandaModel());
    }

    @Override
    public RenderLayer getRenderType(Redpanda animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {

        if (animatable.isBaby()){
            withScale(0.5f);
        }else {
            withScale(1f);
        }

        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
