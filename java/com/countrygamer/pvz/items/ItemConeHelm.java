package com.countrygamer.pvz.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.countrygamer.core.Base.common.item.ItemArmorBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemConeHelm extends ItemArmorBase {
	public ItemConeHelm(String name, String modid, ItemArmor.ArmorMaterial mat,
			int slot, int armorType) {
		super(modid, name, mat, slot, armorType, "");
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) {
		return null;
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return null;
	}
}