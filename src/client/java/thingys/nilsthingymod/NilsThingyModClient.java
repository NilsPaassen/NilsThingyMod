package thingys.nilsthingymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import thingys.nilsthingymod.block.NilsBlocks;
import thingys.nilsthingymod.entity.goblin.GoblinRenderer;
import thingys.nilsthingymod.entity.redpanda.RedpandaRenderer;

public class NilsThingyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(NilsThingyMod.GOBLIN, GoblinRenderer::new);
		EntityRendererRegistry.register(NilsThingyMod.REDPANDA, RedpandaRenderer::new);

		//Blocks with 0 or 100 Alpha Value
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				NilsBlocks.FENNEL_CROP,
				NilsBlocks.ANNISE_CROP,
				NilsBlocks.POPLAR_LEAVES,
				NilsBlocks.POPLAR_SAPLING
		);
	}
}