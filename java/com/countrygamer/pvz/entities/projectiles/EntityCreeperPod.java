package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityCreeperRepeater;

public class EntityCreeperPod extends EntityPodBase {
	public EntityCreeperPod(World world) {
		super(world);
	}

	public EntityCreeperPod(World world, EntityLivingBase entLiv) {
		super(world, entLiv);
	}

	public EntityCreeperPod(World world, double par2, double par4, double par6) {
		super(world, par2, par4, par6);
	}

	public void damageType(MovingObjectPosition movObjPos) {
		double damageMult = 0.5D;
		double damageMult2 = 4.0D;

		Entity ent = movObjPos.entityHit;
		boolean hitSomething = false;
		if ((ent instanceof EntityCreeper)) {
			this.toDamage = true;

			this.damage = (byte) (int) (damageMult * ((EntityCreeper) ent)
					.getMaxHealth());
		} else if ((ent instanceof EntityGhast)) {
			this.toDamage = true;
			this.damage = (byte) (int) (this.damage * damageMult2);

			if (this.damage >= ((EntityGhast) ent).getHealth()) {
				ent.setDead();
			}
			int x = (int) this.g.posX;
			int y = (int) this.g.posY;
			int z = (int) this.g.posZ;
			for (ItemStack itemStack : ghastDrops(0))
				;
		} else if ((ent instanceof EntityLivingBase)) {
			this.toDamage = false;
			hitSomething = true;
		} else if (!hitSomething) {
			impactExtra();
		}

		if ((movObjPos.entityHit != null) && (this.toDamage))
			movObjPos.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, getThrower()),
					this.damage);
	}

	public void impactExtra() {
		if (this.g != null) {
			if (!(this.g instanceof EntityCreeperRepeater)) {
				float explosionRadius = (float) PvZ.creeperPodRad;
				this.worldObj.createExplosion(this, this.posX, this.posY,
						this.posZ, explosionRadius, true);
				setDead();
			}
		}
	}

	private ItemStack[] ghastDrops(int par2) {
		int j = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);

		int tear = 0;
		for (int k = 0; k < j; k++)
			tear++;

		int powder = 0;
		j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		for (int k = 0; k < j; k++)
			powder++;

		ItemStack[] ghastDrops = { new ItemStack(Items.ghast_tear, tear),
				new ItemStack(Items.gunpowder, powder + 1) };

		return ghastDrops;
	}

	public boolean altCheck(Entity ent) {
		if ((ent instanceof EntityCreeper)) {
			this.toDamage = true;
			return true;
		}
		if ((ent instanceof EntityGhast)) {
			this.toDamage = true;
			return true;
		}
		return false;
	}
}