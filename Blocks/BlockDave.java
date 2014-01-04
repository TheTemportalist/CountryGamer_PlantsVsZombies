package CountryGamer_PlantsVsZombies.Blocks;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.Blocks.TileEnts.TileEntityDave;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDave extends BlockContainer
{
  private Class entityClass;
  private Icon top;
  private Icon bottom;
  private Icon side;
  private Icon[][] iconBuffer;
  Random random = new Random();

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconReg)
  {
    this.top = iconReg.registerIcon(PvZ_Main.seedBox_Top_Tex);
    this.side = iconReg.registerIcon(PvZ_Main.seedBox_Side_Tex);
  }

  public Icon getIcon(int side, int meta) {
    if ((side == 0) || (side == 1))
    {
      return this.top;
    }
    if ((side == 2) || (side == 3) || (side == 4) || (side == 5))
    {
      return this.side;
    }
    return this.top;
  }

  public BlockDave(int id, Class tClass)
  {
    super(id, Material.wood);
    this.entityClass = tClass;
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
  }

  public TileEntity getBlockEntity() {
    try {
      return (TileEntity)this.entityClass.newInstance(); } catch (Exception exception) {
    }
    throw new RuntimeException();
  }

  public int idDropped(int i, Random rand, int j) {
    return this.blockID;
  }
  public int quantityDropped(Random rand) {
    return 1;
  }
  public TileEntity createNewTileEntity(World world) {
    return new TileEntityDave();
  }

  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
  {
    TileEntity tileEnt = world.getBlockTileEntity(x, y, z);
    if ((tileEnt == null) || (player.isSneaking())) {
      return false;
    }
    player.openGui(PvZ_Main.instance, 0, world, x, y, z);
    return true;
  }

  public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
  {
    TileEntityDave tileentitychest = (TileEntityDave)par1World.getBlockTileEntity(par2, par3, par4);

    if (tileentitychest != null)
    {
      for (int j1 = 0; j1 < tileentitychest.getSizeInventory(); j1++)
      {
        ItemStack itemstack = tileentitychest.getStackInSlot(j1);

        if (itemstack == null)
          continue;
        float f = this.random.nextFloat() * 0.8F + 0.1F;
        float f1 = this.random.nextFloat() * 0.8F + 0.1F;
        EntityItem entityitem;
        for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World.spawnEntityInWorld(entityitem))
        {
          int k1 = this.random.nextInt(21) + 10;

          if (k1 > itemstack.stackSize)
          {
            k1 = itemstack.stackSize;
          }

          itemstack.stackSize -= k1;
          entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2, new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
          float f3 = 0.05F;
          entityitem.motionX = ((float)this.random.nextGaussian() * f3);
          entityitem.motionY = ((float)this.random.nextGaussian() * f3 + 0.2F);
          entityitem.motionZ = ((float)this.random.nextGaussian() * f3);

          if (!itemstack.hasTagCompound())
            continue;
          entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
        }

      }

      par1World.func_96440_m(par2, par3, par4, par5);
    }

    super.breakBlock(par1World, par2, par3, par4, par5, par6);
  }
}