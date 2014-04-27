package com.countrygamer.pvz.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemToolBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityPlantBase;
import com.countrygamer.pvz.lib.Util;

public class ItemTrowel extends ItemToolBase {
	
	public ItemTrowel(String modid, String name, float damageVsEntity,
			Item.ToolMaterial material, Block[] validBlocks) {
		super(modid, name, damageVsEntity, material, validBlocks);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player,
			World world, int x, int y, int z, int side, float xOffset,
			float yOffset, float zOffset) {
		Block block = world.getBlock(x, y, z);
		if (block == PvZ.endowedGrass) {
			world.setBlock(x, y, z, Blocks.dirt);
			Util.spawnItem(world, x, y, z, new ItemStack(PvZ.sunlight, 1));
			return true;
		}
		if (block == PvZ.darkenedGrass) {
			world.setBlock(x, y, z, Blocks.dirt);
			Util.spawnItem(world, x, y, z, new ItemStack(PvZ.moonlight, 1));
			return true;
		}
		return false;
	}

	public boolean itemInteractionForEntity(ItemStack itemStack,
			EntityPlayer player, EntityLivingBase entity) {
		if (entity.worldObj.isRemote)
			return false;

		if ((entity instanceof EntityPlantBase)) {
			uproot(itemStack, player, (EntityPlantBase) entity);
			return true;
		}
		return false;
	}

	public void uproot(ItemStack itemStack, EntityPlayer player,
			EntityPlantBase entity) {
		entity.setDead();
	}
}