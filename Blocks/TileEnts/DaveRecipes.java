package CountryGamer_PlantsVsZombies.Blocks.TileEnts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CountryGamer_PlantsVsZombies.PvZ_Util;
import net.minecraft.item.ItemStack;

public class DaveRecipes
{
  private static final DaveRecipes smeltingBase = new DaveRecipes();

  private Map smeltingList = new HashMap();
  private Map experienceList = new HashMap();
  private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap();

  private HashMap<List<Integer>, Float> metaExperience = new HashMap();

  public static final DaveRecipes smelting()
  {
    return smeltingBase;
  }

  public void addSmelting(ItemStack inputStack, ItemStack modify1, ItemStack output)
  {
    this.metaSmeltingList.put(Arrays.asList(new Integer[] { Integer.valueOf(inputStack.itemID), Integer.valueOf(inputStack.getItemDamage()), Integer.valueOf(modify1.itemID), Integer.valueOf(modify1.getItemDamage()) }), output);
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

  public ItemStack getSmeltingResult(ItemStack inputStack, ItemStack modify1)
  {
    if (inputStack == null)
    {
      return null;
    }
    if (modify1 == null)
      modify1 = PvZ_Util.nullStack;
    ItemStack ret = (ItemStack)this.metaSmeltingList.get(Arrays.asList(new Integer[] { Integer.valueOf(inputStack.itemID), Integer.valueOf(inputStack.getItemDamage()), Integer.valueOf(modify1.itemID), Integer.valueOf(modify1.getItemDamage()) }));

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