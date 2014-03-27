package com.countrygamer.pvz.entities.mobs.zombies;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityExplorerZombie extends EntityZombie {

	public EntityExplorerZombie(World world) {
		super(world);

		this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_chestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_leggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_boots));
		this.setCurrentItemOrArmor(0, new ItemStack(Blocks.torch));

	}

}
