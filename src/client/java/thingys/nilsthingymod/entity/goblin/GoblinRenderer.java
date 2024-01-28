package thingys.nilsthingymod.entity.goblin;

import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import thingys.nilsthingymod.entity.Goblin;

public class GoblinRenderer extends GeoEntityRenderer<Goblin> {

    public GoblinRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GoblinModel());
    }
}
