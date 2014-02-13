package com.countrygamer.pvz.entities.mobs.plants;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntityPeaPod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPeaShooter extends EntityPlantShooterBase {
	public EntityPeaShooter(World par1World) {
		super(par1World, new ItemStack(PvZ.basicPlants, 1, 1));

		setTexture("/mods/CountryGamer_PlantsVsZombies/textures/mobs/Pea Shooter.png");
	}

	protected Item getDropItem() {
		return PvZ.peaPod;
	}

	public boolean interact(EntityPlayer par1EntityPlayer) {
		return false;
	}

	public EntityThrowable entitySelect(World world) {
		EntityPeaPod ent = new EntityPeaPod(world, this);
		return ent;
	}
}