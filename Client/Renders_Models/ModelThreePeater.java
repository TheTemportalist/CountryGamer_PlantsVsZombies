package CountryGamer_PlantsVsZombies.Client.Renders_Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelThreePeater extends ModelBase
{
  ModelRenderer STEMzC;
  ModelRenderer HEADzC;
  ModelRenderer MOUTHzC;
  ModelRenderer HEADLEAFzC;
  ModelRenderer LEAFzL;
  ModelRenderer LEAFzR;
  ModelRenderer STEMzR;
  ModelRenderer STEMzL;
  ModelRenderer HEADzL;
  ModelRenderer HEADLEAFzL;
  ModelRenderer MOUTHzL;
  ModelRenderer HEADzR;
  ModelRenderer HEADLEAFzR;
  ModelRenderer MOUTHzR;

  public ModelThreePeater()
  {
    this.textureWidth = 64;
    this.textureHeight = 64;

    this.STEMzC = new ModelRenderer(this, 6, 8);
    this.STEMzC.addBox(-1.0F, -10.0F, -1.0F, 2, 11, 2);
    this.STEMzC.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.STEMzC.setTextureSize(64, 64);
    this.STEMzC.mirror = true;
    setRotation(this.STEMzC, 0.0F, 0.0F, 0.0F);
    this.HEADzC = new ModelRenderer(this, 0, 0);
    this.HEADzC.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
    this.HEADzC.setRotationPoint(0.0F, 13.0F, 0.0F);
    this.HEADzC.setTextureSize(64, 64);
    this.HEADzC.mirror = true;
    setRotation(this.HEADzC, 0.0F, 0.0F, 0.0F);
    this.MOUTHzC = new ModelRenderer(this, 20, 4);
    this.MOUTHzC.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 2);
    this.MOUTHzC.setRotationPoint(0.0F, 11.5F, -1.5F);
    this.MOUTHzC.setTextureSize(64, 64);
    this.MOUTHzC.mirror = true;
    setRotation(this.MOUTHzC, 0.0F, 0.0F, 0.0F);
    this.HEADLEAFzC = new ModelRenderer(this, 20, 0);
    this.HEADLEAFzC.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
    this.HEADLEAFzC.setRotationPoint(0.0F, 10.0F, 1.0F);
    this.HEADLEAFzC.setTextureSize(64, 64);
    this.HEADLEAFzC.mirror = true;
    setRotation(this.HEADLEAFzC, 0.7853982F, 0.0F, 0.0F);
    this.LEAFzL = new ModelRenderer(this, 0, 21);
    this.LEAFzL.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
    this.LEAFzL.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.LEAFzL.setTextureSize(64, 64);
    this.LEAFzL.mirror = true;
    setRotation(this.LEAFzL, -0.1745329F, -0.1745329F, -0.261799F);
    this.LEAFzR = new ModelRenderer(this, 0, 21);
    this.LEAFzR.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
    this.LEAFzR.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.LEAFzR.setTextureSize(64, 64);
    this.LEAFzR.mirror = true;
    setRotation(this.LEAFzR, -0.261799F, 0.1745329F, 0.1745329F);
    this.STEMzR = new ModelRenderer(this, 6, 8);
    this.STEMzR.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2);
    this.STEMzR.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.STEMzR.setTextureSize(64, 64);
    this.STEMzR.mirror = true;
    setRotation(this.STEMzR, 0.0F, 0.0F, -0.4363323F);
    this.STEMzL = new ModelRenderer(this, 6, 8);
    this.STEMzL.addBox(-1.0F, -11.0F, -1.0F, 2, 11, 2);
    this.STEMzL.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.STEMzL.setTextureSize(64, 64);
    this.STEMzL.mirror = true;
    setRotation(this.STEMzL, 0.0F, 0.0F, 0.4363323F);
    this.HEADzL = new ModelRenderer(this, 0, 0);
    this.HEADzL.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
    this.HEADzL.setRotationPoint(4.5F, 14.0F, 0.0F);
    this.HEADzL.setTextureSize(64, 64);
    this.HEADzL.mirror = true;
    setRotation(this.HEADzL, 0.0F, 0.0F, 0.4363323F);
    this.HEADLEAFzL = new ModelRenderer(this, 20, 0);
    this.HEADLEAFzL.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
    this.HEADLEAFzL.setRotationPoint(6.0F, 11.0F, 1.0F);
    this.HEADLEAFzL.setTextureSize(64, 64);
    this.HEADLEAFzL.mirror = true;
    setRotation(this.HEADLEAFzL, 0.7853982F, 0.0F, 0.4363323F);
    this.MOUTHzL = new ModelRenderer(this, 20, 4);
    this.MOUTHzL.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
    this.MOUTHzL.setRotationPoint(5.25F, 12.25F, -2.0F);
    this.MOUTHzL.setTextureSize(64, 64);
    this.MOUTHzL.mirror = true;
    setRotation(this.MOUTHzL, 0.0F, 0.0F, 0.4363323F);
    this.HEADzR = new ModelRenderer(this, 0, 0);
    this.HEADzR.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
    this.HEADzR.setRotationPoint(-4.5F, 14.0F, 0.0F);
    this.HEADzR.setTextureSize(64, 64);
    this.HEADzR.mirror = true;
    setRotation(this.HEADzR, 0.0F, 0.0F, -0.4363323F);
    this.HEADLEAFzR = new ModelRenderer(this, 20, 0);
    this.HEADLEAFzR.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
    this.HEADLEAFzR.setRotationPoint(-6.0F, 11.0F, 1.0F);
    this.HEADLEAFzR.setTextureSize(64, 64);
    this.HEADLEAFzR.mirror = true;
    setRotation(this.HEADLEAFzR, 0.7853982F, 0.0F, -0.4363323F);
    this.MOUTHzR = new ModelRenderer(this, 20, 4);
    this.MOUTHzR.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
    this.MOUTHzR.setRotationPoint(-5.25F, 12.3F, -2.0F);
    this.MOUTHzR.setTextureSize(64, 64);
    this.MOUTHzR.mirror = true;
    setRotation(this.MOUTHzR, 0.0F, 0.0F, -0.4363323F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.STEMzC.render(f5);
    this.HEADzC.render(f5);
    this.MOUTHzC.render(f5);
    this.HEADLEAFzC.render(f5);
    this.LEAFzL.render(f5);
    this.LEAFzR.render(f5);
    this.STEMzR.render(f5);
    this.STEMzL.render(f5);
    this.HEADzL.render(f5);
    this.HEADLEAFzL.render(f5);
    this.MOUTHzL.render(f5);
    this.HEADzR.render(f5);
    this.HEADLEAFzR.render(f5);
    this.MOUTHzR.render(f5);
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