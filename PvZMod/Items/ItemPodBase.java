package CountryGamer_PlantsVsZombies.PvZMod.Items;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPodBase extends ItemBase
{
  public ItemPodBase(int id)
  {
    super(id);
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if ((player.capabilities.isCreativeMode) || (player.inventory.consumeInventoryItem(Item.stick.itemID)))
    {
      world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
      if (!world.isRemote) {
        spawnCustomEntity(world, player);
      }
    }

    return itemStack;
  }

  public void spawnCustomEntity(World world, EntityPlayer player)
  {
    world.spawnEntityInWorld(new EntitySnowball(world, player));
  }
}