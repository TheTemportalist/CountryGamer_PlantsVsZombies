package CountryGamer_PlantsVsZombies.PvZMod.Items;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityWalnut;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWalnut extends ItemBase
{
  public ItemWalnut(int id)
  {
    super(id);
  }

  public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
  {
    int blockid = world.getBlockId(x, y, z);
    if ((world.getBlockId(x, y + 1, z) == 0) && ((blockid == Block.grass.blockID) || (blockid == Block.dirt.blockID) || (blockid == PvZ_Main.endowedGrass.blockID) || (blockid == PvZ_Main.darkenedGrass.blockID)))
    {
      if ((player.capabilities.isCreativeMode) || (player.inventory.consumeInventoryItem(this.itemID)))
      {
        EntityLivingBase ent = new EntityWalnut(world);
        ent.setLocationAndAngles(x + 0.5D, y + 1, z + 0.5D, 0.0F, 0.0F);
        if (!world.isRemote) world.spawnEntityInWorld(ent);
      }
      return true;
    }
    return false;
  }
}