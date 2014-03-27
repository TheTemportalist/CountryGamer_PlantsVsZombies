package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.projectiles.EntityCreeperPod;

public class EntityCreeperRepeater extends EntityPlantShooterBase
{
  public EntityCreeperRepeater(World par1World)
  {
    super(par1World, new ItemStack(PvZ.basicPlants, 1, 1));
  }

  public boolean canAttackClass(Class par1Class)
  {
    return (creeperCheck(par1Class)) || (ghastCheck(par1Class));
  }

  public EntityThrowable entitySelect(World world)
  {
    EntityCreeperPod ent = new EntityCreeperPod(world, this);
    return ent;
  }

  public void ai()
  {
    this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.0D, 20, this.range));

    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true, false, IMob.mobSelector));

    this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(10, new EntityAILookIdle(this));
  }
}