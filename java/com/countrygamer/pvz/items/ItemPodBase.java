package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;

public class ItemPodBase extends ItemBase {
	public ItemPodBase(String modid, String name) {
		super(modid, name);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(Items.stick))) {
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				spawnCustomEntity(world, player);
			}
		}

		return itemStack;
	}

	public void spawnCustomEntity(World world, EntityPlayer player) {
		world.spawnEntityInWorld(new EntitySnowball(world, player));
	}
}