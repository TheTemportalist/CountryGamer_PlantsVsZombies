package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.countrygamer.pvz.entities.projectiles.EntityShroomPod;

public class EntityShroomShooterBase extends EntityShroomBase
  implements IRangedAttackMob
{
  public EntityShroomShooterBase(World par1World, ItemStack spawnStack)
  {
    super(par1World, spawnStack);
  }

  public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f)
  {
    if (entitySelect(this.worldObj) != null) {
      EntityThrowable ent = entitySelect(this.worldObj);
      double toX = entitylivingbase.posX - this.posX;
      float percentToMouth = 0.5F;
      double toY = entitylivingbase.posY + this.height * percentToMouth - 1.0D - ent.posY;
      double toZ = entitylivingbase.posZ - this.posZ;
      float f1 = MathHelper.sqrt_double(toX * toX + toZ * toZ) * 0.2F;
      ent.setThrowableHeading(toX, toY + f1, toZ, 1.6F, 12.0F);
      playSound("random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
      this.worldObj.spawnEntityInWorld(ent);
    }
  }

  public void ai()
  {
    this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.25D, 20, 10.0F));
    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true, false, IMob.mobSelector));

    this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(10, new EntityAILookIdle(this));
  }

  public EntityThrowable entitySelect(World world)
  {
    EntityThrowable ent;
    if (!this.worldObj.isDaytime())
      ent = new EntityShroomPod(world, this);
    else {
      ent = null;
    }
    return ent;
  }
}