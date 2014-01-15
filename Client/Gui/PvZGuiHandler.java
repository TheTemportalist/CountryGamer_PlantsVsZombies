package CountryGamer_PlantsVsZombies.Client.Gui;

import CountryGamer_PlantsVsZombies.Blocks.TileEnts.TileEntityDave;
import CountryGamer_PlantsVsZombies.Blocks.TileEnts.TileEntityGreenhouse;
import CountryGamer_PlantsVsZombies.Items.ItemGuideBook;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PvZGuiHandler implements IGuiHandler {
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEnt = world.getBlockTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new ContainerGreenhouse(player.inventory,
					(TileEntityGreenhouse) tileEnt);
		}
		if ((tileEnt instanceof TileEntityDave)) {
			return new ContainerDave(player.inventory, (TileEntityDave) tileEnt);
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEnt = world.getBlockTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new GuiGreenhouse(player.inventory,
					(TileEntityGreenhouse) tileEnt);
		}
		if ((tileEnt instanceof TileEntityDave)) {
			return new GuiDave(player.inventory, (TileEntityDave) tileEnt);
		}
		if (ID == 3) {
			return new GuiGuide((ItemGuideBook) player.inventory
					.getCurrentItem().getItem());
		}
		return null;
	}
}