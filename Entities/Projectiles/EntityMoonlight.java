package com.countrygamer.pvz.entities.projectiles;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.lib.Util;

public class EntityMoonlight extends EntityPodBase {
	public byte damage = 2;
	public boolean toDamage = false;
	public EntityLivingBase target = null;

	public EntityMoonlight(World world) {
		super(world);
	}

	public EntityMoonlight(World world, EntityLivingBase entLiv) {
		super(world, entLiv);
	}

	public EntityMoonlight(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public boolean canAttackWithItem() {
		return false;
	}

	protected float getGravityVelocity() {
		return 0.01F;
	}

	protected void onImpact(MovingObjectPosition movObjPos) {
		int x = movObjPos.blockX;
		int y = movObjPos.blockY;
		int z = movObjPos.blockZ;
		World world = this.worldObj;
		EntityPlayer player = (EntityPlayer) getThrower();
		Random itemRand = new Random();

		Block block = world.getBlock(x, y, z);
		if ((block == Blocks.dirt) || (block == Blocks.grass)
				|| (block == Blocks.mycelium)) {
			world.setBlock(x, y, z, PvZ.darkenedGrass);
			setDead();
			return;
		}
		if (block == PvZ.endowedGrass) {
			Util.spawnItem(world, x, y, z, new ItemStack(PvZ.sunlight, 1));
			world.setBlock(x, y, z, PvZ.darkenedGrass);
			setDead();
			return;
		}
		Util.spawnItem(world, x, y, z, new ItemStack(PvZ.moonlight, 1));
		setDead();
	}
}