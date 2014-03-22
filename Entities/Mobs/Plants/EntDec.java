package com.countrygamer.pvz.entities.mobs.plants;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.MovingObjectPosition;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.entities.mobs.zombies.Zombies;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntDec {
	public static ArrayList<Class<?>> entList = new ArrayList<Class<?>>();

	public static int mobID = 500;
	public static int primaryColor;

	public static void mobEnts() {
		basicDay();
		basicNight();

		Zombies.zombies(mobID);
	}

	public static void basicDay() {
		primaryColor = 293396;

		EntDec.createPlant(mobID++, EntitySunflower.class, "Sunflower", 16771584);
		EntDec.createPlant(mobID++, EntityPeaShooter.class, "PeaShooter", 65314);
		EntDec.createPlant(mobID++, EntitySnowPea.class, "SnowPea", 4571647);
		EntDec.createPlant(mobID++, EntityRepeater.class, "Repeater", 1429248);
		EntDec.createPlant(mobID++, EntityThreePeater.class, "ThreePeater", 1802268);
		
	}

	public static void basicNight() {
		primaryColor = 8531665;
		
		EntDec.createPlant(mobID++, EntityPuffShroom.class, "PuffShroom", 1802268);
		EntDec.createPlant(mobID++, EntityFumeShroom.class, "FumeShroom", 1802268);
		EntDec.createPlant(mobID++, EntityScaredyShroom.class, "ScaredyShroom", 1802268);
		EntDec.createPlant(mobID++, EntityMoonShroom.class, "MoonShroom", 16771584);
		
	}

	public static void pool() {
	}

	public static void roof() {
	}

	public static void special() {
		primaryColor = 293396;
		
		EntDec.createPlant(mobID++, EntityCreeperRepeater.class, "Creeper", 16711680);
		EntDec.createPlant(mobID++, EntityWalnut.class, "Walnut", 16711680);
		
	}

	public static boolean entityUndeadCheck(MovingObjectPosition movObjPos) {
		boolean result = false;
		if ((movObjPos.entityHit instanceof EntityZombie)) {
			result = true;
		}
		if ((movObjPos.entityHit instanceof EntitySkeleton)) {
			result = true;
		}
		if ((movObjPos.entityHit instanceof EntityPigZombie)) {
			result = true;
		}
		if ((!(movObjPos.entityHit instanceof EntityBlaze))
				|| ((!(movObjPos.entityHit instanceof EntityWitherSkull)) || ((!(movObjPos.entityHit instanceof EntityWither)) || ((movObjPos.entityHit instanceof EntityGhast)))))
			;
		return result;
	}

	public static void createPlant(int id, Class<? extends Entity> entityClass,
			String name, int secondaryColor) {
		EntityRegistry.registerModEntity(entityClass, name, id, PvZ.instance,
				80, 3, true);
		EntityList.IDtoClassMapping.put(id, entityClass);
		EntityList.entityEggs.put(id, new EntityEggInfo(id,
				primaryColor, secondaryColor));
	}

}