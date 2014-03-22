package com.countrygamer.pvz.block.plant.tile.client.model;

import net.minecraft.client.model.ModelRenderer;

import com.countrygamer.core.Base.client.ModelBase;

public class ModelPeaShooter extends ModelBase {
	ModelRenderer	Stem;
	ModelRenderer	Head;
	ModelRenderer	Mouth;
	ModelRenderer	Head_Leaf;
	ModelRenderer	Shape1;
	ModelRenderer	Shape2;
	
	public ModelPeaShooter() {
		super(64, 64);
		
		this.Stem = new ModelRenderer(this, 6, 10);
		this.Stem.addBox(-1.0F, -10.0F, -1.0F, 2, 11, 2);
		this.Stem.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Stem.setTextureSize(64, 64);
		this.Stem.mirror = true;
		setRotation(this.Stem, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Stem);
		
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
		this.Head.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Head.setTextureSize(64, 64);
		this.Head.mirror = true;
		setRotation(this.Head, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Head);
		
		this.Mouth = new ModelRenderer(this, 20, 4);
		this.Mouth.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
		this.Mouth.setRotationPoint(0.0F, 11.5F, -2.5F);
		this.Mouth.setTextureSize(64, 64);
		this.Mouth.mirror = true;
		setRotation(this.Mouth, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Mouth);
		
		this.Head_Leaf = new ModelRenderer(this, 20, 0);
		this.Head_Leaf.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.Head_Leaf.setRotationPoint(0.0F, 9.0F, 2.0F);
		this.Head_Leaf.setTextureSize(64, 64);
		this.Head_Leaf.mirror = true;
		setRotation(this.Head_Leaf, 0.7853982F, 0.0F, 0.0F);
		this.modelList.add(this.Head_Leaf);
		
		this.Shape1 = new ModelRenderer(this, 0, 23);
		this.Shape1.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
		this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape1.setTextureSize(64, 64);
		this.Shape1.mirror = true;
		setRotation(this.Shape1, -0.1745329F, -0.1745329F, -0.261799F);
		this.modelList.add(this.Shape1);
		
		this.Shape2 = new ModelRenderer(this, 0, 23);
		this.Shape2.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
		this.Shape2.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape2.setTextureSize(64, 64);
		this.Shape2.mirror = true;
		setRotation(this.Shape2, -0.261799F, 0.1745329F, 0.1745329F);
		this.modelList.add(this.Shape2);
		
	}
	
	
}
