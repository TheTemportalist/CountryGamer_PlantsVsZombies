package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.countrygamer.pvz.ParticleEffects;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntDec;

public class EntityPodBase extends EntityThrowable {
	protected EntityLivingBase g;
	public byte damage = (byte) PvZ.basePodDamage;
	public boolean toDamage = true;

	public EntityPodBase(World world) {
		super(world);
	}

	public EntityPodBase(World world, EntityLivingBase entLiv) {
		super(world, entLiv);
		this.g = entLiv;
	}

	public EntityPodBase(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public boolean canAttackWithItem() {
		return false;
	}

	public byte getDamage() {
		return this.damage;
	}

	protected float getGravityVelocity() {
		return 0.01F;
	}

	protected void onImpact(MovingObjectPosition movObjPos) {
		setDamage();

		if ((this.g instanceof EntityPlayer)) {
			this.damage = (byte) (this.damage * 4);
		}

		if ((this instanceof EntityCreeperPod)) {
			damageType(movObjPos);
		}
		Entity ent = movObjPos.entityHit;
		if ((ent != null) && ((ent instanceof EntityLiving))) {
			if (((EntityLiving) ent).getCreatureAttribute() == PvZ.plantAttribute) {
				this.damage = 0;
				this.toDamage = false;
			} else if (EntDec.entityUndeadCheck(movObjPos)) {
				this.damage = (byte) (this.damage * 2);
				this.toDamage = true;
			} else if ((ent instanceof EntityPlayer)) {
				this.damage = 0;
				this.toDamage = false;
			} else if ((ent instanceof EntityVillager)) {
				this.damage = 0;
				this.toDamage = false;
				int x = (int) ((EntityLiving) ent).posX;
				int y = (int) ((EntityLiving) ent).posY;
				int z = (int) ((EntityLiving) ent).posZ;

				ent.setCurrentItemOrArmor(0,
						new ItemStack(Blocks.red_flower, 1));
			} else if (!(ent instanceof EntityIronGolem)) {
				this.toDamage = true;
				altCheck(ent);
			}

			if (this.toDamage == true) {
				damageType(movObjPos);
			}

			if (((EntityLiving) ent).getCreatureAttribute() != PvZ.plantAttribute) {
				if ((altCheck(ent)) && (!this.worldObj.isRemote)) {
					double x = this.posX;
					double y = this.posY;
					double z = this.posZ;

					ParticleEffects.spawnParticle("pod-pop", x, y, z, 0.0D,
							0.0D, 0.0D);
					setDead();
				}
			}
		}
	}

	public void setDamage() {
		this.damage = (byte) PvZ.basePodDamage;
		this.toDamage = true;
	}

	public void damageType(MovingObjectPosition movObjPos) {
	}

	public boolean altCheck(Entity ent) {
		if ((ent instanceof EntityCreeper)) {
			this.toDamage = false;
			return false;
		}
		if ((ent instanceof EntityGhast)) {
			this.toDamage = false;
			return false;
		}
		return true;
	}

	public void impactExtra() {
	}
}