package CountryGamer_PlantsVsZombies.PvZMod.Blocks;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityChlorophyllBowl;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChlorophyllBowl extends BlockContainer
{
  private Class entityClass;
  Random random = new Random();

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconReg)
  {
    this.blockIcon = iconReg.registerIcon(PvZ_Main.base_Tex + getUnlocalizedName().substring(5));
  }

  public BlockChlorophyllBowl(int id, Class tClass) {
    super(id, Material.wood);
    this.entityClass = tClass;
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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
  public int getRenderType() {
    return -1;
  }
  public boolean isOpaqueCube() {
    return false;
  }
  public boolean renderAsNormalBlock() {
    return false;
  }
  public TileEntity createNewTileEntity(World world) {
    return new TileEntityChlorophyllBowl();
  }

  public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
  {
    super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    TileEntityChlorophyllBowl tileentitychest = (TileEntityChlorophyllBowl)par1World.getBlockTileEntity(par2, par3, par4);

    if (tileentitychest != null)
    {
      tileentitychest.updateContainingBlockInfo();
    }
  }

  public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
  {
    TileEntityChlorophyllBowl tileentitychest = (TileEntityChlorophyllBowl)par1World.getBlockTileEntity(par2, par3, par4);

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

  public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
  {
    if (par1World.isRemote)
    {
      return true;
    }

    IInventory iinventory = func_94442_h_(par1World, par2, par3, par4);

    if (iinventory != null)
    {
      par5EntityPlayer.displayGUIChest(iinventory);
    }

    return true;
  }

  public IInventory func_94442_h_(World par1World, int par2, int par3, int par4)
  {
    Object object = (TileEntityChlorophyllBowl)par1World.getBlockTileEntity(par2, par3, par4);

    if (object == null)
    {
      return null;
    }

    return (IInventory)object;
  }
}