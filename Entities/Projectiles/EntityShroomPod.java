package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShroomPod extends EntityPodBase
{
  public EntityShroomPod(World world)
  {
    super(world);
  }
  public EntityShroomPod(World world, EntityLivingBase entLiv) {
    super(world, entLiv);
  }
  public EntityShroomPod(World world, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
  }

  public void setDamage()
  {
    this.damage = (byte)(this.damage / 4);
    this.toDamage = true;
    if (!this.worldObj.isDaytime())
      this.damage = (byte)(this.damage * 2);
  }

  public void damageType(MovingObjectPosition movObjPos)
  {
    movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), this.damage);
  }
}