package com.countrygamer.pvz.items;

import net.minecraft.item.ItemArmor;

import com.countrygamer.core.Base.common.item.ItemArmorBase;

public class ItemFootballChest extends ItemArmorBase {
	public ItemFootballChest(String modid, String name,
			ItemArmor.ArmorMaterial mat, int slot, int armorType) {
		super(modid, name, mat, slot, armorType, "football_layer_1");
	}
}