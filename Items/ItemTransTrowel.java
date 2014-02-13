package com.countrygamer.pvz.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityPlantBase;
import com.countrygamer.pvz.lib.Util;

public class ItemTransTrowel extends ItemTrowel {

	public ItemTransTrowel(String modid, String name, float damageVsEntity,
			Item.ToolMaterial material, Block[] validBlocks) {
		super(modid, name, damageVsEntity, material, validBlocks);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player,
			World world, int x, int y, int z, int side, float xOffset,
			float yOffset, float zOffset) {
		Block block = world.getBlock(x, y, z);
		if (block == PvZ.endowedGrass) {
			world.setBlock(x, y, z, Blocks.dirt);
			if (!world.isRemote) {
				Util.spawnItem(world, x, y, z, new ItemStack(PvZ.sunlight, 1));
			}
			return true;
		}
		if (block == PvZ.darkenedGrass) {
			world.setBlock(x, y, z, Blocks.dirt);
			Util.spawnItem(world, x, y, z, new ItemStack(PvZ.moonlight, 1));
			return true;
		}
		return false;
	}

	public void uproot(ItemStack itemStack, EntityPlayer player,
			EntityPlantBase entity) {
		Util.spawnItem(entity.worldObj, (int) entity.posX,
				(int) entity.posY + 1, (int) entity.posZ, entity.spawnStack);

		itemStack.damageItem(1, player);

		entity.setDead();
	}
}