package com.countrygamer.pvz.entities.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySnowPod extends EntityPodBase
{
  public int freezeLength = 200; public int freezeStrength = 1;

  public EntitySnowPod(World world)
  {
    super(world);
  }
  public EntitySnowPod(World world, EntityLivingBase entLiv) {
    super(world, entLiv);
  }
  public EntitySnowPod(World world, double par2, double par4, double par6) {
    super(world, par2, par4, par6);
  }

  public void setDamage()
  {
    this.damage = (byte)(this.damage / 2);
    this.toDamage = true;
  }

  public void damageType(MovingObjectPosition movObjPos)
  {
    ((EntityLiving)movObjPos.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), this.freezeLength * 2, this.freezeStrength * 2));

    movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), this.damage);
  }
}