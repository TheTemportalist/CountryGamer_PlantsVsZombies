package com.countrygamer.pvz.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.block.BlockContainerBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.block.tile.TileEntityGravestone;

public class BlockGravestone extends BlockContainerBase {
	public int type = 0;

	public BlockGravestone(int type, String modid, String name, Class<? extends TileEntity> tileEntityClass) {
		super(Material.rock, modid, name, tileEntityClass);
		this.type = type;
		setHardness(0.2F).setResistance(3.0F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,
			int j, int k) {
		return null;
	}

	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y,
			int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		switch (((TileEntityGravestone)world.getTileEntity(x, y, z)).type) {
		case 1:
			ret.add(new ItemStack(Items.rotten_flesh, 8));
			break;
		case 2:
			int i = world.rand.nextInt(4);
			switch (i) {
			case 0:
				ret.add(new ItemStack(PvZ.footballHelm, 1));
				break;
			case 1:
				ret.add(new ItemStack(PvZ.footballChest, 1));
				break;
			case 2:
				ret.add(new ItemStack(PvZ.footballLegs, 1));
				break;
			case 3:
				ret.add(new ItemStack(PvZ.footballBoots, 1));
				break;
			default:
				ret.add(new ItemStack(PvZ.footballHelm, 1));
				ret.add(new ItemStack(PvZ.footballChest, 1));
				ret.add(new ItemStack(PvZ.footballLegs, 1));
				ret.add(new ItemStack(PvZ.footballBoots, 1));
			}
			break;
		case 3:
			ret.add(new ItemStack(PvZ.flag, 1));
			break;
		case 4:
			break;
		case 5:
			ret.add(new ItemStack(Items.bucket, 1));
			break;
		default:
			ret.clear();
		}

		return ret;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	public int quantitItemStackropped(Random rand) {
		return 1;
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	/*
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		onBlockAdded(world, x, y, z);

		if (this.gravestoneTE.facing < 0) {
			int facing = PvZ_Util.checkFacing(world, x, y, z,
					par5EntityLivingBase, par6ItemStack, this.gravestoneTE);
			this.gravestoneTE.facing = facing;
		}
		if (this.gravestoneTE.type <= 0) {
			this.gravestoneTE.type = this.type;
		}
		PvZ_Util.spawnRandZombie(world, x, y, z, this.gravestoneTE.facing,
				this.gravestoneTE.type);
	}
	*/
}