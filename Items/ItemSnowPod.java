package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntitySnowPod;

public class ItemSnowPod extends ItemPodBase {
	public ItemSnowPod(String modid, String name) {
		super(modid, name);
	}

	public void spawnCustomEntity(World world, EntityPlayer player) {
		world.spawnEntityInWorld(new EntitySnowPod(world, player));
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(PvZ.snowPod))) {
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				spawnCustomEntity(world, player);
			}
		}

		return itemStack;
	}
}