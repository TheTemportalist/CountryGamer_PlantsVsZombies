package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityScaredyShroom extends EntityShroomShooterBase
{
  public EntityScaredyShroom(World world)
  {
    super(world, new ItemStack(PvZ_Main.nightPlants, 1, 1));
  }

  public void dropFewItems(boolean par1, int par2)
  {
    dropItem(PvZ_Main.shroomPod.itemID, 2);
  }
}