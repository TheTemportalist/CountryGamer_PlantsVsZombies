package com.countrygamer.pvz.entities.mobs.zombies;

import com.countrygamer.pvz.PvZ;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFootballZombie extends EntityZombie
{
  public EntityFootballZombie(World par1World)
  {
    super(par1World);

    setCurrentItemOrArmor(4, new ItemStack(PvZ.footballHelm));
    setCurrentItemOrArmor(3, new ItemStack(PvZ.footballChest));
    setCurrentItemOrArmor(2, new ItemStack(PvZ.footballLegs));
    setCurrentItemOrArmor(1, new ItemStack(PvZ.footballBoots));
  }
}