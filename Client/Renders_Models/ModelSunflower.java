package CountryGamer_PlantsVsZombies.Client.Renders_Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSunflower extends ModelBase
{
  ModelRenderer Stem;
  ModelRenderer Head;
  ModelRenderer LEAFzL;
  ModelRenderer LEAFzR;
  ModelRenderer HLzTzL;
  ModelRenderer HLzTzR;
  ModelRenderer HLzLzT;
  ModelRenderer HLzLzB;
  ModelRenderer HLzRzT;
  ModelRenderer HLzRzB;
  ModelRenderer SHLzLzT;
  ModelRenderer SHLzLzB;
  ModelRenderer SHLzRzT;
  ModelRenderer SHLzRzB;
  ModelRenderer THLzT;
  ModelRenderer THLzR;
  ModelRenderer THLzL;

  public ModelSunflower()
  {
    this.textureWidth = 64;
    this.textureHeight = 64;

    this.Stem = new ModelRenderer(this, 6, 10);
    this.Stem.addBox(-1.0F, -10.0F, -1.0F, 2, 11, 2);
    this.Stem.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Stem.setTextureSize(64, 64);
    this.Stem.mirror = true;
    setRotation(this.Stem, 0.0F, 0.0F, 0.0F);
    this.Head = new ModelRenderer(this, 0, 0);
    this.Head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
    this.Head.setRotationPoint(0.0F, 13.0F, 0.0F);
    this.Head.setTextureSize(64, 64);
    this.Head.mirror = true;
    setRotation(this.Head, 0.0F, 0.0F, 0.0F);
    this.LEAFzL = new ModelRenderer(this, 0, 23);
    this.LEAFzL.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
    this.LEAFzL.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.LEAFzL.setTextureSize(64, 64);
    this.LEAFzL.mirror = true;
    setRotation(this.LEAFzL, -0.1745329F, -0.1745329F, -0.261799F);
    this.LEAFzR = new ModelRenderer(this, 0, 23);
    this.LEAFzR.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
    this.LEAFzR.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.LEAFzR.setTextureSize(64, 64);
    this.LEAFzR.mirror = true;
    setRotation(this.LEAFzR, -0.261799F, 0.1745329F, 0.1745329F);
    this.HLzTzL = new ModelRenderer(this, 20, 0);
    this.HLzTzL.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzTzL.setRotationPoint(1.5F, 8.0F, -0.5F);
    this.HLzTzL.setTextureSize(64, 64);
    this.HLzTzL.mirror = true;
    setRotation(this.HLzTzL, 0.0F, 0.0F, 0.0F);
    this.HLzTzR = new ModelRenderer(this, 20, 0);
    this.HLzTzR.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzTzR.setRotationPoint(-1.5F, 8.0F, -0.5F);
    this.HLzTzR.setTextureSize(64, 64);
    this.HLzTzR.mirror = true;
    setRotation(this.HLzTzR, 0.0F, 0.0F, 0.0F);
    this.HLzLzT = new ModelRenderer(this, 20, 0);
    this.HLzLzT.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzLzT.setRotationPoint(2.5F, 9.0F, -0.5F);
    this.HLzLzT.setTextureSize(64, 64);
    this.HLzLzT.mirror = true;
    setRotation(this.HLzLzT, 0.0F, 0.0F, 1.570796F);
    this.HLzLzB = new ModelRenderer(this, 20, 0);
    this.HLzLzB.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzLzB.setRotationPoint(2.5F, 12.0F, -0.5F);
    this.HLzLzB.setTextureSize(64, 64);
    this.HLzLzB.mirror = true;
    setRotation(this.HLzLzB, 0.0F, 0.0F, 1.570796F);
    this.HLzRzT = new ModelRenderer(this, 20, 0);
    this.HLzRzT.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzRzT.setRotationPoint(-2.5F, 9.0F, -0.5F);
    this.HLzRzT.setTextureSize(64, 64);
    this.HLzRzT.mirror = true;
    setRotation(this.HLzRzT, 0.0F, 0.0F, -1.570796F);
    this.HLzRzB = new ModelRenderer(this, 20, 0);
    this.HLzRzB.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
    this.HLzRzB.setRotationPoint(-2.5F, 12.0F, -0.5F);
    this.HLzRzB.setTextureSize(64, 64);
    this.HLzRzB.mirror = true;
    setRotation(this.HLzRzB, 0.0F, 0.0F, -1.570796F);
    this.SHLzLzT = new ModelRenderer(this, 28, 0);
    this.SHLzLzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.SHLzLzT.setRotationPoint(2.5F, 7.0F, -0.5F);
    this.SHLzLzT.setTextureSize(64, 64);
    this.SHLzLzT.mirror = true;
    setRotation(this.SHLzLzT, 0.0F, 0.0F, 0.0F);
    this.SHLzLzB = new ModelRenderer(this, 28, 2);
    this.SHLzLzB.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
    this.SHLzLzB.setRotationPoint(1.0F, 13.0F, -0.5F);
    this.SHLzLzB.setTextureSize(64, 64);
    this.SHLzLzB.mirror = true;
    setRotation(this.SHLzLzB, 0.0F, 0.0F, 0.0F);
    this.SHLzRzT = new ModelRenderer(this, 28, 0);
    this.SHLzRzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.SHLzRzT.setRotationPoint(-3.5F, 7.0F, -0.5F);
    this.SHLzRzT.setTextureSize(64, 64);
    this.SHLzRzT.mirror = true;
    setRotation(this.SHLzRzT, 0.0F, 0.0F, 0.0F);
    this.SHLzRzB = new ModelRenderer(this, 28, 2);
    this.SHLzRzB.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
    this.SHLzRzB.setRotationPoint(-3.0F, 13.0F, -0.5F);
    this.SHLzRzB.setTextureSize(64, 64);
    this.SHLzRzB.mirror = true;
    setRotation(this.SHLzRzB, 0.0F, 0.0F, 0.0F);
    this.THLzT = new ModelRenderer(this, 28, 4);
    this.THLzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.THLzT.setRotationPoint(-0.5F, 7.0F, -0.5F);
    this.THLzT.setTextureSize(64, 64);
    this.THLzT.mirror = true;
    setRotation(this.THLzT, 0.0F, 0.0F, 0.0F);
    this.THLzR = new ModelRenderer(this, 28, 4);
    this.THLzR.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.THLzR.setRotationPoint(-3.5F, 10.0F, -0.5F);
    this.THLzR.setTextureSize(64, 64);
    this.THLzR.mirror = true;
    setRotation(this.THLzR, 0.0F, 0.0F, 0.0F);
    this.THLzL = new ModelRenderer(this, 28, 4);
    this.THLzL.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.THLzL.setRotationPoint(2.5F, 10.0F, -0.5F);
    this.THLzL.setTextureSize(64, 64);
    this.THLzL.mirror = true;
    setRotation(this.THLzL, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Stem.render(f5);
    this.Head.render(f5);
    this.LEAFzL.render(f5);
    this.LEAFzR.render(f5);
    this.HLzTzL.render(f5);
    this.HLzTzR.render(f5);
    this.HLzLzT.render(f5);
    this.HLzLzB.render(f5);
    this.HLzRzT.render(f5);
    this.HLzRzB.render(f5);
    this.SHLzLzT.render(f5);
    this.SHLzLzB.render(f5);
    this.SHLzRzT.render(f5);
    this.SHLzRzB.render(f5);
    this.THLzT.render(f5);
    this.THLzR.render(f5);
    this.THLzL.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
  }
}