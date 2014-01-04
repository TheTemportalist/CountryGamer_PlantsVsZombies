package CountryGamer_PlantsVsZombies.Items;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZ_Util;
import CountryGamer_PlantsVsZombies.Entities.Mobs.Plants.EntityPlantBase;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTransTrowel extends ItemTrowel
{
  public ItemTransTrowel(int id)
  {
    super(id);
  }

  public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
  {
    int blockid = world.getBlockId(x, y, z);
    if (blockid == PvZ_Main.endowedGrass.blockID) {
      world.setBlock(x, y, z, Block.dirt.blockID);
      if (!world.isRemote) {
        PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.sunlight, 1));
      }
      return true;
    }
    if (blockid == PvZ_Main.darkenedGrass.blockID) {
      world.setBlock(x, y, z, Block.dirt.blockID);
      PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.moonlight, 1));
      return true;
    }
    return false;
  }

  public void uproot(ItemStack itemStack, EntityPlayer player, EntityPlantBase entity)
  {
    PvZ_Util.spawnItem(entity.worldObj, (int)entity.posX, (int)entity.posY + 1, (int)entity.posZ, entity.spawnStack);

    itemStack.damageItem(1, player);

    entity.setDead();
  }
}