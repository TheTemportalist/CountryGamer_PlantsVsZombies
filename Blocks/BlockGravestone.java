package CountryGamer_PlantsVsZombies.Blocks;

import java.util.ArrayList;
import java.util.Random;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZ_Util;
import CountryGamer_PlantsVsZombies.Blocks.TileEnts.TileEntityGravestone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGravestone extends BlockContainer
{
  private Class entityClass;
  public TileEntityGravestone gravestoneTE;
  public int type = 0;

  public BlockGravestone(int id, int type, Class tClass)
  {
    super(id, Material.rock);
    this.entityClass = tClass;
    this.type = type;
    setHardness(0.2F).setResistance(3.0F);
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    setCreativeTab(PvZ_Main.pvzTab);
  }
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconReg) {
    this.blockIcon = iconReg.registerIcon(PvZ_Main.base_Tex + getUnlocalizedName().substring(5));
  }

  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
  {
    return null;
  }

  public TileEntity getBlockEntity() {
    try {
      return (TileEntity)this.entityClass.newInstance(); } catch (Exception exception) {
    }
    throw new RuntimeException();
  }

  public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
  {
    ArrayList ret = new ArrayList();
    switch (this.gravestoneTE.type) {
    case 1:
      ret.add(new ItemStack(Item.rottenFlesh, 8));
      break;
    case 2:
      int i = world.rand.nextInt(4);
      switch (i) {
      case 0:
        ret.add(new ItemStack(PvZ_Main.footballHelm, 1));
        break;
      case 1:
        ret.add(new ItemStack(PvZ_Main.footballChest, 1));
        break;
      case 2:
        ret.add(new ItemStack(PvZ_Main.footballLegs, 1));
        break;
      case 3:
        ret.add(new ItemStack(PvZ_Main.footballBoots, 1));
        break;
      default:
        ret.add(new ItemStack(PvZ_Main.footballHelm, 1));
        ret.add(new ItemStack(PvZ_Main.footballChest, 1));
        ret.add(new ItemStack(PvZ_Main.footballLegs, 1));
        ret.add(new ItemStack(PvZ_Main.footballBoots, 1));
      }break;
    case 3:
      ret.add(new ItemStack(PvZ_Main.flag, 1));
      break;
    case 4:
      break;
    case 5:
      ret.add(new ItemStack(Item.bucketEmpty, 1));
      break;
    default:
      ret.clear();
    }

    return ret;
  }
  protected boolean canSilkHarvest() {
    return true;
  }
  public int quantitItemStackropped(Random rand) { return 1; }

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
    return new TileEntityGravestone();
  }

  public void onBlockAdded(World world, int x, int y, int z)
  {
    super.onBlockAdded(world, x, y, z);

    TileEntity tile = world.getBlockTileEntity(x, y, z);
    if ((tile instanceof TileEntityGravestone))
      this.gravestoneTE = ((TileEntityGravestone)tile);
    else System.out.println("Tile Error");
  }

  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
  {
    onBlockAdded(world, x, y, z);

    if (this.gravestoneTE.facing < 0) {
      int facing = PvZ_Util.checkFacing(world, x, y, z, par5EntityLivingBase, par6ItemStack, this.gravestoneTE);
      this.gravestoneTE.facing = facing;
    }
    if (this.gravestoneTE.type <= 0) {
      this.gravestoneTE.type = this.type;
    }
    PvZ_Util.spawnRandZombie(world, x, y, z, this.gravestoneTE.facing, this.gravestoneTE.type);
  }
}