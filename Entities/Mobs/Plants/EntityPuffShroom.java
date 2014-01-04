package CountryGamer_PlantsVsZombies.Entities.Mobs.Plants;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPuffShroom extends EntityShroomShooterBase
{
  public EntityPuffShroom(World world)
  {
    super(world, new ItemStack(PvZ_Main.nightPlants, 1, 0));
  }

  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    setMaxHealth(PvZ_Main.basePlantHealth / 2);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(this.baseHealth);
  }

  public void dropFewItems(boolean par1, int par2) {
    dropItem(PvZ_Main.shroomPod.itemID, 1);
  }

  public void onUpdate()
  {
    super.onUpdate();
    int lightBright = this.worldObj.getBlockLightValue((int)this.posX, (int)this.posY, (int)this.posZ);

    if ((this.worldObj != null) && (!this.worldObj.isRemote) && (
      ((this.worldObj.getWorldTime() < 0L) || (this.worldObj.getWorldTime() > 12000L)) || (
      (this.worldObj.getWorldTime() >= 12000L) && (this.worldObj.getWorldTime() <= 23999L))));
  }
}