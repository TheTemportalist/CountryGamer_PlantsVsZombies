package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;
import com.countrygamer.pvz.PvZ;

public class ItemChlorophyllBowl extends ItemBase {
	public ItemChlorophyllBowl(String modid, String name) {
		super(modid, name);
	}

	public boolean onItemUse(ItemStack item, EntityPlayer player, World world,
			int x, int y, int z, int side, float xOffset, float yOffset,
			float zOffset) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(this))) {
			if ((world.getBlock(x, y + 1, z) == null) && (!world.isRemote)) {
				world.setBlock(x, y + 1, z, PvZ.chlorophyllBowl);
			}

		}

		return true;
	}
}