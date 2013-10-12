package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants;

import java.util.ArrayList;
import java.util.List;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityWalnut extends EntityPlantBase
{
  public EntityWalnut(World par1World)
  {
    super(par1World, new ItemStack(PvZ_Main.sunlight, 1, 0));
  }

  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    setMaxHealth(PvZ_Main.basePlantHealth * 16);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(this.baseHealth);
  }

  public void onEntityUpdate()
  {
    super.onEntityUpdate();

    int r = 10;
    List rEntities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.posX - r, this.posY, this.posZ - r, this.posX + r, this.posY + 1.0D, this.posZ + r));

    ArrayList otherMob = new ArrayList();
    for (int i = 0; i < rEntities.size(); i++) {
      EntityLivingBase ent = (EntityLivingBase)rEntities.get(i);
      if ((ent.getCreatureAttribute() == PvZ_Main.plantAttribute) || ((ent instanceof EntityPlayer)))
      {
        rEntities.remove(ent);
        otherMob.add(ent);
      } else {
        if ((((EntityCreature)ent).getEntityToAttack() instanceof EntityWalnut))
          continue;
      }
    }
  }
}