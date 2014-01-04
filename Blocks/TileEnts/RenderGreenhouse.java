package CountryGamer_PlantsVsZombies.Blocks.TileEnts;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import CountryGamer_PlantsVsZombies.Resources;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderGreenhouse extends TileEntitySpecialRenderer
{
  private ModelGreenhouse aModel;
  private final RenderItem renderItem1;

  public RenderGreenhouse()
  {
    this.aModel = new ModelGreenhouse();
    this.renderItem1 = new RenderItem()
    {
      public byte getMiniBlockCount(ItemStack stack) {
        return 1;
      }

      public byte getMiniItemCount(ItemStack stack) {
        return 1;
      }

      public boolean shouldBob()
      {
        return false;
      }

      public boolean shouldSpreadItems()
      {
        return false;
      }
    };
    this.renderItem1.setRenderManager(RenderManager.instance);
  }
  @SideOnly(Side.CLIENT)
  public void renderAModelAt(TileEntityGreenhouse tileEnt, double x, double y, double z, float f) {
    GL11.glPushMatrix();
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
    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

    this.tileEntityRenderer.renderEngine.bindTexture(Resources.greenhouse);

    this.aModel.renderModel(0.0625F);
    GL11.glPopMatrix();

    GL11.glPushMatrix();
    if (tileEnt.getStackInSlot(0) != null) {
      float scaleFactor = 0.1F;
      float rotationAngle2 = (float)(720.0D * (System.currentTimeMillis() & 0x3FFF) / 16383.0D);
      EntityItem ghostEntityItem = new EntityItem(tileEnt.worldObj);
      ghostEntityItem.hoverStart = 0.0F;
      ghostEntityItem.setEntityItemStack(tileEnt.getStackInSlot(0));
      //translateGhostItemByOrientation(ghostEntityItem.getEntityItem(), x, y, z, ForgeDirection.UNKNOWN);
      GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
      GL11.glRotatef(rotationAngle2, 0.0F, 1.0F, 0.0F);
    }

    GL11.glPopMatrix();
  }

  @SideOnly(Side.CLIENT)
  public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
    renderAModelAt((TileEntityGreenhouse)tileentity, x, y, z, f);
  }

  /*
  private void translateGhostItemByOrientation(ItemStack ghostItemStack, double x, double y, double z, ForgeDirection forgeDirection)
  {
    if (ghostItemStack != null) {
      if ((ghostItemStack.getItem() instanceof ItemBlock)) {
        switch (2.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
        case 1:
          GL11.glTranslatef((float)x + 0.5F, (float)y + 0.7F, (float)z + 0.5F);
          return;
        case 2:
          GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
          return;
        case 3:
          GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.7F);
          return;
        case 4:
          GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.3F);
          return;
        case 5:
          GL11.glTranslatef((float)x + 0.3F, (float)y + 0.5F, (float)z + 0.5F);
          return;
        case 6:
          GL11.glTranslatef((float)x + 0.7F, (float)y + 0.5F, (float)z + 0.5F);
          return;
        case 7:
          return;
        }

        return;
      }

      switch (2.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
      case 1:
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.6F, (float)z + 0.5F);
        return;
      case 2:
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.2F, (float)z + 0.5F);
        return;
      case 3:
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.4F, (float)z + 0.7F);
        return;
      case 4:
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.4F, (float)z + 0.3F);
        return;
      case 5:
        GL11.glTranslatef((float)x + 0.3F, (float)y + 0.4F, (float)z + 0.5F);
        return;
      case 6:
        GL11.glTranslatef((float)x + 0.7F, (float)y + 0.4F, (float)z + 0.5F);
        return;
      case 7:
        return;
      }

      return;
    }
  }

  private float getGhostItemScaleFactor(ItemStack itemStack)
  {
    float scaleFactor = 1.0F;

    if (itemStack != null) {
      if ((itemStack.getItem() instanceof ItemBlock)) {
        switch (this.renderItem1.getMiniBlockCount(itemStack)) {
        case 1:
          return 0.9F;
        case 2:
          return 0.9F;
        case 3:
          return 0.9F;
        case 4:
          return 0.9F;
        case 5:
          return 0.8F;
        }
        return 0.9F;
      }

      switch (this.renderItem1.getMiniItemCount(itemStack)) {
      case 1:
        return 0.65F;
      case 2:
        return 0.65F;
      case 3:
        return 0.65F;
      case 4:
        return 0.65F;
      }
      return 0.65F;
    }

    return scaleFactor;
  }
  */
  
}