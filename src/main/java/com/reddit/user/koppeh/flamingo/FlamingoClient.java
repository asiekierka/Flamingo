package com.reddit.user.koppeh.flamingo;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import org.dimdev.rift.listener.client.TileEntityRendererAdder;

import java.util.Map;

public class FlamingoClient implements TileEntityRendererAdder {
	@Override
	public void addTileEntityRenderers(Map<Class<? extends TileEntity>, TileEntityRenderer<? extends TileEntity>> renderers) {
		renderers.put(TileEntityFlamingo.class, TileEntityFlamingoRenderer.INSTANCE);
	}
}
