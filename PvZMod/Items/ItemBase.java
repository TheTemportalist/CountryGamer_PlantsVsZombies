package CountryGamer_PlantsVsZombies.PvZMod.Items;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
  public String texture;

  public ItemBase(int id)
  {
    super(id);

    setMaxStackSize(64);
    setCreativeTab(PvZ_Main.pvzTab);
  }
  public int getMaxStackSize() {
    return this.maxStackSize;
  }

  public void registerIcons(IconRegister iconReg)
  {
    this.itemIcon = iconReg.registerIcon(PvZ_Main.base_Tex + getUnlocalizedName().substring(5));
  }
}