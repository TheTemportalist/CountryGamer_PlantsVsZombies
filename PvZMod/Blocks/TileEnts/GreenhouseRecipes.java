package CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Util;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GreenhouseRecipes
{
  private static final GreenhouseRecipes smeltingBase = new GreenhouseRecipes();

  private Map smeltingList = new HashMap();
  private Map experienceList = new HashMap();
  private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap();

  private HashMap<List<Integer>, Float> metaExperience = new HashMap();

  public static final GreenhouseRecipes smelting()
  {
    return smeltingBase;
  }

  private GreenhouseRecipes()
  {
    addSmelting(new ItemStack(Item.seeds, 1, 0), new ItemStack(PvZ_Main.sunlight, 1, 0), new ItemStack(PvZ_Main.sunlight, 1, 0), new ItemStack(PvZ_Main.basicPlants, 1, 0), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 0), new ItemStack(PvZ_Main.moonlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.nightPlants, 1, 3), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.peaPod, 1, 0), new ItemStack(PvZ_Main.sunlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.basicPlants, 1, 1), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 1), new ItemStack(PvZ_Main.sunlight, 1, 0), new ItemStack(Item.snowball, 1, 0), new ItemStack(PvZ_Main.basicPlants, 1, 2), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 1), new ItemStack(PvZ_Main.sunlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.basicPlants, 1, 3), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 3), new ItemStack(PvZ_Main.sunlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.basicPlants, 1, 4), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 3), new ItemStack(PvZ_Main.sunlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.basicPlants, 1, 4), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.basicPlants, 1, 1), new ItemStack(PvZ_Main.moonlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.nightPlants, 1, 0), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.nightPlants, 1, 0), new ItemStack(PvZ_Main.moonlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.nightPlants, 1, 1), 0.0F);

    addSmelting(new ItemStack(PvZ_Main.nightPlants, 1, 1), new ItemStack(PvZ_Main.moonlight, 1, 0), PvZ_Util.nullStack, new ItemStack(PvZ_Main.nightPlants, 1, 2), 0.0F);
  }

  public void addSmelting(ItemStack input, ItemStack modify1, ItemStack modify2, ItemStack output, float experience)
  {
    this.metaSmeltingList.put(Arrays.asList(new Integer[] { Integer.valueOf(input.itemID), Integer.valueOf(input.getItemDamage()), Integer.valueOf(modify1.itemID), Integer.valueOf(modify1.getItemDamage()), Integer.valueOf(modify2.itemID), Integer.valueOf(modify2.getItemDamage()) }), output);
  }

  @Deprecated
  public ItemStack getSmeltingResult(int par1)
  {
    return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
  }

  public Map getSmeltingList()
  {
    return this.smeltingList;
  }

  @Deprecated
  public float getExperience(int par1) {
    return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
  }

  public ItemStack getSmeltingResult(ItemStack inputStack, ItemStack modify1, ItemStack modify2)
  {
    if ((inputStack == null) || (modify1 == null))
    {
      return null;
    }
    if (modify2 == null)
      modify2 = PvZ_Util.nullStack;
    ItemStack ret = (ItemStack)this.metaSmeltingList.get(Arrays.asList(new Integer[] { Integer.valueOf(inputStack.itemID), Integer.valueOf(inputStack.getItemDamage()), Integer.valueOf(modify1.itemID), Integer.valueOf(modify1.getItemDamage()), Integer.valueOf(modify2.itemID), Integer.valueOf(modify2.getItemDamage()) }));

    if (ret != null)
    {
      return ret;
    }
    return null;
  }

  public float getExperience(ItemStack item)
  {
    if ((item == null) || (item.getItem() == null))
    {
      return 0.0F;
    }
    float ret = item.getItem().getSmeltingExperience(item);
    if (ret < 0.0F) if (this.metaExperience.containsKey(Arrays.asList(new Integer[] { Integer.valueOf(item.itemID), Integer.valueOf(item.getItemDamage()) })))
      {
        ret = ((Float)this.metaExperience.get(Arrays.asList(new Integer[] { Integer.valueOf(item.itemID), Integer.valueOf(item.getItemDamage()) }))).floatValue();
      }
    if ((ret < 0.0F) && (this.experienceList.containsKey(Integer.valueOf(item.itemID))))
    {
      ret = ((Float)this.experienceList.get(Integer.valueOf(item.itemID))).floatValue();
    }
    return ret < 0.0F ? 0.0F : ret;
  }

  public Map<List<Integer>, ItemStack> getMetaSmeltingList()
  {
    return this.metaSmeltingList;
  }
}