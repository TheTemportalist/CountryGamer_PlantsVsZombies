package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntityPeaPod;
import com.countrygamer.pvz.lib.Util;

public class EntityThreePeater extends EntityPlantShooterBase {
	public EntityThreePeater(World par1World) {
		super(par1World, new ItemStack(PvZ.basicPlants, 1, 4));

		setTexture("/mods/CountryGamer_PlantsVsZombies/textures/mobs/ThreePeater.png");
	}

	protected void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.peaPod, 3);
	}

	public EntityThrowable entitySelect(World world) {
		EntityPeaPod ent = new EntityPeaPod(world, this);
		return ent;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityThrowable ent1 = entitySelect(this.worldObj);

		int[] facingA = Util.entityDirectionSpawn(this);
		EntityThrowable ent2;
		EntityThrowable ent3;
		switch (Util.entityDirection(this)) {
		case 0:
			ent2 = new EntityPeaPod(this.worldObj, this,
					this.posX + facingA[0], this.posY, this.posZ);

			ent3 = new EntityPeaPod(this.worldObj, this,
					this.posX + facingA[1], this.posY, this.posZ);

			break;
		case 1:
			ent2 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ + facingA[0]);

			ent3 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ + facingA[1]);

			break;
		case 2:
			ent2 = new EntityPeaPod(this.worldObj, this,
					this.posX + facingA[0], this.posY, this.posZ);

			ent3 = new EntityPeaPod(this.worldObj, this,
					this.posX + facingA[1], this.posY, this.posZ);

			break;
		case 3:
			ent2 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ + facingA[0]);

			ent3 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ + facingA[1]);

			break;
		default:
			ent2 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ);

			ent3 = new EntityPeaPod(this.worldObj, this, this.posX, this.posY,
					this.posZ);
		}

		double toX = entitylivingbase.posX - this.posX;
		float percentToMouth = 0.5F;
		double toY = entitylivingbase.posY + this.height * percentToMouth
				- 1.0D - ent1.posY;
		double toZ = entitylivingbase.posZ - this.posZ;
		float f1 = MathHelper.sqrt_double(toX * toX + toZ * toZ) * 0.2F;

		double podOffset = 0.7D;
		ent1.setThrowableHeading(toX, toY + f1, toZ, 1.6F, 12.0F);
		ent2.setThrowableHeading(toX + podOffset, toY + f1, toZ + podOffset,
				1.6F, 12.0F);
		ent3.setThrowableHeading(toX - podOffset, toY + f1, toZ - podOffset,
				1.6F, 12.0F);

		playSound("random.bow", 1.0F,
				1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(ent1);
		this.worldObj.spawnEntityInWorld(ent2);
		this.worldObj.spawnEntityInWorld(ent3);

		Util.entityDirectionSpawn(this);
	}
}