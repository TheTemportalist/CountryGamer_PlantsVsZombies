package com.countrygamer.pvz.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityWalnut;

public class ItemWalnut extends ItemBase {
	public ItemWalnut(String modid, String name) {
		super(modid, name);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player,
			World world, int x, int y, int z, int side, float xOffset,
			float yOffset, float zOffset) {
		Block block = world.getBlock(x, y, z);
		if ((world.getBlock(x, y + 1, z) == null)
				&& ((block == Blocks.grass) || (block == Blocks.dirt)
						|| (block == PvZ.endowedGrass) || (block == PvZ.darkenedGrass))) {
			if ((player.capabilities.isCreativeMode)
					|| (player.inventory.consumeInventoryItem(this))) {
				EntityLivingBase ent = new EntityWalnut(world);
				ent.setLocationAndAngles(x + 0.5D, y + 1, z + 0.5D, 0.0F, 0.0F);
				if (!world.isRemote)
					world.spawnEntityInWorld(ent);
			}
			return true;
		}
		return false;
	}
}