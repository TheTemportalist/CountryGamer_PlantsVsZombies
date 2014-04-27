package com.countrygamer.pvz.lib;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.countrygamer.core.common.lib.CoreUtil;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.zombies.EntityFlagZombie;
import com.countrygamer.pvz.entities.mobs.zombies.EntityFootballZombie;

public class Util {
	private static int maxZombieType = 3;

	public static final ItemStack nullStack = new ItemStack(Items.stick, 0, 0);

	public static boolean removeItem(EntityPlayer player, ItemStack thisStack) {
		IInventory inv = player.inventory;

		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) == null) {
				continue;
			}
			ItemStack j = inv.getStackInSlot(i);
			if ((j.getItem() == null) || (j.getItem() != thisStack.getItem())
					|| (j.getItemDamage() != thisStack.getItemDamage())
					|| (j.stackSize < thisStack.stackSize))
				continue;
			boolean size = false;
			if (j.stackSize == thisStack.stackSize)
				inv.setInventorySlotContents(i, null);
			else {
				inv.setInventorySlotContents(
						i,
						new ItemStack(thisStack.getItem(), j.stackSize
								- thisStack.stackSize, thisStack
								.getItemDamage()));
			}

			return true;
		}

		return false;
	}

	public static void addItem(EntityPlayer player, ItemStack thisStack) {
		IInventory inv = player.inventory;

		boolean added = false;

		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) == null) {
				continue;
			}
			ItemStack j = inv.getStackInSlot(i);
			if ((j.getItem() == null) || (j.getItem() != thisStack.getItem())
					|| (j.getItemDamage() != thisStack.getItemDamage())
					|| (j.stackSize == 64)) {
				continue;
			}
			inv.setInventorySlotContents(i,
					new ItemStack(thisStack.getItem(), j.stackSize
							+ thisStack.stackSize, thisStack.getItemDamage()));

			added = true;
			break;
		}

		if (!added)
			player.inventory.addItemStackToInventory(thisStack);
	}

	public static boolean dayCheck(World world) {
		return world.isDaytime();
	}

	public static void spawnItem(World world, int x, int y, int z,
			ItemStack itemStack) {
		Random random = new Random();
		if ((!world.isRemote) && (itemStack != null)) {
			float f = random.nextFloat() * 0.8F + 0.1F;
			float f1 = random.nextFloat() * 0.8F + 0.1F;
			EntityItem entityitem;
			for (float f2 = random.nextFloat() * 0.8F + 0.1F; itemStack.stackSize > 0; world
					.spawnEntityInWorld(entityitem)) {
				int k1 = random.nextInt(21) + 10;

				if (k1 > itemStack.stackSize) {
					k1 = itemStack.stackSize;
				}

				itemStack.stackSize -= k1;
				entityitem = new EntityItem(world, x + f, y + f1, z + f2,
						new ItemStack(itemStack.getItem(), k1,
								itemStack.getItemDamage()));

				float f3 = 0.05F;
				entityitem.motionX = ((float) random.nextGaussian() * f3);
				entityitem.motionY = ((float) random.nextGaussian() * f3 + 0.2F);
				entityitem.motionZ = ((float) random.nextGaussian() * f3);
				world.spawnEntityInWorld(entityitem);
			}
		}
	}

	public static boolean checkUnder(World world, double posX, double posY,
			double posZ, int par1) {
		for (double i = posX - par1; i <= posX + par1; i += 1.0D) {
			for (double k = posZ - par1; k <= posZ + par1; k += 1.0D) {
				if (!world.isSideSolid((int) i, (int) posY, (int) k,
						ForgeDirection.UP)) {
					return false;
				}
			}
		}

		return true;
	}

	public static int checkFacing(World world, int x, int y, int z,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack,
			TileEntity tileEnt) {
		int l = MathHelper
				.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;

		if (l == 0) {
			return 0;
		}

		if (l == 1) {
			return 1;
		}

		if (l == 2) {
			return 2;
		}

		if (l == 3) {
			return 3;
		}

		return 0;
	}

	public static void spawnRandZombie(World world, double x, double y,
			double z, int facing, int typeG) {
		if (!world.isRemote) {
			int type = typeZombie(world, typeG);
			if (type == 2) {
				type = world.rand.nextInt(maxZombieType);
			}
			switch (facing) {
			case 0:
				System.out.println("facing = 0");
				for (double z1 = z; z1 <= z + 1.0D; z1 += 1.0D) {
					for (double x1 = x - 2.0D; x1 <= x + 2.0D; x1 += 1.0D) {
						typeZombie(world, type, x1 + 0.5D, y, z1 + 0.5D);
					}
				}
				break;
			case 1:
				System.out.println("facing = 1");
				for (double x1 = x; x1 >= x - 1.0D; x1 -= 1.0D) {
					for (double z1 = z - 2.0D; z1 <= z + 2.0D; z1 += 1.0D) {
						typeZombie(world, type, x1 + 0.5D, y, z1 + 0.5D);
					}
				}
				break;
			case 2:
				System.out.println("facing = 2");
				for (double z1 = z; z1 >= z - 1.0D; z1 -= 1.0D) {
					for (double x1 = x - 2.0D; x1 <= x + 2.0D; x1 += 1.0D) {
						typeZombie(world, type, x1 + 0.5D, y, z1 + 0.5D);
					}
				}
				break;
			case 3:
				System.out.println("facing = 3");
				for (double x1 = x; x1 <= x + 1.0D; x1 += 1.0D)
					for (double z1 = z - 2.0D; z1 <= z + 2.0D; z1 += 1.0D)
						typeZombie(world, type, x1 + 0.5D, y, z1 + 0.5D);
			}
		}
	}

	private static int typeZombie(World world, int typeG) {
		int type = 0;
		if (typeG == 0)
			type = world.rand.nextInt(maxZombieType);
		else {
			type = typeG;
		}
		return type;
	}

	private static void typeZombie(World world, int type, double x, double y,
			double z) {
		EntityZombie zombie = null;
		switch (type) {
		case 2:
			zombie = new EntityFootballZombie(world);
			spawnZombie(zombie, world, x, y, z);
			break;
		case 3:
			zombie = new EntityFlagZombie(world);
			spawnZombie(zombie, world, x, y, z);
			break;
		default:
			zombie = new EntityZombie(world);
			spawnZombie(zombie, world, x, y, z);
		}
	}

	private static void spawnZombie(EntityZombie zombie, World world, double x,
			double y, double z) {
		int x1 = (int) (x - 0.5D);
		int z1 = (int) (z - 0.5D);
		ArrayList<Block> blocks = new ArrayList<Block>();
		ArrayList<Integer> blockMeta = new ArrayList<Integer>();
		for (int j = 0; j < 2; j++) {
			Block block = world.getBlock(x1, (int) y + j, z1);
			if ((block == PvZ.gravestone) || (block == PvZ.gravestoneReg)
					|| (block == PvZ.gravestoneFootball)
					|| (block == PvZ.gravestoneFlag)
					|| (block == PvZ.gravestoneCone)
					|| (block == PvZ.gravestoneBucket)) {
				continue;
			}

			if (block != null) {
				blocks.add(world.getBlock(x1, (int) y + j, z1));
				blockMeta.add(Integer.valueOf(world.getBlockMetadata(x1,
						(int) y + j, z1)));
			}
			world.setBlockToAir(x1, (int) y + j, z1);
		}

		if ((world.getBlock(x1, (int) (y - 1.0D), z1) == null)
				|| (!world.isSideSolid(x1, (int) (y - 1.0D), z1,
						ForgeDirection.UP))) {
			world.setBlock(x1, (int) (y - 1.0D), z1, Blocks.grass);
		}
		zombie.setPosition(x, y, z);
		world.spawnEntityInWorld(zombie);

		if (blocks.size() > 0)
			for (int i = 0; i < blocks.size(); i++) {
				if (blocks.get(i) == Blocks.grass)
					blocks.set(i, Blocks.dirt);
				if (blocks.get(i) == Blocks.mycelium)
					blocks.set(i, Blocks.dirt);
				if (blocks.get(i) == Blocks.stone)
					blocks.set(i, Blocks.cobblestone);
				CoreUtil.dropItemStack(world,
						new ItemStack(Item.getItemFromBlock(blocks.get(i)), 1,
								blockMeta.get(i)), (int) x, (int) (y + 1.0D),
						(int) z);
			}
	}

	public static int entityDirection(EntityLivingBase ent) {
		int yaw = (int) ent.rotationYaw;
		if (yaw < 0)
			yaw += 360;
		yaw += 22;
		yaw %= 360;
		int facing = yaw / 90;

		return facing;
	}

	public static int[] entityDirectionSpawn(EntityLivingBase ent) {
		int facing = entityDirection(ent);
		int xOffset1 = 0;
		int xOffset2 = 0;
		int zOffset1 = 0;
		int zOffset2 = 0;
		int[] facingA;
		switch (facing) {
		case 0:
			xOffset1 = 1;
			xOffset2 = -1;
			facingA = new int[] { xOffset1, xOffset2 };

			break;
		case 1:
			zOffset1 = 1;
			zOffset2 = -1;
			facingA = new int[] { zOffset1, zOffset2 };

			break;
		case 2:
			xOffset1 = -1;
			xOffset2 = 1;
			facingA = new int[] { xOffset1, xOffset2 };

			break;
		case 3:
			zOffset1 = -1;
			zOffset2 = 1;
			facingA = new int[] { zOffset1, zOffset2 };

			break;
		default:
			facingA = new int[] { xOffset1, xOffset2 };
		}

		return facingA;
	}

	public static boolean greenhouseSlotCheck(int i, ItemStack itemStack) {
		switch (i) {
		case 0:
			isItemInput(itemStack);
		case 1:
			isItemModify1(itemStack);
		case 2:
			isItemModify2(itemStack);
		}
		return false;
	}

	public static boolean isItemInput(ItemStack itemStack) {
		return (itemStack.getItem() == PvZ.basicPlants)
				|| (itemStack.getItem() == PvZ.nightPlants);
	}

	public static boolean isItemModify1(ItemStack itemStack) {
		return (itemStack.getItem() == PvZ.sunlight)
				|| (itemStack.getItem() == PvZ.moonlight);
	}

	public static boolean isItemModify2(ItemStack itemStack) {
		return (itemStack.getItem() == Items.snowball)
				|| (itemStack.getItem() == Items.gunpowder);
	}

	public static boolean daveSlotCheck(int i, ItemStack itemStack) {
		switch (i) {
		case 0:
			isItemInputD(itemStack);
		case 1:
			isItemModify1D(itemStack);
		}
		return false;
	}

	public static boolean isItemInputD(ItemStack itemStack) {
		return itemStack.getItem() == PvZ.peaPod;
	}

	public static boolean isItemModify1D(ItemStack itemStack) {
		return itemStack.getItem() == PvZ.sunlight;
	}

}