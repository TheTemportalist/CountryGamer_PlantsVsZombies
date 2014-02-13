package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntityShroomPod;

public class ItemShroomPod extends ItemPodBase {
	public ItemShroomPod(String modid, String name) {
		super(modid, name);
	}

	public void spawnCustomEntity(World world, EntityPlayer player) {
		world.spawnEntityInWorld(new EntityShroomPod(world, player));
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(PvZ.shroomPod))) {
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				spawnCustomEntity(world, player);
			}
		}

		return itemStack;
	}
}