package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.countrygamer.pvz.block.tile.TileEntityGravestone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderGravestone extends TileEntitySpecialRenderer
{
  private ModelGravestone aModel;

  public RenderGravestone()
  {
    this.aModel = new ModelGravestone();
  }
  @SideOnly(Side.CLIENT)
  public void renderAModelAt(TileEntityGravestone tileEnt, double x, double y, double z, float f) {
    int metadata = tileEnt.facing;
    int rotationAngle = 0;
    if (metadata == 0) {
      rotationAngle = 0;
    }
    if (metadata == 1) {
      rotationAngle = 90;
    }
    if (metadata == 2) {
      rotationAngle = 180;
    }
    if (metadata == 3) {
      rotationAngle = 270;
    }

    GL11.glPushMatrix();
    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

    this.bindTexture(tileEnt.typeTexture[tileEnt.type]);

    GL11.glPushMatrix();
    this.aModel.renderModel(0.0625F);
    GL11.glPopMatrix();
    GL11.glPopMatrix();
  }
  @SideOnly(Side.CLIENT)
  public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
    renderAModelAt((TileEntityGravestone)tileentity, x, y, z, f);
  }
}