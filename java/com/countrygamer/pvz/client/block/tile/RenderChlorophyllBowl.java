package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.countrygamer.pvz.block.tile.TileEntityChlorophyllBowl;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderChlorophyllBowl extends TileEntitySpecialRenderer
{
  private ModelChlorophyllBowl aModel;

  public RenderChlorophyllBowl()
  {
    this.aModel = new ModelChlorophyllBowl();
  }
  @SideOnly(Side.CLIENT)
  public void renderAModelAt(TileEntityChlorophyllBowl tileEnt, double x, double y, double z, float f) {
    int metadata = tileEnt.getBlockMetadata();
    int rotationAngle = 0;
    if (metadata % 4 == 0) {
      rotationAngle = 0;
    }
    if (metadata % 4 == 1) {
      rotationAngle = 270;
    }
    if (metadata % 4 == 2) {
      rotationAngle = 180;
    }
    if (metadata % 4 == 3) {
      rotationAngle = 90;
    }

    GL11.glPushMatrix();
    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

    this.bindTexture(Resources.chlorophyllBowl);

    GL11.glPushMatrix();
    this.aModel.renderModel(0.0625F);
    GL11.glPopMatrix();
    GL11.glPopMatrix();
  }
  @SideOnly(Side.CLIENT)
  public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
    renderAModelAt((TileEntityChlorophyllBowl)tileentity, x, y, z, f);
  }
}