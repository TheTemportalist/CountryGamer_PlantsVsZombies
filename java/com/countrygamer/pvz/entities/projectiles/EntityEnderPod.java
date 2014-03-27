package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnderPod extends EntityPodBase
{
  public EntityEnderPod(World world)
  {
    super(world);
  }
  public EntityEnderPod(World world, EntityLivingBase entLiv) {
    super(world, entLiv);
  }
  public EntityEnderPod(World world, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
  }
  public EntityEnderPod(World world, EntityLivingBase entLiv, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
    this.g = entLiv;
  }

  public void damageType(MovingObjectPosition movObjPos)
  {
    if ((movObjPos.entityHit instanceof EntityEnderman)) {
      setDead();
      float maxHealth = ((EntityEnderman)movObjPos.entityHit).getMaxHealth();
      movObjPos.entityHit.attackEntityFrom(DamageSource.drown, maxHealth);
    }
  }
}