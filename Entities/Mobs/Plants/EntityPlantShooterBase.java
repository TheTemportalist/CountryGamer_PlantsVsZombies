package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlantShooterBase extends EntityPlantBase implements
		IRangedAttackMob {
	public EntityPlantShooterBase(World world, ItemStack spawnStack) {
		super(world, spawnStack);
		ai();
	}

	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityThrowable ent = entitySelect(this.worldObj);
		double toX = entitylivingbase.posX - this.posX;
		float percentToMouth = 0.5F;
		double toY = entitylivingbase.posY + this.height * percentToMouth
				- 1.0D - ent.posY;
		double toZ = entitylivingbase.posZ - this.posZ;
		float f1 = MathHelper.sqrt_double(toX * toX + toZ * toZ) * 0.2F;
		ent.setThrowableHeading(toX, toY + f1, toZ, 1.6F, 12.0F);
		playSound("random.bow", 1.0F,
				1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(ent);
		if (entitylivingbase instanceof EntityCreature) {
			((EntityCreature) entitylivingbase).setAttackTarget(this);
		}
	}

	public EntityThrowable entitySelect(World world) {
		EntitySnowball ent = new EntitySnowball(world, this);
		return ent;
	}

	public void ai() {
		this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.0D, 35,
				this.range));

		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this,
				EntityLivingBase.class, 0, true, false, new PlantFilterIMob()));
		// this.targetTasks.addTask(1, new EntityAIPlantTarget(this, true,
		// false,
		// EntityLivingBase.class, PlantFilterIMob.selector, this.range));

		this.tasks.addTask(9, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
	}
}