package CountryGamer_PlantsVsZombies.Items;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZ_Util;
import CountryGamer_PlantsVsZombies.Entities.Mobs.Plants.EntityPlantBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemTrowel extends ItemTool
{
  public ItemTrowel(int id)
  {
    super(id, 2.0F, EnumToolMaterial.IRON, new Block[] { Block.dirt, Block.grass });

    setCreativeTab(PvZ_Main.pvzTab);
  }

  public void registerIcons(IconRegister iconReg) {
    this.itemIcon = iconReg.registerIcon(PvZ_Main.base_Tex + getUnlocalizedName().substring(5));
  }

  public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
  {
    int blockid = world.getBlockId(x, y, z);
    if (blockid == PvZ_Main.endowedGrass.blockID) {
      world.setBlock(x, y, z, Block.dirt.blockID);
      PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.sunlight, 1));
      return true;
    }
    if (blockid == PvZ_Main.darkenedGrass.blockID) {
      world.setBlock(x, y, z, Block.dirt.blockID);
      PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.moonlight, 1));
      return true;
    }
    return false;
  }

  public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entity)
  {
    if (entity.worldObj.isRemote) return false;

    if ((entity instanceof EntityPlantBase))
    {
      uproot(itemStack, player, (EntityPlantBase)entity);
      return true;
    }
    return false;
  }

  public void uproot(ItemStack itemStack, EntityPlayer player, EntityPlantBase entity)
  {
    entity.setDead();
  }
}