package com.reddit.user.koppeh.flamingo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockFlamingo extends BlockContainer {
	public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION;
	private static final VoxelShape SHAPE = ShapeUtils.makeCuboidShape(3 / 16.0F, 0, 3 / 16.0F, 13 / 16.0F, 1, 13 / 16.0F);

	public BlockFlamingo() {
		super(Block.Builder.create(Material.CLOTH, MapColor.PINK).soundType(SoundType.CLOTH).hardnessAndResistance(1.5f, 6.0f));
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isSolid(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader world, IBlockState state, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader world, BlockPos pos) {
		return SHAPE;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	protected void addPropertiesToBuilder(StateContainer.Builder<Block, IBlockState> builder) {
		builder.addProperties(ROTATION);
	}

	@Nullable
	@Override
	public TileEntity getTileEntity(IBlockReader world) {
		return new TileEntityFlamingo();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		int metadata = ((Math.round((((player.rotationYawHead + 180) % 360) * 16 / 360)) % 16) + 16) % 16;
		world.setBlockState(pos, state.withProperty(ROTATION, metadata), 3);
	}

	@Override
	public void onLeftClick(IBlockState state, World world, BlockPos pos, EntityPlayer player) {
		if(world.isRemote) {
			return;
		}
		TileEntity entity = world.getTileEntity(pos);
		if(!(entity instanceof TileEntityFlamingo)) {
			return;
		}
		world.addBlockEvent(pos, this, 0, 0);
	}
}
