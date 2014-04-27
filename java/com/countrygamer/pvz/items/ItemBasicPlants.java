package com.countrygamer.pvz.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemMetadataBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityPeaShooter;
import com.countrygamer.pvz.entities.mobs.plants.EntityRepeater;
import com.countrygamer.pvz.entities.mobs.plants.EntitySnowPea;
import com.countrygamer.pvz.entities.mobs.plants.EntitySunflower;
import com.countrygamer.pvz.entities.mobs.plants.EntityThreePeater;
import com.countrygamer.pvz.lib.Util;

public class ItemBasicPlants extends ItemMetadataBase {
	public static final String[] itemGameNames = { "Sunflower",
			"Pea Shooter", "Snow Pea", "Repeater",
			"Three-Peater" };

	public boolean onGround = true;

	public ItemBasicPlants(String modid) {
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
			ent = new EntitySunflower(world);
			break;
		case 1:
			ent = new EntityPeaShooter(world);
			break;
		case 2:
			ent = new EntitySnowPea(world);
			break;
		case 3:
			ent = new EntityRepeater(world);
			break;
		case 4:
			ent = new EntityThreePeater(world);
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
			if ((blockUnder == PvZ.endowedGrass)
					|| (blockUnder == Blocks.waterlily)) {
				if (blockUnder == PvZ.endowedGrass)
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