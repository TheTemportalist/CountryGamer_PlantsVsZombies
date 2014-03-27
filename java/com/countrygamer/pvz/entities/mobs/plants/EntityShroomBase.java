package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.countrygamer.pvz.lib.Resources;

public class EntityShroomBase extends EntityPlantBase
{
  public ResourceLocation rl_0;
  public ResourceLocation rl_1;
  public ResourceLocation renderRL = Resources.puffShroomMob_0;

  public EntityShroomBase(World world, ItemStack spawnStack) {
    super(world, spawnStack);

    if (!this.worldObj.isDaytime())
      ai();
  }

  protected int getDropItemId()
  {
    return 0;
  }
  public void ai() {
    this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(10, new EntityAILookIdle(this));
  }
}