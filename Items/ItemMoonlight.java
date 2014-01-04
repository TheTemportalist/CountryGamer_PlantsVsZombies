package CountryGamer_PlantsVsZombies.Items;

import java.util.Random;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.Entities.Projectiles.EntityMoonlight;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMoonlight extends ItemBase
{
  public ItemMoonlight(int id)
  {
    super(id);
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
  {
    if ((player.capabilities.isCreativeMode) || (player.inventory.consumeInventoryItem(PvZ_Main.sunlight.itemID)))
    {
      world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
      if (!world.isRemote) {
        world.spawnEntityInWorld(new EntityMoonlight(world, player));
      }
    }

    return itemStack;
  }
}