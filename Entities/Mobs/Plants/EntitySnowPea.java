package CountryGamer_PlantsVsZombies.Entities.Mobs.Plants;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.Entities.Projectiles.EntitySnowPod;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySnowPea extends EntityPlantShooterBase
{
  public EntitySnowPea(World par1World)
  {
    super(par1World, new ItemStack(PvZ_Main.basicPlants, 1, 2));

    setTexture("/mods/CountryGamer_PlantsVsZombies/textures/mobs/Snow Pea.png");
  }
  protected int getDropItemId() {
    return PvZ_Main.snowPod.itemID;
  }

  public EntityThrowable entitySelect(World world)
  {
    EntitySnowPod ent = new EntitySnowPod(world, this);
    return ent;
  }
}