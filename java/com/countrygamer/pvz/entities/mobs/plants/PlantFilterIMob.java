package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;

public class PlantFilterIMob implements IEntitySelector {

	@Override
	public boolean isEntityApplicable(Entity entity) {
		return entity instanceof EntityMob ||
				entity instanceof EntitySpider;
	}

}
