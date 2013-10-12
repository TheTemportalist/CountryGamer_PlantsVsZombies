package CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityGreenhouse extends TileEntity
  implements ISidedInventory
{
  private static final int[] input = { 0 };
  private static final int[] modify = { 1, 2, 3 };
  private static final int[] output = { 4 };
  public ItemStack[] ghItemStack = new ItemStack[5];
  public int plantUpgradeTime;
  public int plantUpgradeTime1 = 400;
  public int upgradeSpeed;
  public int upgradeMultiplyer;
  public int upgradeSpecial;
  public String customName;

  public int getSizeInventory()
  {
    return this.ghItemStack.length;
  }

  public ItemStack getStackInSlot(int i)
  {
    if ((i >= 0) && (i < this.ghItemStack.length)) {
      return this.ghItemStack[i];
    }
    return null;
  }

  public ItemStack decrStackSize(int i, int j)
  {
    if ((i >= 0) && (i < this.ghItemStack.length)) {
      ItemStack itemStack = this.ghItemStack[i];
      this.ghItemStack[i] = null;
      return itemStack;
    }
    return null;
  }

  public ItemStack getStackInSlotOnClosing(int i)
  {
    if ((i >= 0) && (i < this.ghItemStack.length)) {
      ItemStack itemStack = this.ghItemStack[i];
      this.ghItemStack[i] = null;
      return itemStack;
    }
    return null;
  }

  public void setInventorySlotContents(int i, ItemStack itemStack)
  {
    if ((i >= 0) && (i < this.ghItemStack.length))
      this.ghItemStack[i] = itemStack;
  }

  public String getInvName()
  {
    return isInvNameLocalized() ? this.customName : "Greenhouse";
  }

  public boolean isInvNameLocalized()
  {
    return (this.customName != null) && (this.customName.length() > 0);
  }

  public int getInventoryStackLimit()
  {
    return 64;
  }

  public boolean isUseableByPlayer(EntityPlayer player)
  {
    if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
      return false;
    }
    boolean ret = player.getDistance(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;

    return ret;
  }

  public void openChest()
  {
  }

  public void closeChest() {
  }

  public boolean isItemValidForSlot(int i, ItemStack itemStack) {
    return PvZ_Util.greenhouseSlotCheck(i, itemStack);
  }

  public int[] getAccessibleSlotsFromSide(int var1)
  {
    if (var1 == 0) {
      return output;
    }
    if (var1 == 1) {
      return input;
    }
    if ((var1 == 2) || (var1 == 3)) {
      return modify;
    }
    return null;
  }

  public boolean canInsertItem(int i, ItemStack itemStack, int j)
  {
    return isItemValidForSlot(i, itemStack);
  }

  public boolean canExtractItem(int i, ItemStack itemStack, int j)
  {
    return true;
  }

  public void setGuiDisplayName(String par1Str)
  {
    this.customName = par1Str;
  }

  @SideOnly(Side.CLIENT)
  public int getUpgradeProgressScaled(int par1)
  {
    return this.plantUpgradeTime * par1 / this.plantUpgradeTime1;
  }

  public void readFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readFromNBT(par1NBTTagCompound);
    NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
    this.ghItemStack = new ItemStack[getSizeInventory()];

    for (int i = 0; i < nbttaglist.tagCount(); i++)
    {
      NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
      byte b0 = nbttagcompound1.getByte("Slot");

      if ((b0 < 0) || (b0 >= this.ghItemStack.length))
        continue;
      this.ghItemStack[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
    }

    this.plantUpgradeTime = par1NBTTagCompound.getShort("UpgradeTime");

    if (par1NBTTagCompound.hasKey("Greenhouse"))
    {
      this.customName = par1NBTTagCompound.getString("Greenhouse");
    }
  }

  public void writeToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeToNBT(par1NBTTagCompound);
    par1NBTTagCompound.setShort("UpgradeTime", (short)this.plantUpgradeTime);
    NBTTagList nbttaglist = new NBTTagList();

    for (int i = 0; i < getSizeInventory(); i++)
    {
      if (this.ghItemStack[i] == null)
        continue;
      NBTTagCompound nbttagcompound1 = new NBTTagCompound();
      nbttagcompound1.setByte("Slot", (byte)i);
      this.ghItemStack[i].writeToNBT(nbttagcompound1);

      nbttaglist.appendTag(nbttagcompound1);
    }

    par1NBTTagCompound.setTag("Items", nbttaglist);

    if (isInvNameLocalized())
    {
      par1NBTTagCompound.setString("Greenhouse", this.customName);
    }
  }

  public void updateEntity()
  {
    boolean canUpgrade = false;

    if (!this.worldObj.isRemote)
    {
      if (canUpgrade())
      {
        this.plantUpgradeTime += 1;

        if (this.plantUpgradeTime == this.plantUpgradeTime1)
        {
          this.plantUpgradeTime = 0;
          upgradeItem();
          canUpgrade = true;
        }
      }
      else
      {
        this.plantUpgradeTime = 0;
      }
    }

    if (canUpgrade)
    {
      onInventoryChanged();
    }
  }

  private boolean canUpgrade()
  {
    if ((this.ghItemStack[0] != null) && (this.ghItemStack[1] != null))
    {
      ItemStack itemStackWith = GreenhouseRecipes.smelting().getSmeltingResult(this.ghItemStack[0], this.ghItemStack[1], this.ghItemStack[2]);

      ItemStack itemStackWOut = GreenhouseRecipes.smelting().getSmeltingResult(this.ghItemStack[0], this.ghItemStack[1], PvZ_Util.nullStack);
      ItemStack itemStack;
      if (itemStackWith == null)
        itemStack = itemStackWOut;
      else {
        itemStack = itemStackWith;
      }
      if (itemStack == null) return false;

      if (this.ghItemStack[4] == null)
      {
        return true;
      }
      if (this.ghItemStack[4].stackSize != getInventoryStackLimit())
      {
        return true;
      }
      if (!this.ghItemStack[4].isItemEqual(itemStack))
      {
        return false;
      }
    }
    return false;
  }
  public void upgradeItem() {
    if (canUpgrade())
    {
      ItemStack itemStackResultWith = GreenhouseRecipes.smelting().getSmeltingResult(this.ghItemStack[0], this.ghItemStack[1], this.ghItemStack[2]);

      ItemStack itemStackResultWOut = GreenhouseRecipes.smelting().getSmeltingResult(this.ghItemStack[0], this.ghItemStack[1], PvZ_Util.nullStack);
      ItemStack itemStackResult;
      if (itemStackResultWith == null)
        itemStackResult = itemStackResultWOut;
      else {
        itemStackResult = itemStackResultWith;
      }
      if (this.ghItemStack[4] == null)
      {
        this.ghItemStack[4] = itemStackResult.copy();
      }
      else if ((this.ghItemStack[4].isItemEqual(itemStackResult)) && (this.ghItemStack[4].stackSize + itemStackResult.stackSize <= this.ghItemStack[4].getMaxStackSize()))
      {
        this.ghItemStack[4].stackSize += itemStackResult.stackSize;
      }
      this.ghItemStack[0].stackSize -= 1;
      this.ghItemStack[1].stackSize -= 1;

      if (this.ghItemStack[0].stackSize <= 0) this.ghItemStack[0] = null;
      if (this.ghItemStack[1].stackSize <= 0) this.ghItemStack[1] = null;
      if ((itemStackResult == itemStackResultWith) && 
        (this.ghItemStack[2] != null)) {
        this.ghItemStack[2].stackSize -= 1;
        if (this.ghItemStack[2].stackSize <= 0)
          this.ghItemStack[2] = null;
      }
    }
  }
}