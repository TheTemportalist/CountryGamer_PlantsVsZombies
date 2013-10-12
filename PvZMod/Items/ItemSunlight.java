package CountryGamer_PlantsVsZombies.PvZMod.Items;

import java.util.Random;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntitySunlight;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSunlight extends ItemBase
{
  public ItemSunlight(int id)
  {
    super(id);
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
  {
    if ((player.capabilities.isCreativeMode) || (player.inventory.consumeInventoryItem(PvZ_Main.sunlight.itemID)))
    {
      world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
      if (!world.isRemote) {
        world.spawnEntityInWorld(new EntitySunlight(world, player));
      }
    }

    return itemStack;
  }
}