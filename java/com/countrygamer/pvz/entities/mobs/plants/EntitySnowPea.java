package com.countrygamer.pvz.entities.mobs.plants;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntitySnowPod;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySnowPea extends EntityPlantShooterBase {
	public EntitySnowPea(World par1World) {
		super(par1World, new ItemStack(PvZ.basicPlants, 1, 2));

		setTexture("/mods/CountryGamer_PlantsVsZombies/textures/mobs/Snow Pea.png");
	}

	protected Item getDropItem() {
		return PvZ.snowPod;
	}

	public EntityThrowable entitySelect(World world) {
		EntitySnowPod ent = new EntitySnowPod(world, this);
		return ent;
	}
}