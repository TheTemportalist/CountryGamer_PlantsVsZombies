package CountryGamer_PlantsVsZombies.PvZMod.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemConeHelm extends ItemArmorBase
{
  public ItemConeHelm(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
  {
    super(id, par2EnumArmorMaterial, par3, par4);
  }

  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
    return null;
  }

  public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
  {
    return null;
  }
}