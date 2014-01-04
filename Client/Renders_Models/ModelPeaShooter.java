package CountryGamer_PlantsVsZombies.Client.Renders_Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPeaShooter extends ModelBase
{
  ModelRenderer Stem;
  ModelRenderer Head;
  ModelRenderer Mouth;
  ModelRenderer Head_Leaf;
  ModelRenderer Shape1;
  ModelRenderer Shape2;

  public ModelPeaShooter()
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
    this.Mouth = new ModelRenderer(this, 20, 4);
    this.Mouth.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
    this.Mouth.setRotationPoint(0.0F, 11.5F, -2.5F);
    this.Mouth.setTextureSize(64, 64);
    this.Mouth.mirror = true;
    setRotation(this.Mouth, 0.0F, 0.0F, 0.0F);
    this.Head_Leaf = new ModelRenderer(this, 20, 0);
    this.Head_Leaf.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
    this.Head_Leaf.setRotationPoint(0.0F, 9.0F, 2.0F);
    this.Head_Leaf.setTextureSize(64, 64);
    this.Head_Leaf.mirror = true;
    setRotation(this.Head_Leaf, 0.7853982F, 0.0F, 0.0F);
    this.Shape1 = new ModelRenderer(this, 0, 23);
    this.Shape1.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
    this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape1.setTextureSize(64, 64);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, -0.1745329F, -0.1745329F, -0.261799F);
    this.Shape2 = new ModelRenderer(this, 0, 23);
    this.Shape2.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
    this.Shape2.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape2.setTextureSize(64, 64);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, -0.261799F, 0.1745329F, 0.1745329F);
  }

  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    this.Stem.render(par7);
    this.Head.render(par7);
    this.Mouth.render(par7);
    this.Head_Leaf.render(par7);
    this.Shape1.render(par7);
    this.Shape2.render(par7);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7entity)
  {
  }
}