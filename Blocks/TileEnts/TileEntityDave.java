package CountryGamer_PlantsVsZombies.Blocks.TileEnts;

import CountryGamer_PlantsVsZombies.PvZ_Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityDave extends TileEntity
  implements ISidedInventory
{
  private static final int[] input = { 0, 1 };
  private static final int[] output = { 2 };
  private ItemStack[] daveItemStack = new ItemStack[3];
  public String customName;

  public int getSizeInventory()
  {
    return this.daveItemStack.length;
  }

  public ItemStack getStackInSlot(int i)
  {
    if ((i >= 0) && (i < this.daveItemStack.length)) {
      return this.daveItemStack[i];
    }
    return null;
  }

  public ItemStack decrStackSize(int i, int j)
  {
    if ((i >= 0) && (i < this.daveItemStack.length)) {
      ItemStack itemStack = this.daveItemStack[i];
      this.daveItemStack[i] = null;
      return itemStack;
    }
    return null;
  }

  public ItemStack getStackInSlotOnClosing(int i)
  {
    if ((i >= 0) && (i < this.daveItemStack.length)) {
      ItemStack itemStack = this.daveItemStack[i];
      this.daveItemStack[i] = null;
      return itemStack;
    }
    return null;
  }

  public void setInventorySlotContents(int i, ItemStack itemStack)
  {
    if ((i >= 0) && (i < this.daveItemStack.length))
      this.daveItemStack[i] = itemStack;
  }

  public String getInvName()
  {
    return isInvNameLocalized() ? this.customName : "Crazy Dave's Box";
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
    return PvZ_Util.daveSlotCheck(i, itemStack);
  }

  public int[] getAccessibleSlotsFromSide(int var1)
  {
    if (var1 == 0) {
      return output;
    }
    if (var1 == 1) {
      return input;
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

  public void readFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readFromNBT(par1NBTTagCompound);
    NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
    this.daveItemStack = new ItemStack[getSizeInventory()];

    for (int i = 0; i < nbttaglist.tagCount(); i++)
    {
      NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
      byte b0 = nbttagcompound1.getByte("Slot");

      if ((b0 < 0) || (b0 >= this.daveItemStack.length))
        continue;
      this.daveItemStack[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
    }

    if (par1NBTTagCompound.hasKey("Crazy Dave's Box"))
    {
      this.customName = par1NBTTagCompound.getString("Crazy Dave's Box");
    }
  }

  public void writeToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeToNBT(par1NBTTagCompound);
    NBTTagList nbttaglist = new NBTTagList();

    for (int i = 0; i < getSizeInventory(); i++)
    {
      if (this.daveItemStack[i] == null)
        continue;
      NBTTagCompound nbttagcompound1 = new NBTTagCompound();
      nbttagcompound1.setByte("Slot", (byte)i);
      this.daveItemStack[i].writeToNBT(nbttagcompound1);

      nbttaglist.appendTag(nbttagcompound1);
    }

    par1NBTTagCompound.setTag("Items", nbttaglist);

    if (isInvNameLocalized())
    {
      par1NBTTagCompound.setString("Crazy Dave's Box", this.customName);
    }
  }

  public void updateEntity()
  {
    boolean canUpgrade = false;

    if (!this.worldObj.isRemote)
    {
      if (canUpgrade())
      {
        upgradeItem();
      }
    }

    if (canUpgrade)
    {
      onInventoryChanged();
    }
  }

  private boolean canUpgrade() {
    if (this.daveItemStack[0] != null)
    {
      ItemStack itemStackWith = DaveRecipes.smelting().getSmeltingResult(this.daveItemStack[0], this.daveItemStack[1]);

      ItemStack itemStackWOut = DaveRecipes.smelting().getSmeltingResult(this.daveItemStack[0], PvZ_Util.nullStack);
      ItemStack itemStack;
      if (itemStackWith == null)
        itemStack = itemStackWOut;
      else {
        itemStack = itemStackWith;
      }
      if (itemStack == null) return false;

      if (this.daveItemStack[2] == null)
      {
        return true;
      }
      if (this.daveItemStack[2].stackSize != getInventoryStackLimit())
      {
        return true;
      }
      if (!this.daveItemStack[2].isItemEqual(itemStack))
      {
        return false;
      }
    }
    return false;
  }
  public void upgradeItem() {
    if (canUpgrade())
    {
      ItemStack itemStackWith = DaveRecipes.smelting().getSmeltingResult(this.daveItemStack[0], this.daveItemStack[1]);

      ItemStack itemStackWOut = DaveRecipes.smelting().getSmeltingResult(this.daveItemStack[0], PvZ_Util.nullStack);
      ItemStack itemStackResult;
      if (itemStackWith == null)
        itemStackResult = itemStackWOut;
      else {
        itemStackResult = itemStackWith;
      }
      if (this.daveItemStack[2] == null)
      {
        this.daveItemStack[2] = itemStackResult.copy();
      }
      else if ((this.daveItemStack[2].isItemEqual(itemStackResult)) && (this.daveItemStack[2].stackSize + itemStackResult.stackSize <= this.daveItemStack[2].getMaxStackSize()))
      {
        this.daveItemStack[2].stackSize += itemStackResult.stackSize;
      }
      this.daveItemStack[0].stackSize -= 1;

      if (this.daveItemStack[0].stackSize <= 0) this.daveItemStack[0] = null;
      if ((itemStackResult == itemStackWith) && 
        (this.daveItemStack[1] != null)) {
        this.daveItemStack[1].stackSize -= 1;
        if (this.daveItemStack[1].stackSize <= 0)
          this.daveItemStack[1] = null;
      }
    }
  }
}