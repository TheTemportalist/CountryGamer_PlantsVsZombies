package CountryGamer_PlantsVsZombies.Blocks.TileEnts;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZ_Util;
import CountryGamer_PlantsVsZombies.Blocks.BlockChlorophyllBowl;
import CountryGamer_PlantsVsZombies.Items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AABBPool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntityChlorophyllBowl extends TileEntity
  implements IInventory
{
  public int delayControl = 1200 * PvZ_Main.sunlightTimer;
  public int delay = this.delayControl;

  public int sunlightHeld = 0;

  private ItemStack[] chestContents = new ItemStack[36];

  public boolean adjacentChestChecked = false;
  public TileEntityChlorophyllBowl adjacentChestZNeg;
  public TileEntityChlorophyllBowl adjacentChestXPos;
  public TileEntityChlorophyllBowl adjacentChestXNeg;
  public TileEntityChlorophyllBowl adjacentChestZPosition;
  public float lidAngle;
  public float prevLidAngle;
  public int numUsingPlayers;
  private int ticksSinceSync;
  private int cachedChestType;
  private String field_94045_s;

  public TileEntityChlorophyllBowl()
  {
      this.cachedChestType = -1;
  }

  @SideOnly(Side.CLIENT)
  public TileEntityChlorophyllBowl(int par1)
  {
      this.cachedChestType = par1;
  }
  
  
  public void sunlightControl()
  {
    World world = this.worldObj;
    int x = this.xCoord; int y = this.yCoord; int z = this.zCoord;

    if (!world.isRemote)
      if (PvZ_Util.dayCheck(world))
      {
        for (int i = 0; i <= 36; i++) {
          ItemStack slot = getStackInSlot(i);

          if (slot != null) {
            if (slot.getItem() == PvZ_Main.sunlight) {
              ItemBase stackItem = (ItemBase)slot.getItem();
              if (slot.stackSize < stackItem.getMaxStackSize()) {
                slot.stackSize += 1;
                break;
              }
            }
          } else {
            ItemStack givenSunlight = new ItemStack(PvZ_Main.sunlight, 1, 0);

            setInventorySlotContents(i, givenSunlight);
            break;
          }

        }

      }
      else if (!PvZ_Util.dayCheck(world))
      {
        for (int i = 0; i <= 36; i++) {
          ItemStack slot = getStackInSlot(i);

          if (slot != null) {
            if (slot.getItem() == PvZ_Main.moonlight) {
              ItemBase stackItem = (ItemBase)slot.getItem();
              if (slot.stackSize < stackItem.getMaxStackSize()) {
                slot.stackSize += 1;
                break;
              }
            }
          } else {
            ItemStack givenSunlight = new ItemStack(PvZ_Main.moonlight, 1, 0);

            setInventorySlotContents(i, givenSunlight);
            break;
          }
        }
      }
  }

  public int getSizeInventory()
  {
    return 27;
  }

  public ItemStack getStackInSlot(int par1)
  {
    return this.chestContents[par1];
  }

  public ItemStack decrStackSize(int par1, int par2)
  {
    if (this.chestContents[par1] != null)
    {
      if (this.chestContents[par1].stackSize <= par2)
      {
        ItemStack itemstack = this.chestContents[par1];
        this.chestContents[par1] = null;
        onInventoryChanged();
        return itemstack;
      }

      ItemStack itemstack = this.chestContents[par1].splitStack(par2);

      if (this.chestContents[par1].stackSize == 0)
      {
        this.chestContents[par1] = null;
      }

      onInventoryChanged();
      return itemstack;
    }

    return null;
  }

  public ItemStack getStackInSlotOnClosing(int par1)
  {
    if (this.chestContents[par1] != null)
    {
      ItemStack itemstack = this.chestContents[par1];
      this.chestContents[par1] = null;
      return itemstack;
    }

    return null;
  }

  public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
  {
    this.chestContents[par1] = par2ItemStack;

    if ((par2ItemStack != null) && (par2ItemStack.stackSize > getInventoryStackLimit()))
    {
      par2ItemStack.stackSize = getInventoryStackLimit();
    }

    onInventoryChanged();
  }

  public String getInvName()
  {
    return isInvNameLocalized() ? this.field_94045_s : "Chlorophyll Bowl";
  }

  public boolean isInvNameLocalized()
  {
    return (this.field_94045_s != null) && (this.field_94045_s.length() > 0);
  }

  public void func_94043_a(String par1Str)
  {
    this.field_94045_s = par1Str;
  }

  public void readFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readFromNBT(par1NBTTagCompound);
    NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
    this.chestContents = new ItemStack[getSizeInventory()];

    if (par1NBTTagCompound.hasKey("Tutorial Chest"))
    {
      this.field_94045_s = par1NBTTagCompound.getString("Tutorial Chest");
    }

    for (int i = 0; i < nbttaglist.tagCount(); i++)
    {
      NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
      int j = nbttagcompound1.getByte("Slot") & 0xFF;

      if ((j < 0) || (j >= this.chestContents.length))
        continue;
      this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
    }
  }

  public void writeToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeToNBT(par1NBTTagCompound);
    NBTTagList nbttaglist = new NBTTagList();

    for (int i = 0; i < this.chestContents.length; i++)
    {
      if (this.chestContents[i] == null)
        continue;
      NBTTagCompound nbttagcompound1 = new NBTTagCompound();
      nbttagcompound1.setByte("Slot", (byte)i);
      this.chestContents[i].writeToNBT(nbttagcompound1);
      nbttaglist.appendTag(nbttagcompound1);
    }

    par1NBTTagCompound.setTag("Items", nbttaglist);

    if (isInvNameLocalized())
    {
      par1NBTTagCompound.setString("Tutorial Chest", this.field_94045_s);
    }
  }

  public int getInventoryStackLimit()
  {
    return 64;
  }

  public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
  {
    return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
  }

  public void updateContainingBlockInfo()
  {
    super.updateContainingBlockInfo();
    this.adjacentChestChecked = false;
  }

  private void func_90009_a(TileEntityChlorophyllBowl par1TileEntityChest, int par2)
  {
    if (par1TileEntityChest.isInvalid())
    {
      this.adjacentChestChecked = false;
    }
    else if (this.adjacentChestChecked)
    {
      switch (par2)
      {
      case 0:
        if (this.adjacentChestZPosition == par1TileEntityChest)
          break;
        this.adjacentChestChecked = false; break;
      case 1:
        if (this.adjacentChestXNeg == par1TileEntityChest)
          break;
        this.adjacentChestChecked = false; break;
      case 2:
        if (this.adjacentChestZNeg == par1TileEntityChest)
          break;
        this.adjacentChestChecked = false; break;
      case 3:
        if (this.adjacentChestXPos == par1TileEntityChest)
          break;
        this.adjacentChestChecked = false;
      }
    }
  }

  public void checkForAdjacentChests()
  {
    if (!this.adjacentChestChecked)
    {
      this.adjacentChestChecked = true;
      this.adjacentChestZNeg = null;
      this.adjacentChestXPos = null;
      this.adjacentChestXNeg = null;
      this.adjacentChestZPosition = null;

      if (func_94044_a(this.xCoord - 1, this.yCoord, this.zCoord))
      {
        this.adjacentChestXNeg = ((TileEntityChlorophyllBowl)this.worldObj.getBlockTileEntity(this.xCoord - 1, this.yCoord, this.zCoord));
      }

      if (func_94044_a(this.xCoord + 1, this.yCoord, this.zCoord))
      {
        this.adjacentChestXPos = ((TileEntityChlorophyllBowl)this.worldObj.getBlockTileEntity(this.xCoord + 1, this.yCoord, this.zCoord));
      }

      if (func_94044_a(this.xCoord, this.yCoord, this.zCoord - 1))
      {
        this.adjacentChestZNeg = ((TileEntityChlorophyllBowl)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord - 1));
      }

      if (func_94044_a(this.xCoord, this.yCoord, this.zCoord + 1))
      {
        this.adjacentChestZPosition = ((TileEntityChlorophyllBowl)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord + 1));
      }

      if (this.adjacentChestZNeg != null)
      {
        this.adjacentChestZNeg.func_90009_a(this, 0);
      }

      if (this.adjacentChestZPosition != null)
      {
        this.adjacentChestZPosition.func_90009_a(this, 2);
      }

      if (this.adjacentChestXPos != null)
      {
        this.adjacentChestXPos.func_90009_a(this, 1);
      }

      if (this.adjacentChestXNeg != null)
      {
        this.adjacentChestXNeg.func_90009_a(this, 3);
      }
    }
  }

  private boolean func_94044_a(int par1, int par2, int par3)
  {
      Block block = Block.blocksList[this.worldObj.getBlockId(par1, par2, par3)];
      return block != null &&
    		  block instanceof BlockChlorophyllBowl ?
    				 true : false;
  }

  public void updateEntity()
  {
    if (this.delay > 0) {
      this.delay -= 1;

      return;
    }
    this.delay = this.delayControl;

    sunlightControl();

    checkForAdjacentChests();
    this.ticksSinceSync += 1;

    if ((!this.worldObj.isRemote) && (this.numUsingPlayers != 0) && ((this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0))
    {
      this.numUsingPlayers = 0;
      float f = 5.0F;
      List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getAABBPool().getAABB(this.xCoord - f, this.yCoord - f, this.zCoord - f, this.xCoord + 1 + f, this.yCoord + 1 + f, this.zCoord + 1 + f));
      Iterator iterator = list.iterator();

      while (iterator.hasNext())
      {
        EntityPlayer entityplayer = (EntityPlayer)iterator.next();

        if ((entityplayer.openContainer instanceof ContainerChest))
        {
          IInventory iinventory = ((ContainerChest)entityplayer.openContainer).getLowerChestInventory();

          if ((iinventory == this) || (((iinventory instanceof InventoryLargeChest)) && (((InventoryLargeChest)iinventory).isPartOfLargeChest(this))))
          {
            this.numUsingPlayers += 1;
          }
        }
      }
    }

    this.prevLidAngle = this.lidAngle;
    float f = 0.1F;

    if ((this.numUsingPlayers > 0) && (this.lidAngle == 0.0F) && (this.adjacentChestZNeg == null) && (this.adjacentChestXNeg == null))
    {
      double d1 = this.xCoord + 0.5D;
      double d0 = this.zCoord + 0.5D;

      if (this.adjacentChestZPosition != null)
      {
        d0 += 0.5D;
      }

      if (this.adjacentChestXPos != null)
      {
        d1 += 0.5D;
      }

      this.worldObj.playSoundEffect(d1, this.yCoord + 0.5D, d0, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
    }

    if (((this.numUsingPlayers == 0) && (this.lidAngle > 0.0F)) || ((this.numUsingPlayers > 0) && (this.lidAngle < 1.0F)))
    {
      float f1 = this.lidAngle;

      if (this.numUsingPlayers > 0)
      {
        this.lidAngle += f;
      }
      else
      {
        this.lidAngle -= f;
      }

      if (this.lidAngle > 1.0F)
      {
        this.lidAngle = 1.0F;
      }

      float f2 = 0.5F;

      if ((this.lidAngle < f2) && (f1 >= f2) && (this.adjacentChestZNeg == null) && (this.adjacentChestXNeg == null))
      {
        double d0 = this.xCoord + 0.5D;
        double d2 = this.zCoord + 0.5D;

        if (this.adjacentChestZPosition != null)
        {
          d2 += 0.5D;
        }

        if (this.adjacentChestXPos != null)
        {
          d0 += 0.5D;
        }

        this.worldObj.playSoundEffect(d0, this.yCoord + 0.5D, d2, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
      }

      if (this.lidAngle < 0.0F)
      {
        this.lidAngle = 0.0F;
      }
    }
  }

  public boolean receiveClientEvent(int par1, int par2)
  {
    if (par1 == 1)
    {
      this.numUsingPlayers = par2;
      return true;
    }

    return super.receiveClientEvent(par1, par2);
  }

  public void openChest()
  {
    if (this.numUsingPlayers < 0)
    {
      this.numUsingPlayers = 0;
    }

    this.numUsingPlayers += 1;
    this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, getBlockType().blockID, 1, this.numUsingPlayers);
    this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, getBlockType().blockID);
    this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, getBlockType().blockID);
  }

  public void closeChest()
  {
    if ((getBlockType() != null) && ((getBlockType() instanceof BlockChlorophyllBowl)))
    {
      this.numUsingPlayers -= 1;
      this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, getBlockType().blockID, 1, this.numUsingPlayers);
      this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, getBlockType().blockID);
      this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, getBlockType().blockID);
    }
  }

  public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
  {
    return true;
  }

  public void invalidate()
  {
    super.invalidate();
    updateContainingBlockInfo();
    checkForAdjacentChests();
  }

  public int getChestType()
  {
      if (this.cachedChestType == -1)
      {
          if (this.worldObj == null || !(this.getBlockType() instanceof BlockChlorophyllBowl))
          {
              return 0;
          }

          this.cachedChestType = 0;
      }

      return this.cachedChestType;
  }

  public boolean isItemValidForSlot(int i, ItemStack itemstack)
  {
    return false;
  }
}