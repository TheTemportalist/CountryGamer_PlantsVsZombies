package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntitySunlight;

public class ItemSunlight extends ItemBase {
	public ItemSunlight(String modid, String name) {
		super(modid, name);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(PvZ.sunlight))) {
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntitySunlight(world, player));
			}
		}

		return itemStack;
	}
}