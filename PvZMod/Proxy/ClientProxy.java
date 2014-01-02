package CountryGamer_PlantsVsZombies.PvZMod.Proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderZombie;
import CountryGamer_PlantsVsZombies.PvZMod.ClientTickHandler;
import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderGreenhouse;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGreenhouse;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelFumeShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelMoonShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelPeaShooter;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelPuffShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelRepeater;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelScaredyShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelSnowPea;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelSunflower;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelThreePeater;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.ModelWalnut;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderAntiCreeper;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderFumeShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderMoonShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderPeaShooter;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderPuffShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderRepeater;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderScaredyShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderSnowPea;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderSunflower;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderThreePeater;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Renders_Models.RenderWalnut;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityCreeperRepeater;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityFumeShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityMoonShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityPeaShooter;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityPuffShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityRepeater;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityScaredyShroom;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntitySnowPea;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntitySunflower;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityThreePeater;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityWalnut;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies.EntityFlagZombie;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies.EntityFootballZombie;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityCreeperPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityMoonlight;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityPeaPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityShroomPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntitySnowPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntitySunlight;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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

		RenderingRegistry.registerEntityRenderingHandler(EntityPeaPod.class,
				new RenderSnowball(PvZ_Main.peaPod));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowPod.class,
				new RenderSnowball(PvZ_Main.snowPod));
		RenderingRegistry.registerEntityRenderingHandler(EntitySunlight.class,
				new RenderSnowball(PvZ_Main.sunlight));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoonlight.class,
				new RenderSnowball(PvZ_Main.moonlight));
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomPod.class,
				new RenderSnowball(PvZ_Main.shroomPod));
		RenderingRegistry
				.registerEntityRenderingHandler(EntityCreeperPod.class,
						new RenderSnowball(PvZ_Main.creeperPod));

	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	public void registerTickHandler() {
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
}