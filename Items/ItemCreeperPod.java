package com.countrygamer.pvz.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntityCreeperPod;

public class ItemCreeperPod extends ItemPodBase {
	public ItemCreeperPod(String modid, String name) {
		super(modid, name);
	}

	public void spawnCustomEntity(World world, EntityPlayer player) {
		world.spawnEntityInWorld(new EntityCreeperPod(world, player));
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(PvZ.creeperPod))) {
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / ((new Random()).nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				spawnCustomEntity(world, player);
			}
		}

		return itemStack;
	}
}