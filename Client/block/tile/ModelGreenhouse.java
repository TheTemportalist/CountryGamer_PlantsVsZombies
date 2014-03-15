package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGreenhouse extends ModelBase {
	ModelRenderer InnerBox;
	ModelRenderer Glass;
	ModelRenderer FRBar;
	ModelRenderer ARBar;
	ModelRenderer FLBar;
	ModelRenderer ALBar;
	ModelRenderer TRBar;
	ModelRenderer TABar;
	ModelRenderer TLBar;
	ModelRenderer TFBar;
	ModelRenderer BFBar;
	ModelRenderer BRBar;
	ModelRenderer BABar;
	ModelRenderer BLBar;
	ModelRenderer Stem;
	ModelRenderer Leaf1;
	ModelRenderer Leaf2;

	public ModelGreenhouse() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.InnerBox = new ModelRenderer(this, 0, 25);
		this.InnerBox.addBox(0.0F, 0.0F, 0.0F, 14, 4, 14);
		this.InnerBox.setRotationPoint(-7.0F, 20.0F, -7.0F);
		this.InnerBox.setTextureSize(128, 64);
		this.InnerBox.mirror = true;
		setRotation(this.InnerBox, 0.0F, 0.0F, 0.0F);
		this.Glass = new ModelRenderer(this, 0, 0);
		this.Glass.addBox(0.0F, 0.0F, 0.0F, 14, 11, 14);
		this.Glass.setRotationPoint(-7.0F, 9.0F, -7.0F);
		this.Glass.setTextureSize(128, 64);
		this.Glass.mirror = true;
		setRotation(this.Glass, 0.0F, 0.0F, 0.0F);
		this.FRBar = new ModelRenderer(this, 56, 0);
		this.FRBar.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
		this.FRBar.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.FRBar.setTextureSize(128, 64);
		this.FRBar.mirror = true;
		setRotation(this.FRBar, 0.0F, 0.0F, 0.0F);
		this.ARBar = new ModelRenderer(this, 56, 0);
		this.ARBar.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
		this.ARBar.setRotationPoint(-8.0F, 8.0F, 7.0F);
		this.ARBar.setTextureSize(128, 64);
		this.ARBar.mirror = true;
		setRotation(this.ARBar, 0.0F, 0.0F, 0.0F);
		this.FLBar = new ModelRenderer(this, 56, 0);
		this.FLBar.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
		this.FLBar.setRotationPoint(7.0F, 8.0F, -8.0F);
		this.FLBar.setTextureSize(128, 64);
		this.FLBar.mirror = true;
		setRotation(this.FLBar, 0.0F, 0.0F, 0.0F);
		this.ALBar = new ModelRenderer(this, 56, 0);
		this.ALBar.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
		this.ALBar.setRotationPoint(7.0F, 8.0F, 7.0F);
		this.ALBar.setTextureSize(128, 64);
		this.ALBar.mirror = true;
		setRotation(this.ALBar, 0.0F, 0.0F, 0.0F);
		this.TRBar = new ModelRenderer(this, 56, 4);
		this.TRBar.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14);
		this.TRBar.setRotationPoint(-8.0F, 8.0F, -7.0F);
		this.TRBar.setTextureSize(128, 64);
		this.TRBar.mirror = true;
		setRotation(this.TRBar, 0.0F, 0.0F, 0.0F);
		this.TABar = new ModelRenderer(this, 56, 20);
		this.TABar.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.TABar.setRotationPoint(-7.0F, 8.0F, 7.0F);
		this.TABar.setTextureSize(128, 64);
		this.TABar.mirror = true;
		setRotation(this.TABar, 0.0F, 0.0F, 0.0F);
		this.TLBar = new ModelRenderer(this, 56, 4);
		this.TLBar.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14);
		this.TLBar.setRotationPoint(7.0F, 8.0F, -7.0F);
		this.TLBar.setTextureSize(128, 64);
		this.TLBar.mirror = true;
		setRotation(this.TLBar, 0.0F, 0.0F, 0.0F);
		this.TFBar = new ModelRenderer(this, 56, 20);
		this.TFBar.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.TFBar.setRotationPoint(-7.0F, 8.0F, -8.0F);
		this.TFBar.setTextureSize(128, 64);
		this.TFBar.mirror = true;
		setRotation(this.TFBar, 0.0F, 0.0F, 0.0F);
		this.BFBar = new ModelRenderer(this, 56, 20);
		this.BFBar.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.BFBar.setRotationPoint(-7.0F, 23.0F, -8.0F);
		this.BFBar.setTextureSize(128, 64);
		this.BFBar.mirror = true;
		setRotation(this.BFBar, 0.0F, 0.0F, 0.0F);
		this.BRBar = new ModelRenderer(this, 56, 4);
		this.BRBar.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14);
		this.BRBar.setRotationPoint(-8.0F, 23.0F, -7.0F);
		this.BRBar.setTextureSize(128, 64);
		this.BRBar.mirror = true;
		setRotation(this.BRBar, 0.0F, 0.0F, 0.0F);
		this.BABar = new ModelRenderer(this, 56, 20);
		this.BABar.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.BABar.setRotationPoint(-7.0F, 23.0F, 7.0F);
		this.BABar.setTextureSize(128, 64);
		this.BABar.mirror = true;
		setRotation(this.BABar, 0.0F, 0.0F, 0.0F);
		this.BLBar = new ModelRenderer(this, 56, 4);
		this.BLBar.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14);
		this.BLBar.setRotationPoint(7.0F, 23.0F, -7.0F);
		this.BLBar.setTextureSize(128, 64);
		this.BLBar.mirror = true;
		setRotation(this.BLBar, 0.0F, 0.0F, 0.0F);
		this.Stem = new ModelRenderer(this, 0, 0);
		this.Stem.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.Stem.setRotationPoint(-0.5F, 18.0F, -0.5F);
		this.Stem.setTextureSize(128, 64);
		this.Stem.mirror = true;
		setRotation(this.Stem, 0.0F, 0.0F, 0.0F);
		this.Leaf1 = new ModelRenderer(this, 0, 4);
		this.Leaf1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
		this.Leaf1.setRotationPoint(0.5F, 17.5F, -1.0F);
		this.Leaf1.setTextureSize(128, 64);
		this.Leaf1.mirror = true;
		setRotation(this.Leaf1, 0.0F, 0.0F, 0.0F);
		this.Leaf2 = new ModelRenderer(this, 0, 4);
		this.Leaf2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
		this.Leaf2.setRotationPoint(-2.5F, 17.5F, -1.0F);
		this.Leaf2.setTextureSize(128, 64);
		this.Leaf2.mirror = true;
		setRotation(this.Leaf2, 0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		this.InnerBox.render(f5);
		this.Glass.render(f5);
		this.FRBar.render(f5);
		this.ARBar.render(f5);
		this.FLBar.render(f5);
		this.ALBar.render(f5);
		this.TRBar.render(f5);
		this.TABar.render(f5);
		this.TLBar.render(f5);
		this.TFBar.render(f5);
		this.BFBar.render(f5);
		this.BRBar.render(f5);
		this.BABar.render(f5);
		this.BLBar.render(f5);
		this.Stem.render(f5);
		this.Leaf1.render(f5);
		this.Leaf2.render(f5);
	}

	public void renderModel(float f5) {
		this.InnerBox.render(f5);
		this.Glass.render(f5);
		this.FRBar.render(f5);
		this.ARBar.render(f5);
		this.FLBar.render(f5);
		this.ALBar.render(f5);
		this.TRBar.render(f5);
		this.TABar.render(f5);
		this.TLBar.render(f5);
		this.TFBar.render(f5);
		this.BFBar.render(f5);
		this.BRBar.render(f5);
		this.BABar.render(f5);
		this.BLBar.render(f5);
		this.Stem.render(f5);
		this.Leaf1.render(f5);
		this.Leaf2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
	}
}