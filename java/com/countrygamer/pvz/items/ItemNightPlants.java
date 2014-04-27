package com.countrygamer.pvz.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemMetadataBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityFumeShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityMoonShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityPuffShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityScaredyShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntitySunflower;
import com.countrygamer.pvz.lib.Util;

public class ItemNightPlants extends ItemMetadataBase {
	public static final String[] itemGameNames = { "Puff-shroom Plant",
			"Scaredy-shroom Plant", "Fume-shroom Plant", "Moon-shroom Plant" };

	public boolean onGround = false;

	public ItemNightPlants(String modid) {
		super(modid, itemGameNames);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player,
			World world, int x, int y, int z, int side, float xOffset,
			float yOffset, float zOffset) {
		EntityLiving ent = null;

		if (!player.canPlayerEdit(x, y, z, side, itemStack)) {
			return false;
		}
		switch (itemStack.getItemDamage()) {
		case 0:
			ent = new EntityPuffShroom(world);
			break;
		case 1:
			ent = new EntityScaredyShroom(world);
			break;
		case 2:
			ent = new EntityFumeShroom(world);
			break;
		case 3:
			ent = new EntityMoonShroom(world);
			break;
		default:
			ent = new EntitySunflower(world);
		}

		baseItemUse(world, player, x, y, z, ent, itemStack);
		return true;
	}

	public void baseItemUse(World world, EntityPlayer player, int x, int y,
			int z, EntityLiving par0Entity, ItemStack itemStack) {
		EntityLiving ent = par0Entity;
		if (world.getBlock(x, y + 1, z) == Blocks.air) {
			Block blockUnder = world.getBlock(x, y, z);
			if ((blockUnder == PvZ.darkenedGrass)
					|| (blockUnder == Blocks.waterlily)) {
				if (blockUnder == PvZ.darkenedGrass)
					this.onGround = true;
				if (blockUnder == Blocks.waterlily)
					this.onGround = false;
				if (player.capabilities.isCreativeMode) {
					itemUsed(ent, x, y, z, world);
				} else {
					ItemStack thisItem = new ItemStack(this, 1,
							itemStack.getItemDamage());
					if (player.inventory.hasItemStack(thisItem)) {
						Util.removeItem(player, thisItem);
						itemUsed(ent, x, y, z, world);
					}
				}
			}
		}
	}

	public void itemUsed(EntityLiving ent, int x, int y, int z, World world) {
		if (this.onGround) {
			ent.setLocationAndAngles(x + 0.5D, y + 1, z + 0.5D, 0.0F, 0.0F);

			if (!world.isRemote) {
				world.spawnEntityInWorld(ent);
				world.setBlock(x, y, z, Blocks.grass);
			}
		} else {
			ent.setLocationAndAngles(x + 0.5D, y, z + 0.5D, 0.0F, 0.0F);

			if (!world.isRemote)
				world.spawnEntityInWorld(ent);
		}
	}
}