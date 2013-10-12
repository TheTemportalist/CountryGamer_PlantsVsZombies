package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityPeaPod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPeaShooter extends EntityPlantShooterBase
{
  public EntityPeaShooter(World par1World)
  {
    super(par1World, new ItemStack(PvZ_Main.basicPlants, 1, 1));

    setTexture("/mods/CountryGamer_PlantsVsZombies/textures/mobs/Pea Shooter.png");
  }
  protected int getDropItemId() {
    return PvZ_Main.peaPod.itemID;
  }

  public boolean interact(EntityPlayer par1EntityPlayer)
  {
    return false;
  }

  public EntityThrowable entitySelect(World world)
  {
    EntityPeaPod ent = new EntityPeaPod(world, this);
    return ent;
  }
}