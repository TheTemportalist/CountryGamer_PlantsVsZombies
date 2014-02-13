package com.countrygamer.pvz.handlers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.plants.EntityPlantBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase targetEntity = event.entityLiving;

		if (targetEntity.isPotionActive(PvZ.empower)) {
			if ((targetEntity.worldObj.rand.nextInt(20) != 0)
					|| (targetEntity.getCreatureAttribute() == PvZ.plantAttribute)) {
				((EntityPlantBase) targetEntity)
				.heal(((EntityPlantBase) targetEntity).getMaxHealth());
			} else if (!(targetEntity instanceof EntityZombie)) {
				if ((targetEntity instanceof EntityPlayer)) {
					((EntityPlayer) targetEntity)
					.heal(((EntityPlayer) targetEntity).getMaxHealth());
				}

			}

			if (targetEntity.getActivePotionEffect(PvZ.empower).getDuration() == 0) {
				targetEntity.removePotionEffect(PvZ.empower.id);
				return;
			}
		}
	}
}