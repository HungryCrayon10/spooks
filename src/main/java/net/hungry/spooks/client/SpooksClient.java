package net.hungry.spooks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hungry.spooks.register.SpooksBlocks;
import net.minecraft.client.render.RenderLayer;

public class SpooksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SpooksBlocks.GHOST_PEPPERS_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SpooksBlocks.DELTA_THYME_GROWTH, RenderLayer.getCutout());
    }
}
