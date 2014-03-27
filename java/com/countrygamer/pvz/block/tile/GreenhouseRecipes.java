package com.countrygamer.pvz.block.tile;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.lib.Util;

public class GreenhouseRecipes {

	private static final GreenhouseRecipes smeltingBase = new GreenhouseRecipes();

	private Map<ItemStack[], ItemStack> smeltingList = new HashMap<ItemStack[], ItemStack>();

	public static final GreenhouseRecipes smelting() {
		return smeltingBase;
	}

	private GreenhouseRecipes() {
		addRecipe(new ItemStack(Items.wheat_seeds, 1, 0), new ItemStack(
				PvZ.sunlight, 1, 0), new ItemStack(PvZ.sunlight, 1, 0),
				new ItemStack(PvZ.basicPlants, 1, 0), 0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 0), new ItemStack(
				PvZ.moonlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.nightPlants, 1, 3), 0.0F);

		addRecipe(new ItemStack(PvZ.peaPod, 1, 0), new ItemStack(PvZ.sunlight,
				1, 0), Util.nullStack, new ItemStack(PvZ.basicPlants, 1, 1),
				0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 1), new ItemStack(
				PvZ.sunlight, 1, 0), new ItemStack(Items.snowball, 1, 0),
				new ItemStack(PvZ.basicPlants, 1, 2), 0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 1), new ItemStack(
				PvZ.sunlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.basicPlants, 1, 3), 0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 3), new ItemStack(
				PvZ.sunlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.basicPlants, 1, 4), 0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 3), new ItemStack(
				PvZ.sunlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.basicPlants, 1, 4), 0.0F);

		addRecipe(new ItemStack(PvZ.basicPlants, 1, 1), new ItemStack(
				PvZ.moonlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.nightPlants, 1, 0), 0.0F);

		addRecipe(new ItemStack(PvZ.nightPlants, 1, 0), new ItemStack(
				PvZ.moonlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.nightPlants, 1, 1), 0.0F);

		addRecipe(new ItemStack(PvZ.nightPlants, 1, 1), new ItemStack(
				PvZ.moonlight, 1, 0), Util.nullStack, new ItemStack(
				PvZ.nightPlants, 1, 2), 0.0F);
	}

	public void addRecipe(ItemStack input, ItemStack modify1,
			ItemStack modify2, ItemStack output, float experience) {
		this.smeltingList.put(new ItemStack[] { input, modify1, modify2 },
				output);
	}

	public ItemStack getResult(ItemStack input, ItemStack modify1,
			ItemStack modify2) {
		// Key is; ItemStack[]
		// Value is; ItemStack
		// Entry is; ItemStack[], ItemStack

		for (Object thing : this.smeltingList.keySet()) {
			ItemStack[] stackArr = (ItemStack[]) thing;
			ItemStack[] inputs = new ItemStack[] { stackArr[0], input };
			ItemStack[] mod1 = new ItemStack[] { stackArr[1], modify1 };
			ItemStack[] mod2 = null;
			if (modify2 != null)
				mod2  = new ItemStack[] { stackArr[2], modify2 };
			if (this.checkForStack(inputs, mod1, mod2)) {
				return (ItemStack) this.smeltingList.get(stackArr);
			}
		}
		return null;
	}

	private boolean checkForStack(ItemStack[] inputs, ItemStack[] mod1,
			ItemStack[] mod2) {
		boolean validInput = inputs[1].getItem() == inputs[0].getItem()
				&& (inputs[1].getItemDamage() == 32767 || inputs[1]
						.getItemDamage() == inputs[0].getItemDamage());
		boolean validMod1 = mod1[1].getItem() == mod1[0].getItem()
				&& (mod1[1].getItemDamage() == 32767 || mod1[1].getItemDamage() == mod1[0]
						.getItemDamage());
		boolean validMod2 = true;
		if (mod2 != null)
			validMod2 = mod2[1].getItem() == mod2[0].getItem()
					&& (mod2[1].getItemDamage() == 32767 || mod2[1]
							.getItemDamage() == mod2[0].getItemDamage());

		return validInput && validMod1 && validMod2;
	}

	public Map<ItemStack[], ItemStack> getSmeltingList() {
		return this.smeltingList;
	}
}
