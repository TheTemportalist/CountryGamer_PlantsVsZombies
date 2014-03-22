package com.countrygamer.pvz.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.countrygamer.core.Base.client.gui.GuiButtonArrow;
import com.countrygamer.core.Base.client.gui.GuiButtonArrow.ButtonType;
import com.countrygamer.pvz.items.ItemGuideBook;
import com.countrygamer.pvz.lib.Reference;

public class GuiGuide extends GuiScreen {
	private static final ResourceLocation book = new ResourceLocation(
			Reference.MOD_ID, "textures/gui/book1.png");

	private int bookImageWidth = 256;
	private int bookImageHeight = 256;
	private int page = 0;
	private int totalPage = 20;
	private GuiButtonArrow nextRecipeButtonIndex;
	private GuiButtonArrow previousRecipeButtonIndex;
	private GuiButton a;
	private GuiButton b;
	private GuiButton c;
	private GuiButton d;
	private GuiButton e;
	private GuiButton f;
	public ItemGuideBook itemBook;

	public GuiGuide(ItemGuideBook itemBook) {
		this.itemBook = itemBook;
	}

	public void initGui() {
		super.initGui();

		int i = this.width / 2 - this.bookImageWidth / 2;
		int j = this.height / 2 - this.bookImageHeight / 2;
		this.buttonList.add(this.nextRecipeButtonIndex = new GuiButtonArrow(1,
				i + this.bookImageWidth - 30, j + 190, ButtonType.RIGHT));
		this.buttonList
				.add(this.previousRecipeButtonIndex = new GuiButtonArrow(2,
						i + 17, j + 190, ButtonType.LEFT));
		this.nextRecipeButtonIndex.enabled = false;
		this.previousRecipeButtonIndex.enabled = false;

		String table = "Table of Contents";
		int butW = table.length() * 6;
		int x = this.width / 2 - butW / 2;
		this.buttonList.add(new GuiButton(3, x, 20, butW, 20, table));
	}

	protected void actionPerformed(GuiButton gB) {
		int i = gB.id;
		switch (i) {
		case 0:
			this.page = 0;
			initGui();
			break;
		case 1:
			if (this.page >= this.totalPage)
				break;
			this.page += 1;
			break;
		case 2:
			if (this.page <= 0)
				break;
			this.page -= 1;
			break;
		case 4:
			this.page = 2;
			break;
		case 5:
			this.page = 4;
			break;
		case 6:
			this.page = 10;
			break;
		case 7:
			this.page = 12;
			break;
		case 8:
			this.page = 14;
			break;
		case 9:
			this.page = 17;
		case 3:
		}
	}

	public void updateScreen() {
		this.nextRecipeButtonIndex.enabled = (this.page < this.totalPage);
		this.previousRecipeButtonIndex.enabled = (this.page > 0);
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	public void drawScreen(int i, int j, float f) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(book);
		int k = this.width / 2 - this.bookImageWidth / 2;
		byte b0 = 30;
		drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth,
				this.bookImageHeight);

		initGui();

		int xl = k + 15;
		String[] str;
		int y1;
		switch (this.page) {
		case 0:
			string("TABLE OF CONTENTS", xl + 65, b0 + 15);
			break;
		case 1:
			str = new String[] { "Crazy Dave's Plant Guide",
					"By: TheCountryGamer", "Mod Website:",
					"plantsvszombies-minecraft.com",
					"I hope you enjoy the mod!" };

			int pCe = this.width / 2;
			string(str[0], xl + 55, b0 + 15);
			string(str[1], xl + 65, b0 + 30);
			string(str[2], xl + 80, b0 + 45);
			string(str[3], xl + 40, b0 + 55);
			string(str[4], xl + 50, b0 + 75);
			break;
		case 2:
			str = new String[] { "Getting Started",
					"First, you will need to collect some",
					"Chlorophyll. (insert picture)",
					"This can be CRAFTED from many natural",
					"things from the Vanilla (Not Modded) game.",
					"The full list is as follows:",
					"Seeds, Carrots, and Potato ITEMS will each",
					"output 2 Chlorophyll when CRAFTED.",
					"The Tall Grass BLOCK will give you 3",
					"Chlorophyll when CRAFTED." };

			string(str[0], xl + 75, b0 + 15);
			y1 = 20;
			for (int index = 1; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 3:
			str = new String[] { "Getting Started", "(continued)",
					"Any Leaves BLOCK", "will give you 4", "Chlorophyll when",
					"CRAFTED. The Cactus", "BLOCK will give you",
					"5 Chlorophyll when", "CRAFTED." };

			string(str[0], xl + 75, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 2; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 4:
			str = new String[] { "Getting the Utilities", "Chlorophyll Bowl",
					"First, you will need a Chlorophyll Bowl. This",
					"block allows you to produce Sunlight (During",
					"Daytime) and Moonlight (During Nighttime).",
					"HINT: You might try using a daytime",
					"controller like the CommandBlock to control",
					"production. To CRAFT a Chlorophyll Bowl,",
					"you will need 4 Chlorophyll and 1 Wooden",
					"Bowl. Place these in any old Crafting Bench",
					"in any slot." };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 15, b0 + 25);
			y1 = 30;
			for (int index = 2; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 5:
			str = new String[] { "Getting the Utilities", "(continued)",
					"Crazy Dave's Box",
					"Next up is Crazy Dave's Box. This box allows",
					"you to get the Tier 1 Plant(s), some Plant",
					"Food and the Recipes for Special Plants",
					"(All of these are described in the",
					"Greenhouse Section)." };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			string(str[2], xl + 15, b0 + 35);
			y1 = 40;
			for (int index = 3; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 6:
			str = new String[] { "Getting the Utilities", "(continued)",
					"If you (right) click on Crazy Dave's Box,",
					"you will open the GUI. You will find that on",
					"the bottom half is your inventory/hot-bar,",
					"and the top half consists 2 input slots and",
					"1 output slot. One of the input slots has",
					"the background of a Sunlight Item. This slot",
					"is where you will place either Sunlight or",
					"Moonlight, depending on the desired output.",
					"The other input slot is where you will put",
					"your modifier. This modifier helps determine",
					"which item will be outputted." };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 3; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 7:
			str = new String[] { "Getting the Utilities", "(continued)",
					"Greenhouse", "Now that you have Crazy Dave's Box, you",
					"can get the first Tier of items. These can",
					"later be upgraded using this block",
					"First things first. You can CRAFT the",
					"Greenhouse by putting 5 Glass Pane's, 1",
					"block of Dirt, and 2 blocks of Cobblestone",
					"in a Crafting Bench as so: (insert picture)" };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			string(str[2], xl + 15, b0 + 35);
			y1 = 40;
			for (int index = 3; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 8:
			str = new String[] { "Getting the Utilities", "(continued)",
					"After you place your Greenhouse, you can",
					"(right) click on the block to find this GUI:",
					"(insert picture)",
					"Here, you will find 1 input slot, 2 modifier",
					"slots, and 1 output slot (for now ;D). As of",
					"now, Plant Food and Special Recipes are NOT",
					"implemented." };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 3; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 9:
			str = new String[] { "Getting the Utilities", "(continued)",
					"To use the Greenhouse, first find your targeted",
					"output below. To get that output, you must",
					"put the appropriate; input item in the input",
					"(the slot with the pea shooter plant),",
					"modifier1 item in the modifier1 slot (the slot",
					"with the sunlight item), modifier2 item in the",
					"modifier2 slot (the slot with the snowball).",
					"Normally, each upgrade take approximately",
					"600 ticks (thats about 300 seconds)" };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 3; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 10:
			str = new String[] { "Getting Ready",
					"Alright. Cool. Now that you have at least the",
					"Pea Shooter plant (Tier 1: Day Faction), we",
					"can get ready to spawn him into the world.",
					"Assuming you have the PeaShooterPlant Item,",
					"we want to get the Grass that he needs to", "spawn on." };

			string(str[0], xl + 65, b0 + 15);
			y1 = 20;
			for (int index = 1; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 11:
			str = new String[] { "Getting Ready", "(continued)",
					"Endowed Grass",
					"When you (right) click with the Sunlight Item,",
					"you will spawn the Sunlight Projectile. If this",
					"hits Grass, Dirt or Mycelium, it will turn it",
					"into Endowed Grass.", "Darkened Grass",
					"When you (right) click with the Moonlight",
					"Item, you will spawn the Moonlight Projectile.",
					"If this hits Grass, Dirt or Mycelium, it",
					"will turn it into Darkened Grass." };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			string(str[2], xl + 15, b0 + 40);
			y1 = 40;
			for (int index = 3; index < 7; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			string(str[7], xl + 15, b0 + 90);
			y1 = 90;
			for (int index = 8; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 12:
			str = new String[] { "Spawning your Plant",
					"To spawn your plant, you must get the",
					"corresponding Plant Item (in this case; Pea",
					"Shooter Plant). With the Pea Shooter Plant,",
					"you will see above that it is a Tier 1: Day",
					"Faction Plant. This means it is a very basic",
					"Plant in the Faction of Day Plants. You will",
					"also note that the Block it spawns on is",
					"Endowed Grass. You will now want to place",
					"your Endowed Grass, that you made in",
					"'Getting Ready', right below where you want",
					"your Plant to spawn. When you spawn a Plant,",
					"it will turn the block below it into regular" };

			string(str[0], xl + 65, b0 + 15);
			y1 = 20;
			for (int index = 1; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 13:
			str = new String[] { "Spawing your Plant", "(continued)",
					"Grass, UNLESS it is said differently in the",
					"Notes section of that Plant in the 'Almanac'.",
					"On placing your Plant, you will note that the",
					"Plant Entity is spawned and the block below",
					"is turned into Grass (Unless otherwise",
					"noted). Your Plant is now ready to defend",
					"you and your home! Hooray!" };

			string(str[0], xl + 65, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 2; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 14:
			str = new String[] { "Getting Set",
					"Okay. So now you are ready to build a",
					"massive Plant army. But wait. What about",
					"tools? Well we come to you today to",
					"present: the Trowels! Thats right! Trowels!",
					"There are 2 Trowels. There is the normal",
					"Trowel and the Transplant Trowel. You might",
					"even be able to note what they do!",
					"Well right off the bat, they will help you",
					"to dig out dirt blocks (like Shovels/Spades",
					"do). They are made from IronIngots, and",
					"therefore have all the properties of a",
					"normal Iron Shovel." };

			string(str[0], xl + 75, b0 + 15);
			y1 = 20;
			for (int index = 1; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 15:
			str = new String[] { "Getting Set", "(continued)",
					"The Trowel will also do other things. First,",
					"if you (right) click on a Endowed Grass you",
					"will turn it back to Grass and get the",
					"Sunlight back, or Darkened Grass and get",
					"Moonlight back. If you use ((right) click) a",
					"Trowel on any Plant, you will instantly",
					"remove that Plant, gaining no resources in",
					"return. The Transplant Trowel will act the",
					"same as the Trowel, but if you (right) click",
					"on an Plant," };

			string(str[0], xl + 75, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 2; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 16:
			str = new String[] { "Getting Set", "(continued)",
					"you will get that Plant's Item back again.",
					"This way, if you accidentally place a",
					"plant where you didn't want it, you can",
					"re-plant that Plant!" };

			string(str[0], xl + 75, b0 + 15);
			string(str[1], xl + 80, b0 + 25);
			y1 = 30;
			for (int index = 2; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			break;
		case 17:
			str = new String[] { "Additional Things",
					"Now, aside from the way to get the plants,",
					"we also have other items and blocks that",
					"you can have fun with!", "Pod Projectiles",
					"So you know how those plants shoot pea",
					"pods, well now you can too! There are Pea",
					"Pods, Snow Pods, Shroom Pods, and",
					"Creeper Pods. To shoot these, you must",
					"(right) click, and it will spawn the",
					"projectile, using it up." };

			string(str[0], xl + 75, b0 + 15);
			y1 = 15;
			for (int index = 1; index < 4; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}
			y1 += 10;
			string(str[4], xl + 20, b0 + y1);
			for (int index = 5; index < str.length; index++) {
				y1 += 10;
				string(str[index], xl, b0 + y1);
			}

		}

		super.drawScreen(i, j, f);
	}

	private void string(String str, int x, int y) {
		this.fontRendererObj.drawString(str, x, y, 0);
	}
}