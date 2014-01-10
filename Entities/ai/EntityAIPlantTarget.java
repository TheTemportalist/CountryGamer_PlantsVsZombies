package CountryGamer_PlantsVsZombies.Entities.ai;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

import org.apache.commons.lang3.StringUtils;

import CountryGamer_PlantsVsZombies.Entities.Mobs.Plants.EntityPlantShooterBase;

public class EntityAIPlantTarget extends EntityAITarget {

	private final Class targetClass;
	private EntityLivingBase targetEntity;
	private final EntityAIPlantTargetSorter theAttackableTargetSorter;
	private final IEntitySelector targetEntitySelector;

	private boolean nearbyOnly;
	private int targetSearchStatus;
	private int targetSearchDelay;

	public final float range;

	public EntityAIPlantTarget(EntityCreature ownerEntity,
			boolean shouldCheckSight, boolean nearbyOnly, Class target,
			IEntitySelector entityToTarget, float range) {
		super(ownerEntity, shouldCheckSight, nearbyOnly);
		this.targetClass = target;
		this.theAttackableTargetSorter = new EntityAIPlantTargetSorter(this,
				ownerEntity, EntityPlantShooterBase.class);
		this.setMutexBits(1);
		this.targetEntitySelector = new EntityAIPlantTargetSelector(this,
				entityToTarget);
		this.range = range;
	}

	@Override
	public boolean shouldExecute() {
		double d0 = this.range * 2;// this.getTargetDistance();
		List listFoes = this.taskOwner.worldObj.selectEntitiesWithinAABB(
				this.targetClass,
				this.taskOwner.boundingBox.expand(d0, 4.0D, d0),
				PlantFilterIMob.selector);
		List listFriends = this.taskOwner.worldObj.selectEntitiesWithinAABB(
				EntityPlantShooterBase.class,
				this.taskOwner.boundingBox.expand(d0, 4.0D, d0),
				new IEntitySelector() {
					@Override
					public boolean isEntityApplicable(Entity entity) {
						return entity instanceof EntityPlantShooterBase;
					}
				});
		
		if (listFoes.isEmpty()) {
			return false;
		}else {
			ArrayList<EntityLivingBase> friendTargets = new ArrayList();
			for (Object friend : listFriends) {
				if (friend != null && friend instanceof EntityCreature) {
					EntityLivingBase friendTarget = ((EntityCreature) friend)
							.getAttackTarget();
					if (friendTarget != null) {
						friendTargets.add(friendTarget);
					}
				}
			}
			
			EntityLivingBase priority1 = null;
			double distanceToP1 = 0.0D;
			priority1 = (EntityLivingBase) listFoes.get(0);

			this.targetEntity = priority1;
			return true;
		}

	}

	@Override
	public void startExecuting() {
		this.taskOwner.setAttackTarget(this.targetEntity);
		super.startExecuting();
	}

	@Override
	protected boolean isSuitableTarget(EntityLivingBase par1EntityLivingBase,
			boolean par2) {
		if (par1EntityLivingBase == null) {
			return false;
		} else if (par1EntityLivingBase == this.taskOwner) {
			return false;
		} else if (!par1EntityLivingBase.isEntityAlive()) {
			return false;
		} else if (!this.taskOwner.canAttackClass(par1EntityLivingBase
				.getClass())) {
			return false;
		} else {
			if (this.taskOwner instanceof EntityOwnable
					&& StringUtils.isNotEmpty(((EntityOwnable) this.taskOwner)
							.getOwnerName())) {
				if (par1EntityLivingBase instanceof EntityOwnable
						&& ((EntityOwnable) this.taskOwner).getOwnerName()
								.equals(((EntityOwnable) par1EntityLivingBase)
										.getOwnerName())) {
					return false;
				}

				if (par1EntityLivingBase == ((EntityOwnable) this.taskOwner)
						.getOwner()) {
					return false;
				}
			} else if (par1EntityLivingBase instanceof EntityPlayer
					&& !par2
					&& ((EntityPlayer) par1EntityLivingBase).capabilities.disableDamage) {
				return false;
			}

			if (!this.taskOwner.func_110176_b(
					MathHelper.floor_double(par1EntityLivingBase.posX),
					MathHelper.floor_double(par1EntityLivingBase.posY),
					MathHelper.floor_double(par1EntityLivingBase.posZ))) {
				return false;
			} else if (this.shouldCheckSight
					&& !this.taskOwner.getEntitySenses().canSee(
							par1EntityLivingBase)) {
				return false;
			} else {
				if (this.nearbyOnly) {
					if (--this.targetSearchDelay <= 0) {
						this.targetSearchStatus = 0;
					}

					if (this.targetSearchStatus == 0) {
						this.targetSearchStatus = this
								.canEasilyReach(par1EntityLivingBase) ? 1 : 2;
					}

					if (this.targetSearchStatus == 2) {
						return false;
					}
				}

				return true;
			}
		}
	}

	private boolean canEasilyReach(EntityLivingBase par1EntityLivingBase) {
		this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
		PathEntity pathentity = this.taskOwner.getNavigator()
				.getPathToEntityLiving(par1EntityLivingBase);

		if (pathentity == null) {
			return false;
		} else {
			PathPoint pathpoint = pathentity.getFinalPathPoint();

			if (pathpoint == null) {
				return false;
			} else {
				int i = pathpoint.xCoord
						- MathHelper.floor_double(par1EntityLivingBase.posX);
				int j = pathpoint.zCoord
						- MathHelper.floor_double(par1EntityLivingBase.posZ);
				return (double) (i * i + j * j) <= 2.25D;
			}
		}
	}

}
