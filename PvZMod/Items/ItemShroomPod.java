package CountryGamer_PlantsVsZombies.PvZMod.Items;

import java.util.Random;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityShroomPod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShroomPod extends ItemPodBase
{
  public ItemShroomPod(int id)
  {
    super(id);
  }

  public void spawnCustomEntity(World world, EntityPlayer player)
  {
    world.spawnEntityInWorld(new EntityShroomPod(world, player));
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
  {
    if ((player.capabilities.isCreativeMode) || (player.inventory.consumeInventoryItem(PvZ_Main.shroomPod.itemID)))
    {
      world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
      if (!world.isRemote) {
        spawnCustomEntity(world, player);
      }
    }

    return itemStack;
  }
}