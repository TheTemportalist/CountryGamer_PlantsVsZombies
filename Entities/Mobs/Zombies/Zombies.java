package com.countrygamer.pvz.entities.mobs.zombies;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.countrygamer.pvz.PvZ;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Zombies {
	public static int primaryColor = 2999465;
	public static int mobID = 100;
	public static BiomeGenBase[] spawnBiomes = { BiomeGenBase.desert,
			BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.hell,
			BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.swampland,
			BiomeGenBase.plains, BiomeGenBase.beach };

	public static void zombies(int mobid) {
		mobID = mobid;
		
		Zombies.createZombie("Football", EntityFootballZombie.class, mobID++, 16711680);
		Zombies.createZombie("Flag", EntityFlagZombie.class, mobID++, 0);
		Zombies.createZombie("Explorer", EntityExplorerZombie.class, mobID++, 0);
		
		mobid = mobID;
	}

	public static void createZombie(String name,
			Class<? extends EntityLiving> entityClass, int id,
			int secondaryColor) {
		EntityRegistry.registerModEntity(entityClass, name, id, PvZ.instance,
				80, 3, true);
		EntityList.IDtoClassMapping.put(id, entityClass);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id,
				primaryColor, secondaryColor));
		EntityRegistry.addSpawn(entityClass, 20, 2, 6,
				EnumCreatureType.monster, spawnBiomes);

	}

}