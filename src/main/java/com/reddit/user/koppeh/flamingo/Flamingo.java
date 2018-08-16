package com.reddit.user.koppeh.flamingo;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;
import org.dimdev.rift.listener.TileEntityTypeAdder;
import org.dimdev.rift.listener.client.TileEntityRendererAdder;

import java.util.Map;

public class Flamingo implements BlockAdder, ItemAdder, TileEntityTypeAdder {
	public static final ResourceLocation LOCATION = new ResourceLocation("flamingo", "flamingo.flamingo");
	public static BlockFlamingo flamingo;

	@Override
	public void registerBlocks() {
		Block.registerBlock(LOCATION, flamingo = new BlockFlamingo());
	}

	@Override
	public void registerItems() {
		Item.registerItemBlock(new ItemBlockFlamingo(flamingo, new Item.Builder().group(ItemGroup.DECORATIONS)));
	}

	@Override
	public void registerTileEntityTypes() {
		TileEntityFlamingo.TYPE = TileEntityType.registerTileEntityType(LOCATION.toString(), TileEntityType.Builder.create(TileEntityFlamingo::new));
	}
}
