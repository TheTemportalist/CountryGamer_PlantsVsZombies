package com.countrygamer.pvz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;
import com.countrygamer.pvz.PvZ;

public class ItemGuideBook extends ItemBase {
	public ItemGuideBook(String modid, String name) {
		super(modid, name);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (world.isRemote) {
			player.openGui(PvZ.instance, 3, world, (int) player.posX,
					(int) player.posY, (int) player.posZ);
		}

		return itemStack;
	}
}