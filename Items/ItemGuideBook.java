package CountryGamer_PlantsVsZombies.Items;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGuideBook extends ItemBase
{
  public ItemGuideBook(int id)
  {
    super(id);
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
  {
    if (world.isRemote) {
      player.openGui(PvZ_Main.instance, 3, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    }

    return itemStack;
  }
}