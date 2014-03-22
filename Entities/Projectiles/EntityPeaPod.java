package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPeaPod extends EntityPodBase
{
  public EntityPeaPod(World world)
  {
    super(world);
  }
  public EntityPeaPod(World world, EntityLivingBase entLiv) {
    super(world, entLiv);
  }
  public EntityPeaPod(World world, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
  }
  public EntityPeaPod(World world, EntityLivingBase entLiv, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
    this.g = entLiv;
  }

  public void damageType(MovingObjectPosition movObjPos)
  {
    movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), this.damage);
  }
}