package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants;

import java.util.ArrayList;

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
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies.Zombies;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntDec
{
  public static int startEntityId = 300;
  public static ArrayList<Class> entList = new ArrayList();

  public static int mobID = 0;
  public static int primaryColor;

  public static void mobEnts()
  {
    basicDay();
    basicNight();

    Zombies.zombies(mobID);
  }

  public static void basicDay() {
    primaryColor = 293396;

    EntityRegistry.registerGlobalEntityID(EntitySunflower.class, "Sunflower", ++mobID);
    EntityRegistry.addSpawn(EntitySunflower.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntitySunflower.class, primaryColor, 16771584);
    LanguageRegistry.instance().addStringLocalization("entity.Sunflower.name", "Sunflower");

    EntityRegistry.registerGlobalEntityID(EntityPeaShooter.class, "Pea Shooter", ++mobID);
    EntityRegistry.addSpawn(EntityPeaShooter.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityPeaShooter.class, primaryColor, 65314);
    LanguageRegistry.instance().addStringLocalization("entity.Pea Shooter.name", "Pea Shooter");

    EntityRegistry.registerGlobalEntityID(EntitySnowPea.class, "SnowPea", ++mobID);
    EntityRegistry.addSpawn(EntitySnowPea.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntitySnowPea.class, primaryColor, 4571647);
    LanguageRegistry.instance().addStringLocalization("entity.SnowPea.name", "Snow Pea");

    EntityRegistry.registerGlobalEntityID(EntityRepeater.class, "Repeater", ++mobID);
    EntityRegistry.addSpawn(EntityRepeater.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityRepeater.class, primaryColor, 1429248);
    LanguageRegistry.instance().addStringLocalization("entity.Repeater.name", "Repeater");

    EntityRegistry.registerGlobalEntityID(EntityThreePeater.class, "Three-Peater", ++mobID);
    EntityRegistry.addSpawn(EntityThreePeater.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityThreePeater.class, primaryColor, 1802268);
    LanguageRegistry.instance().addStringLocalization("entity.Three-Peater.name", "Three-Peater");
  }
  public static void basicNight() {
    primaryColor = 8531665;

    EntityRegistry.registerGlobalEntityID(EntityPuffShroom.class, "PuffShroom", ++mobID);
    EntityRegistry.addSpawn(EntityPuffShroom.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityPuffShroom.class, primaryColor, 1802268);
    LanguageRegistry.instance().addStringLocalization("entity.PuffShroom.name", "Puff-shroom");

    EntityRegistry.registerGlobalEntityID(EntityFumeShroom.class, "FumeShroom", ++mobID);
    EntityRegistry.addSpawn(EntityFumeShroom.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityFumeShroom.class, primaryColor, 1802268);
    LanguageRegistry.instance().addStringLocalization("entity.FumeShroom.name", "Fume-shroom");

    EntityRegistry.registerGlobalEntityID(EntityScaredyShroom.class, "ScaredyShroom", ++mobID);
    EntityRegistry.addSpawn(EntityScaredyShroom.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityScaredyShroom.class, primaryColor, 1802268);
    LanguageRegistry.instance().addStringLocalization("entity.ScaredyShroom.name", "Scaredy-shroom");

    EntityRegistry.registerGlobalEntityID(EntityMoonShroom.class, "MoonShroom", ++mobID);
    EntityRegistry.addSpawn(EntityMoonShroom.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityMoonShroom.class, primaryColor, 16771584);
    LanguageRegistry.instance().addStringLocalization("entity.MoonShroom.name", "Moon-shroom");
  }

  public static void pool() {
  }

  public static void roof() {
  }

  public static void special() {
    primaryColor = 293396;

    EntityRegistry.registerGlobalEntityID(EntityCreeperRepeater.class, "Creeper Repeater", ++mobID);
    EntityRegistry.addSpawn(EntityCreeperRepeater.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityCreeperRepeater.class, primaryColor, 16711680);
    LanguageRegistry.instance().addStringLocalization("entity.Creeper Repeater.name", "Creeper-Repeater");

    EntityRegistry.registerGlobalEntityID(EntityWalnut.class, "Walnut", ++mobID);
    EntityRegistry.addSpawn(EntityWalnut.class, 1, 1, 4, EnumCreatureType.creature, new BiomeGenBase[0]);
    EntityRegistry.findGlobalUniqueEntityId();
    registerEntityEgg(EntityWalnut.class, primaryColor, 16711680);
    LanguageRegistry.instance().addStringLocalization("entity.Walnut.name", "Walnut");
  }

  public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
  {
    int id = getUniqueEntityId();
    EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
    EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, primaryColor, secondaryColor));
  }

  public static int getUniqueEntityId() {
    do {
      startEntityId += 1;
    }
    while (EntityList.getStringFromID(startEntityId) != null);
    return startEntityId;
  }

  public static boolean entityUndeadCheck(MovingObjectPosition movObjPos) {
    boolean result = false;
    if ((movObjPos.entityHit instanceof EntityZombie))
    {
      result = true;
    }
    if ((movObjPos.entityHit instanceof EntitySkeleton))
    {
      result = true;
    }
    if ((movObjPos.entityHit instanceof EntityPigZombie))
    {
      result = true;
    }
    if ((!(movObjPos.entityHit instanceof EntityBlaze)) || (
      (!(movObjPos.entityHit instanceof EntityWitherSkull)) || (
      (!(movObjPos.entityHit instanceof EntityWither)) || 
      ((movObjPos.entityHit instanceof EntityGhast)))));
    return result;
  }
}