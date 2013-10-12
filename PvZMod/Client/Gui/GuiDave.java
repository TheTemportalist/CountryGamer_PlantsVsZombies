package CountryGamer_PlantsVsZombies.PvZMod.Client.Gui;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityDave;

public class GuiDave extends GuiContainer
{
  public static final ResourceLocation bkgd = new ResourceLocation("countrygamer_plantsvszombies", "textures/gui/cDBox.png");

  public static final ResourceLocation sunflower = new ResourceLocation("countrygamer_plantsvszombies", "textures/items/Sunflower_Plant.png");
  private TileEntityDave tileEnt;
  private int page = 0;

  public GuiDave(InventoryPlayer invPlayer, TileEntityDave tileEnt) {
    super(new ContainerDave(invPlayer, tileEnt));
    this.tileEnt = tileEnt;
  }

  public void initGui()
  {
    super.initGui();
    this.buttonList.clear();
    int i = (this.width - this.xSize) / 2;
    int j = (this.height - this.ySize) / 2;

    this.buttonList.add(new GuiButton(0, i + 80, j + 15, 40, 20, "Plants"));
    this.buttonList.add(new GuiButton(1, i + 80 + 40, j + 15, 50, 20, "Upgrades"));
    this.buttonList.add(new GuiButton(2, i + 80, j + 35, 70, 20, "Plant Food"));
    switch (this.page)
    {
    case 0:
    }
  }

  protected void actionPerformed(GuiButton guiButton)
  {
    int id = guiButton.id;
    switch (id) {
    case 0:
      this.page = 0;
      initGui();
      break;
    case 1:
      this.page = 1;
      initGui();
      break;
    case 2:
      this.page = 2;
      initGui();
      break;
    }
  }

  protected void drawGuiContainerForegroundLayer(int par1, int par2)
  {
    String s = this.tileEnt.getInvName();
    this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
  }

  protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
  {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

    this.mc.getTextureManager().bindTexture(bkgd);
    int k = (this.width - this.xSize) / 2;
    int l = (this.height - this.ySize) / 2;
    drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
  }
}