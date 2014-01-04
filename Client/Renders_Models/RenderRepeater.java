package CountryGamer_PlantsVsZombies.Client.Renders_Models;

import CountryGamer_PlantsVsZombies.Resources;
import CountryGamer_PlantsVsZombies.Entities.Mobs.Plants.EntityRepeater;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRepeater extends RenderLiving
{
  protected ModelRepeater model;

  @SideOnly(Side.CLIENT)
  public RenderRepeater(ModelBase par1ModelBase, float par2)
  {
    super(par1ModelBase, par2);
    this.model = ((ModelRepeater)this.mainModel);
  }
  @SideOnly(Side.CLIENT)
  public void renderRepeater(EntityRepeater entity, double par2, double par4, double par6, float par8, float par9) {
    super.doRenderLiving(entity, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
    renderRepeater((EntityRepeater)par1EntityLiving, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    renderRepeater((EntityRepeater)par1Entity, par2, par4, par6, par8, par9);
  }

  protected ResourceLocation getEntityTexture(Entity entity) {
    return Resources.repeaterMob;
  }
}