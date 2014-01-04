package CountryGamer_PlantsVsZombies.Client.Gui;

import java.util.List;

import CountryGamer_PlantsVsZombies.Blocks.TileEnts.TileEntityDave;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDave extends Container
{
  private TileEntityDave tileEnt;

  public boolean canInteractWith(EntityPlayer player)
  {
    return this.tileEnt.isUseableByPlayer(player);
  }

  public ContainerDave(InventoryPlayer invPlayer, TileEntityDave tileEnt) {
    this.tileEnt = tileEnt;

    addSlotToContainer(new Slot(tileEnt, 0, 84, 58));
    addSlotToContainer(new Slot(tileEnt, 1, 102, 58));

    addSlotToContainer(new Slot(tileEnt, 2, 148, 58));

    for (int i = 0; i < 3; i++)
    {
      for (int j = 0; j < 9; j++)
      {
        addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }

    for (int i = 0; i < 9; i++)
    {
      addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
    }
  }

  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotID)
  {
    ItemStack itemstack = null;
    Slot slot = (Slot)this.inventorySlots.get(slotID);

    if ((slot != null) && (slot.getHasStack())) {
      ItemStack itemStack1 = slot.getStack();
      itemstack = itemStack1.copy();

      if ((slotID != 0) && (slotID != 1) && (slotID != 2) && (slotID != 3)) {
        if ((slotID >= 2) && (slotID < 30)) {
          if (!mergeItemStack(itemStack1, 30, 39, false)) {
            return null;
          }
          if ((slotID >= 30) && (slotID < 39) && (!mergeItemStack(itemStack1, 4, 30, false)))
            return null;
        }
      }
      else if (!mergeItemStack(itemStack1, 4, 39, false)) {
        return null;
      }
      if (itemStack1.stackSize == 0)
        slot.putStack((ItemStack)null);
      else {
        slot.onSlotChanged();
      }
      if (itemStack1.stackSize == itemstack.stackSize) {
        return null;
      }
      slot.onPickupFromSlot(par1EntityPlayer, itemStack1);
    }

    return itemstack;
  }
}