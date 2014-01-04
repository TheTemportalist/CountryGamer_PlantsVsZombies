package CountryGamer_PlantsVsZombies.Items;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorBase extends ItemArmor
{
  public String renderTexture;
  public int armorSlot;

  public ItemArmorBase(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int slot)
  {
    super(id, par2EnumArmorMaterial, par3, slot);

    this.armorSlot = slot;
  }

  public void registerIcons(IconRegister iconReg)
  {
    this.itemIcon = iconReg.registerIcon(PvZ_Main.base_Tex + getUnlocalizedName().substring(5));
  }

  public String getArmorTexture(ItemStack stack, Entity ent, int slot, int layer)
  {
    switch (this.armorSlot) {
    case 0:
      return PvZ_Main.base_Tex + "textures/armor/football_layer_1.png";
    case 1:
      return PvZ_Main.base_Tex + "textures/armor/football_layer_1.png";
    case 2:
      return PvZ_Main.base_Tex + "textures/armor/football_layer_2.png";
    case 3:
      return PvZ_Main.base_Tex + "textures/armor/football_layer_1.png";
    }
    return PvZ_Main.base_Tex + "textures/armor/football_layer_1.png";
  }
}