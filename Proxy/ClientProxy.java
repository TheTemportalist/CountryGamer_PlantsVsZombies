package com.countrygamer.pvz.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderZombie;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.blocks.tiles.RenderChlorophyllBowl;
import com.countrygamer.pvz.blocks.tiles.RenderGravestone;
import com.countrygamer.pvz.blocks.tiles.RenderGreenhouse;
import com.countrygamer.pvz.blocks.tiles.TileEntityChlorophyllBowl;
import com.countrygamer.pvz.blocks.tiles.TileEntityGravestone;
import com.countrygamer.pvz.blocks.tiles.TileEntityGreenhouse;
import com.countrygamer.pvz.client.render.ModelFumeShroom;
import com.countrygamer.pvz.client.render.ModelMoonShroom;
import com.countrygamer.pvz.client.render.ModelPeaShooter;
import com.countrygamer.pvz.client.render.ModelPuffShroom;
import com.countrygamer.pvz.client.render.ModelRepeater;
import com.countrygamer.pvz.client.render.ModelScaredyShroom;
import com.countrygamer.pvz.client.render.ModelSnowPea;
import com.countrygamer.pvz.client.render.ModelSunflower;
import com.countrygamer.pvz.client.render.ModelThreePeater;
import com.countrygamer.pvz.client.render.ModelWalnut;
import com.countrygamer.pvz.client.render.RenderAntiCreeper;
import com.countrygamer.pvz.client.render.RenderFumeShroom;
import com.countrygamer.pvz.client.render.RenderMoonShroom;
import com.countrygamer.pvz.client.render.RenderPeaShooter;
import com.countrygamer.pvz.client.render.RenderPuffShroom;
import com.countrygamer.pvz.client.render.RenderRepeater;
import com.countrygamer.pvz.client.render.RenderScaredyShroom;
import com.countrygamer.pvz.client.render.RenderSnowPea;
import com.countrygamer.pvz.client.render.RenderSunflower;
import com.countrygamer.pvz.client.render.RenderThreePeater;
import com.countrygamer.pvz.client.render.RenderWalnut;
import com.countrygamer.pvz.entities.mobs.plants.EntityCreeperRepeater;
import com.countrygamer.pvz.entities.mobs.plants.EntityFumeShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityMoonShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityPeaShooter;
import com.countrygamer.pvz.entities.mobs.plants.EntityPuffShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntityRepeater;
import com.countrygamer.pvz.entities.mobs.plants.EntityScaredyShroom;
import com.countrygamer.pvz.entities.mobs.plants.EntitySnowPea;
import com.countrygamer.pvz.entities.mobs.plants.EntitySunflower;
import com.countrygamer.pvz.entities.mobs.plants.EntityThreePeater;
import com.countrygamer.pvz.entities.mobs.plants.EntityWalnut;
import com.countrygamer.pvz.entities.mobs.zombies.EntityExplorerZombie;
import com.countrygamer.pvz.entities.mobs.zombies.EntityFlagZombie;
import com.countrygamer.pvz.entities.mobs.zombies.EntityFootballZombie;
import com.countrygamer.pvz.entities.projectiles.EntityCreeperPod;
import com.countrygamer.pvz.entities.projectiles.EntityMoonlight;
import com.countrygamer.pvz.entities.projectiles.EntityPeaPod;
import com.countrygamer.pvz.entities.projectiles.EntityShroomPod;
import com.countrygamer.pvz.entities.projectiles.EntitySnowPod;
import com.countrygamer.pvz.entities.projectiles.EntitySunlight;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityChlorophyllBowl.class, new RenderChlorophyllBowl());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityGravestone.class, new RenderGravestone());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityGreenhouse.class, new RenderGreenhouse());
		RenderingRegistry.registerEntityRenderingHandler(EntitySunflower.class,
				new RenderSunflower(new ModelSunflower(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPeaShooter.class, new RenderPeaShooter(
						new ModelPeaShooter(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowPea.class,
				new RenderSnowPea(new ModelSnowPea(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRepeater.class,
				new RenderRepeater(new ModelRepeater(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityThreePeater.class, new RenderThreePeater(
						new ModelThreePeater(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPuffShroom.class, new RenderPuffShroom(
						new ModelPuffShroom(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityFumeShroom.class, new RenderFumeShroom(
						new ModelFumeShroom(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityScaredyShroom.class, new RenderScaredyShroom(
						new ModelScaredyShroom(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMoonShroom.class, new RenderMoonShroom(
						new ModelMoonShroom(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityCreeperRepeater.class, new RenderAntiCreeper(
						new ModelRepeater(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWalnut.class,
				new RenderWalnut(new ModelWalnut(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(
				EntityFootballZombie.class, new RenderZombie());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityFlagZombie.class, new RenderZombie());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityExplorerZombie.class, new RenderZombie());

		RenderingRegistry.registerEntityRenderingHandler(EntityPeaPod.class,
				new RenderSnowball(PvZ.peaPod));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowPod.class,
				new RenderSnowball(PvZ.snowPod));
		RenderingRegistry.registerEntityRenderingHandler(EntitySunlight.class,
				new RenderSnowball(PvZ.sunlight));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoonlight.class,
				new RenderSnowball(PvZ.moonlight));
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomPod.class,
				new RenderSnowball(PvZ.shroomPod));
		RenderingRegistry
				.registerEntityRenderingHandler(EntityCreeperPod.class,
						new RenderSnowball(PvZ.creeperPod));

	}

	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	public void registerTickHandler() {
	}
}