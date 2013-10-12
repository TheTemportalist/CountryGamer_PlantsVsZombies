package CountryGamer_PlantsVsZombies.PvZMod.Items;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Util;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityCreeperRepeater;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntityWalnut;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSpecialPlants extends ItemBase
{
  public static final String[] itemMetaNames = { "creeperRepeater", "walnut" };

  public static final String[] itemGameNames = { "Creeper-Repeater", "Walnut" };

  public static String base_Tex = PvZ_Main.base_Tex;
  public static final String[] item_a = { base_Tex + "creeperRepeater", base_Tex + "walnut" };

  @SideOnly(Side.CLIENT)
  private Icon[] item_b;
  public boolean onGround = false;

  public ItemSpecialPlants(int id)
  {
    super(id);
    setHasSubtypes(true);
    setMaxDamage(0);
  }

  @SideOnly(Side.CLIENT)
  public Icon getIconFromDamage(int itemId)
  {
    int j = MathHelper.clamp_int(itemId, 0, itemMetaNames.length - 1);
    return this.item_b[j];
  }
  public String getUnlocalizedName(ItemStack itemStack) {
    int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, itemMetaNames.length - 1);
    return super.getUnlocalizedName() + "." + itemMetaNames[i];
  }
  @SideOnly(Side.CLIENT)
  public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) { for (int i = 0; i < itemMetaNames.length; i++)
      par3List.add(new ItemStack(par1, 1, i));
  }

  public void registerIcons(IconRegister iconReg)
  {
    this.item_b = new Icon[item_a.length];
    for (int i = 0; i < item_a.length; i++)
      this.item_b[i] = iconReg.registerIcon(item_a[i]);
  }

  public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
  {
    EntityLiving ent = null;

    if (!player.canPlayerEdit(x, y, z, side, itemStack)) {
      return false;
    }
    switch (itemStack.getItemDamage()) {
    case 0:
      ent = new EntityCreeperRepeater(world);
      break;
    case 1:
      ent = new EntityWalnut(world);
      break;
    default:
      ent = new EntityCreeperRepeater(world);
    }

    baseItemUse(world, player, x, y, z, ent, itemStack);
    return true;
  }

  public void baseItemUse(World world, EntityPlayer player, int x, int y, int z, EntityLiving par0Entity, ItemStack itemStack) {
    EntityLiving ent = par0Entity;
    if (world.getBlockId(x, y + 1, z) == 0)
    {
      int blockUnder = world.getBlockId(x, y, z);
      if ((blockUnder == PvZ_Main.endowedGrass.blockID) || (blockUnder == Block.waterlily.blockID))
      {
        if (blockUnder == PvZ_Main.endowedGrass.blockID) this.onGround = true;
        if (blockUnder == Block.waterlily.blockID) this.onGround = false;
        if (player.capabilities.isCreativeMode) {
          itemUsed(ent, x, y, z, world);
        } else {
          ItemStack thisItem = new ItemStack(this, 1, itemStack.getItemDamage());
          if (player.inventory.hasItemStack(thisItem)) {
            PvZ_Util.removeItem(player, thisItem);
            itemUsed(ent, x, y, z, world);
          }
        }
      }
    }
  }

  public void itemUsed(EntityLiving ent, int x, int y, int z, World world) {
    if (this.onGround) {
      ent.setLocationAndAngles(x + 0.5D, y + 1, z + 0.5D, 0.0F, 0.0F);

      if (!world.isRemote) {
        world.spawnEntityInWorld(ent);
        world.setBlock(x, y, z, Block.grass.blockID);
      }
    } else {
      ent.setLocationAndAngles(x + 0.5D, y, z + 0.5D, 0.0F, 0.0F);

      if (!world.isRemote)
        world.spawnEntityInWorld(ent);
    }
  }
}