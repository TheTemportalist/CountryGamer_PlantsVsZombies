package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies;

import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntDec;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class Zombies
{
  public static int primaryColor = 2999465;
  public static int mobID = 100;

  public static void zombies(int mobid) {
    mobID = mobid;

    BiomeGenBase[] spawnBiomes = { BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.hell, BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.beach };

    EntityRegistry.registerGlobalEntityID(EntityFootballZombie.class, "Football Zombie", ++mobID);
    EntityRegistry.addSpawn(EntityFootballZombie.class, 20, 2, 6, EnumCreatureType.monster, spawnBiomes);

    EntityRegistry.findGlobalUniqueEntityId();
    EntDec.registerEntityEgg(EntityFootballZombie.class, primaryColor, 16711680);
    RenderingRegistry.registerEntityRenderingHandler(EntityFootballZombie.class, new RenderZombie());
    LanguageRegistry.instance().addStringLocalization("entity.Football Zombie.name", "Football Zombie");

    EntityRegistry.registerGlobalEntityID(EntityFlagZombie.class, "Flag Zombie", ++mobID);
    EntityRegistry.addSpawn(EntityFlagZombie.class, 20, 2, 6, EnumCreatureType.monster, spawnBiomes);

    EntityRegistry.findGlobalUniqueEntityId();
    EntDec.registerEntityEgg(EntityFlagZombie.class, primaryColor, 0);
    RenderingRegistry.registerEntityRenderingHandler(EntityFlagZombie.class, new RenderZombie());
    LanguageRegistry.instance().addStringLocalization("entity.Flag Zombie.name", "Flag Zombie");

    mobid = mobID;
  }
}