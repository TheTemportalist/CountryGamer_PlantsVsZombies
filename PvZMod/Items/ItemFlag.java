package CountryGamer_PlantsVsZombies.PvZMod.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFlag extends ItemBase
{
  public ItemFlag(int id)
  {
    super(id);
  }

  public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
  {
    return false;
  }
}