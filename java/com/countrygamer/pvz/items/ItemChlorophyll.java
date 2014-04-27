package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;

public class ItemChlorophyll extends ItemBase {
	public ItemChlorophyll(String modid, String name) {
		super(modid, name);
	}

	public boolean onItemUse(ItemStack item, EntityPlayer player, World world,
			int x, int y, int z, int side, float xOffset, float yOffset,
			float zOffset) {
		if ((player.capabilities.isCreativeMode)
				|| (player.inventory.consumeInventoryItem(this))) {
			if (world.getBlock(x, y + 1, z) == Blocks.water) {
				//world.setBlock(x, y + 1, z, PvZ.chlorophyllLiquidStill);
				return true;
			}
			return false;
		}

		return false;
	}
}