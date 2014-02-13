package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityFumeShroom extends EntityShroomShooterBase
{
  public int min = 1; public int max = 6;

  public EntityFumeShroom(World world) { super(world, new ItemStack(PvZ.nightPlants, 1, 2));
  }

  public void dropFewItems(boolean par1, int par2)
  {
    int numbPods = this.min + (int)(Math.random() * (this.max - this.min + 1));

    dropItem(PvZ.shroomPod, numbPods);
  }

  public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f)
  {
    if (entitySelect(this.worldObj) != null)
    {
      int numbPods = this.min + (int)(Math.random() * (this.max - this.min + 1));
      for (int i = 0; i < numbPods; i++) {
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
  }
}