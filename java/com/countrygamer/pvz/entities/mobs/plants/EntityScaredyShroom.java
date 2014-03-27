package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityScaredyShroom extends EntityShroomShooterBase {
	public EntityScaredyShroom(World world) {
		super(world, new ItemStack(PvZ.nightPlants, 1, 1));
	}

	public void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.shroomPod, 2);
	}
}