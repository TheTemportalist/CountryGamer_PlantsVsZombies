package com.countrygamer.pvz.entities.mobs.plants;

import com.countrygamer.pvz.PvZ;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityScaredyShroom extends EntityShroomShooterBase {
	public EntityScaredyShroom(World world) {
		super(world, new ItemStack(PvZ.nightPlants, 1, 1));
	}

	public void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.shroomPod, 2);
	}
}