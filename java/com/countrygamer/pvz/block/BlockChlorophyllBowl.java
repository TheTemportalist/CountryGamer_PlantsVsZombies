package com.countrygamer.pvz.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.block.BlockContainerBase;
import com.countrygamer.pvz.block.tile.TileEntityChlorophyllBowl;

public class BlockChlorophyllBowl extends BlockContainerBase {
	Random random = new Random();

	public BlockChlorophyllBowl(Material mat, String modid, String name,
			Class<? extends TileEntity> tileEntityClass) {
		super(mat, modid, name, tileEntityClass);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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

	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityChlorophyllBowl tileentitychest = (TileEntityChlorophyllBowl) par1World
				.getTileEntity(par2, par3, par4);

		if (tileentitychest != null) {
			tileentitychest.updateContainingBlockInfo();
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6) {
		TileEntityChlorophyllBowl tileentitychest = (TileEntityChlorophyllBowl) par1World
				.getTileEntity(par2, par3, par4);

		if (tileentitychest != null) {
			for (int j1 = 0; j1 < tileentitychest.getSizeInventory(); j1++) {
				ItemStack itemstack = tileentitychest.getStackInSlot(j1);

				if (itemstack == null)
					continue;
				float f = this.random.nextFloat() * 0.8F + 0.1F;
				float f1 = this.random.nextFloat() * 0.8F + 0.1F;
				EntityItem entityitem;
				for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World
						.spawnEntityInWorld(entityitem)) {
					int k1 = this.random.nextInt(21) + 10;

					if (k1 > itemstack.stackSize) {
						k1 = itemstack.stackSize;
					}

					itemstack.stackSize -= k1;
					entityitem = new EntityItem(par1World, par2 + f, par3 + f1,
							par4 + f2, new ItemStack(itemstack.getItem(), k1,
									itemstack.getItemDamage()));
					float f3 = 0.05F;
					entityitem.motionX = ((float) this.random.nextGaussian() * f3);
					entityitem.motionY = ((float) this.random.nextGaussian()
							* f3 + 0.2F);
					entityitem.motionZ = ((float) this.random.nextGaussian() * f3);

					if (!itemstack.hasTagCompound())
						continue;
					entityitem.getEntityItem().setTagCompound(
							(NBTTagCompound) itemstack.getTagCompound().copy());
				}

			}

			par1World.func_147453_f(par2, par3, par4, par5);
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		}

		IInventory iinventory = func_94442_h_(par1World, par2, par3, par4);

		if (iinventory != null) {
			par5EntityPlayer.displayGUIChest(iinventory);
		}

		return true;
	}

	public IInventory func_94442_h_(World par1World, int par2, int par3,
			int par4) {
		Object object = (TileEntityChlorophyllBowl) par1World.getTileEntity(
				par2, par3, par4);

		if (object == null) {
			return null;
		}

		return (IInventory) object;
	}
}