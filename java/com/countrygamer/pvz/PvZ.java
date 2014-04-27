package com.countrygamer.pvz;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import com.countrygamer.core.Base.common.packet.PacketPipeline;
import com.countrygamer.core.common.Core;
import com.countrygamer.pvz.block.BlockChlorophyllBowl;
import com.countrygamer.pvz.block.BlockDarkenedGrass;
import com.countrygamer.pvz.block.BlockEndowedGrass;
import com.countrygamer.pvz.block.BlockGravestone;
import com.countrygamer.pvz.block.BlockGreenhouse;
import com.countrygamer.pvz.block.plant.BlockPlant;
import com.countrygamer.pvz.block.plant.tile.TileEntityPeaShooter;
import com.countrygamer.pvz.block.plant.tile.TileEntityPlant;
import com.countrygamer.pvz.block.plant.tile.TileEntityRepeater;
import com.countrygamer.pvz.block.plant.tile.TileEntitySnowPea;
import com.countrygamer.pvz.block.plant.tile.TileEntitySunflower;
import com.countrygamer.pvz.block.plant.tile.TileEntityThreePeater;
import com.countrygamer.pvz.block.tile.TileEntityChlorophyllBowl;
import com.countrygamer.pvz.block.tile.TileEntityGravestone;
import com.countrygamer.pvz.block.tile.TileEntityGreenhouse;
import com.countrygamer.pvz.client.gui.ContainerGreenhouse;
import com.countrygamer.pvz.client.gui.GuiGreenhouse;
import com.countrygamer.pvz.client.gui.GuiGuide;
import com.countrygamer.pvz.entities.mobs.plants.EntDec;
import com.countrygamer.pvz.entities.projectiles.EntityCreeperPod;
import com.countrygamer.pvz.entities.projectiles.EntityMoonlight;
import com.countrygamer.pvz.entities.projectiles.EntityPeaPod;
import com.countrygamer.pvz.entities.projectiles.EntityShroomPod;
import com.countrygamer.pvz.entities.projectiles.EntitySnowPod;
import com.countrygamer.pvz.entities.projectiles.EntitySunlight;
import com.countrygamer.pvz.items.ItemBasicPlants;
import com.countrygamer.pvz.items.ItemChlorophyll;
import com.countrygamer.pvz.items.ItemFlag;
import com.countrygamer.pvz.items.ItemFootballBoots;
import com.countrygamer.pvz.items.ItemFootballChest;
import com.countrygamer.pvz.items.ItemFootballHelm;
import com.countrygamer.pvz.items.ItemFootballLegs;
import com.countrygamer.pvz.items.ItemGuideBook;
import com.countrygamer.pvz.items.ItemMoonlight;
import com.countrygamer.pvz.items.ItemNightPlants;
import com.countrygamer.pvz.items.ItemPeaPod;
import com.countrygamer.pvz.items.ItemShroomPod;
import com.countrygamer.pvz.items.ItemSnowPod;
import com.countrygamer.pvz.items.ItemSunlight;
import com.countrygamer.pvz.items.ItemTransTrowel;
import com.countrygamer.pvz.items.ItemTrowel;
import com.countrygamer.pvz.lib.Reference;
import com.countrygamer.pvz.proxy.ServerProxy;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class PvZ implements IFuelHandler, IGuiHandler {
	
	public static final Logger log = Logger.getLogger(Reference.MOD_ID);
	@Mod.Instance(Reference.MOD_ID)
	public static PvZ instance = new PvZ();
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
			serverSide = Reference.SERVER_PROXY_CLASS)
	public static ServerProxy proxy;
	
	// ~Items~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Item peaPod;
	public static Item snowPod;
	public static Item shroomPod;
	public static Item creeperPod;
	public static Item sunlight;
	public static Item chlorophyll;
	public static Item moonlight;
	public static Item trowel;
	public static Item transTrowel;
	public static Item basicPlants;
	public static Item nightPlants;
	public static Item specialPlants;
	public static int[] specialPlantIDs;
	public static Item guideBook;
	public static Item footballHelm;
	public static Item footballChest;
	public static Item footballLegs;
	public static Item footballBoots;
	public static Item flag;
	// ~Blocks~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Block endowedGrass;
	public static String endowedGrass_top_Tex = Reference.BASE_TEX + "endowedGrass_Top";
	public static String endowedGrass_bottom_Tex = Reference.BASE_TEX + "endowedGrass_Bottom";
	public static String endowedGrass_side_Tex = Reference.BASE_TEX + "endowedGrass_Side";
	public static Block darkenedGrass;
	public static String darkenedGrass_top_Tex = Reference.BASE_TEX + "darkenedGrass_Top";
	public static String darkenedGrass_bottom_Tex = Reference.BASE_TEX + "darkenedGrass_Bottom";
	public static String darkenedGrass_side_Tex = Reference.BASE_TEX + "darkenedGrass_Side";
	public static Block chlorophyllBowl;
	public static String chlorophyllBowl_Empty_Tex = "/mods/CountryGamer_PlantsVsZombies/textures/blocks/Bowl Empty.png";
	public static String chlorophyllBowl_Filled_Tex = ":assets:" + Reference.BASE_TEX
			+ "textures:blocks:bowlFilled.png";
	public static Block gravestone;
	public static Block gravestoneReg;
	public static Block gravestoneFootball;
	public static Block gravestoneFlag;
	public static Block gravestoneCone;
	public static Block gravestoneBucket;
	public static Block[] gravestones = {
			gravestone, gravestoneReg, gravestoneFootball, gravestoneFlag, gravestoneCone,
			gravestoneBucket
	};
	public static String[] gravestoneStr = {
			"", "Regular", "Football", "Flag", "Cone", "Bucket"
	};
	public static Block greenhouse;
	
	// Plants
	public static final String[] basicDayNames = {
			"Sunflower", "Pea Shooter", "Snow Pea", "Repeater", "Three-Peater"
	};
	public static Class<? extends TileEntityPlant>[] basicDayTiles = new Class[] {
			TileEntitySunflower.class, TileEntityPeaShooter.class, TileEntitySnowPea.class,
			TileEntityRepeater.class, TileEntityThreePeater.class
	};
	public static BlockPlant[] basicDayPlants = new BlockPlant[PvZ.basicDayNames.length];
	
	// ~Other~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static int sunlightTimer;
	public static boolean holdSunlight;
	public static int basePodDamage;
	public static int basePlantHealth;
	public static int zombieSpawnDelay;
	public static boolean crops;
	public static double creeperPodRad;
	public static EnumCreatureAttribute plantAttribute = EnumHelper.addCreatureAttribute("PLANT");
	public static ItemArmor.ArmorMaterial footballArmor = EnumHelper.addArmorMaterial(
			"FOOTBALL_ARMOR", 12, new int[] {
					1, 4, 3, 1
			}, 0);
	// ~Packet~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final PacketPipeline packetChannel = new PacketPipeline();
	
	public static Block sunflower;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.doPreProxyThings();
		this.setupConfig(event);
		this.doProxyThings();
		this.registerHandlers();
		this.registerItems();
		proxy.registerItemRender();
		this.registerBlocks();
		this.registerCraftingRecipes();
		this.registerSmeltingRecipes();
		this.registerHarvestLevel();
		this.registerEntities();
		this.biomes();
		
	}
	
	public void doPreProxyThings() {
		proxy.registerRender();
	}
	
	public void setupConfig(FMLPreInitializationEvent event) {
		String general = "general";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		sunlightTimer = config.get(general, "Minutes between sunlight production", 5).getInt();
		basePodDamage = config.get(general, "Basic damage of a Pea Pod", 4).getInt();
		basePlantHealth = config.get(general, "Base health of all Plants", 2).getInt();
		zombieSpawnDelay = config.get(general,
				"Minutes in between waves of zombies. (Whole numbers only!)", 10).getInt();
		creeperPodRad = config.get(general, "Creeper Pod Explosion Radius", 1.0D).getDouble(1.0D);
		
		config.save();
	}
	
	public void doProxyThings() {
		proxy.registerThings();
	}
	
	public void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(this);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, this);
		
	}
	
	public void registerItems() {
		this.registerArmor();
		
		PvZ.chlorophyll = new ItemChlorophyll(Reference.MOD_ID, "Chlorophyll");
		Core.addItemToTab(PvZ.chlorophyll);
		
		PvZ.sunlight = new ItemSunlight(Reference.MOD_ID, "Sunlight");
		Core.addItemToTab(PvZ.sunlight);
		
		PvZ.moonlight = new ItemMoonlight(Reference.MOD_ID, "moonlight");
		Core.addItemToTab(PvZ.moonlight);
		
		PvZ.trowel = new ItemTrowel(Reference.MOD_ID, "trowel", 2.0F, Item.ToolMaterial.IRON,
				new Block[] {
						Blocks.dirt, Blocks.grass
				});
		Core.addItemToTab(PvZ.trowel);
		
		PvZ.transTrowel = new ItemTransTrowel(Reference.MOD_ID, "transtrowel", 2.0F,
				Item.ToolMaterial.IRON, new Block[] {
						Blocks.dirt, Blocks.grass
				});
		Core.addItemToTab(PvZ.transTrowel);
		
		PvZ.basicPlants = new ItemBasicPlants(Reference.MOD_ID);
		Core.addItemToTab(PvZ.basicPlants);
		
		PvZ.nightPlants = new ItemNightPlants(Reference.MOD_ID);
		Core.addItemToTab(PvZ.nightPlants);
		
		PvZ.peaPod = new ItemPeaPod(Reference.MOD_ID, "PeaPod");
		Core.addItemToTab(PvZ.peaPod);
		
		PvZ.snowPod = new ItemSnowPod(Reference.MOD_ID, "SnowPod");
		Core.addItemToTab(PvZ.snowPod);
		
		PvZ.shroomPod = new ItemShroomPod(Reference.MOD_ID, "ShroomPod");
		Core.addItemToTab(PvZ.shroomPod);
		
	}
	
	public void registerArmor() {
		int footBallMat = proxy.addArmor("football");
		
		PvZ.footballHelm = new ItemFootballHelm(Reference.MOD_ID, "football_helmet", footballArmor,
				0, footBallMat);
		Core.addItemToTab(PvZ.footballHelm);
		
		PvZ.footballChest = new ItemFootballChest(Reference.MOD_ID, "football_chest",
				footballArmor, 1, footBallMat);
		Core.addItemToTab(PvZ.footballChest);
		
		PvZ.footballLegs = new ItemFootballLegs(Reference.MOD_ID, "football_legs", footballArmor,
				2, footBallMat);
		Core.addItemToTab(PvZ.footballLegs);
		
		PvZ.footballBoots = new ItemFootballBoots(Reference.MOD_ID, "football_boots",
				footballArmor, 3, footBallMat);
		Core.addItemToTab(PvZ.footballBoots);
		
		PvZ.flag = new ItemFlag(Reference.MOD_ID, "flag");
		Core.addItemToTab(PvZ.flag);
		
	}
	
	public void registerBlocks() {
		PvZ.endowedGrass = new BlockEndowedGrass(Material.grass, Reference.MOD_ID, "endowedGrass")
				.setHardness(0.6F).setStepSound(Block.soundTypeGrass);
		Core.addBlockToTab(PvZ.endowedGrass);
		
		PvZ.darkenedGrass = new BlockDarkenedGrass(Material.grass, Reference.MOD_ID,
				"darkenedGrass").setHardness(0.6F).setStepSound(Block.soundTypeGrass);
		Core.addBlockToTab(PvZ.darkenedGrass);
		
		TileEntity.addMapping(TileEntityChlorophyllBowl.class, Reference.MOD_ID
				+ "_ChlorophyllBowl");
		PvZ.chlorophyllBowl = new BlockChlorophyllBowl(Material.wood, Reference.MOD_ID,
				"chlorophyllBowl", TileEntityChlorophyllBowl.class).setHardness(0.2F)
				.setResistance(3.0F);
		Core.addBlockToTab(PvZ.chlorophyllBowl);
		
		TileEntity.addMapping(TileEntityGreenhouse.class, Reference.MOD_ID + "_Greenhouse");
		PvZ.greenhouse = new BlockGreenhouse(Material.rock, Reference.MOD_ID, "greenhouse",
				TileEntityGreenhouse.class).setHardness(0.2F).setResistance(3.0F);
		Core.addBlockToTab(PvZ.greenhouse);
		
		/*
		for (int i = 0; i < PvZ.basicDayNames.length; i++) {
			String name = PvZ.basicDayNames[i];
			Class<? extends TileEntityPlant> tileEntClass = PvZ.basicDayTiles[i];
			
			TileEntity.addMapping(tileEntClass, Reference.MOD_ID + "_" + name);
			PvZ.basicDayPlants[i] = new BlockPlant(Material.plants, Reference.MOD_ID, name,
					tileEntClass);
			Core.addBlockToTab(PvZ.basicDayPlants[i]);
			
		}
		*/
		
	}
	
	public void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(peaPod, 1), new Object[] {
				" x ", "xxx", " x ", Character.valueOf('x'), chlorophyll
		});
		
		GameRegistry.addRecipe(new ItemStack(snowPod, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll, Character.valueOf('c'),
				Items.snowball
		});
		
		GameRegistry.addRecipe(new ItemStack(shroomPod, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll, Character.valueOf('c'),
				moonlight
		});
		
		GameRegistry.addRecipe(new ItemStack(chlorophyllBowl, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll, Character.valueOf('c'),
				Items.bowl
		});
		
		Object[] chloIngred = {
				Blocks.tallgrass, Blocks.leaves, Items.wheat_seeds, Items.carrot, Items.potato,
				Blocks.cactus
		};
		
		int[] chloResult = {
				3, 4, 2, 2, 2, 5
		};
		
		if (chloIngred.length == chloResult.length) {
			for (int i = 0; i < chloIngred.length; i++) {
				GameRegistry.addShapelessRecipe(new ItemStack(chlorophyll, chloResult[i]),
						new Object[] {
							chloIngred[i]
						});
			}
		}
		else {
			GameRegistry.addShapelessRecipe(new ItemStack(sunlight, 1), new Object[] {
				chlorophyll
			});
		}
		
		GameRegistry.addRecipe(
				new ItemStack(trowel, 1),
				new Object[] {
						" x ", "xxx", " c ", Character.valueOf('x'), Items.iron_ingot,
						Character.valueOf('c'), Items.stick
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(transTrowel, 1), new Object[] {
				trowel, sunlight
		});
		
		GameRegistry.addRecipe(
				new ItemStack(greenhouse, 1),
				new Object[] {
						"xxx", "x x", "vcv", Character.valueOf('x'), Blocks.glass_pane,
						Character.valueOf('v'), Blocks.cobblestone, Character.valueOf('c'),
						Blocks.dirt
				});
	}
	
	public void registerSmeltingRecipes() {
	}
	
	public void registerHarvestLevel() {
		PvZ.trowel.setHarvestLevel("shovel", 2);
		PvZ.transTrowel.setHarvestLevel("shovel", 5);
		
		PvZ.chlorophyllBowl.setHarvestLevel("axe", 0);
		PvZ.greenhouse.setHarvestLevel("pickaxe", 0);
		// gravestone.setHarvestLevel("pickaxe", 2);
	}
	
	public void registerEntities() {
		int throwEntityID = 5;
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityPeaPod.class, "Pea Pod", throwEntityID, this, 64, 1,
				true);
		
		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySnowPod.class, "Snow Pod", throwEntityID, this, 64,
				1, true);
		
		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySunlight.class, "Sunlight", throwEntityID, this, 64,
				1, true);
		
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityMoonlight.class, "Moonlight", throwEntityID, this,
				64, 1, true);
		
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityShroomPod.class, "Shroom Pod", throwEntityID, this,
				64, 1, true);
		
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityCreeperPod.class, "Creeper Pod", throwEntityID,
				this, 64, 1, true);
		
		EntDec.mobEnts();
	}
	
	public void biomes() {
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		this.packetChannel.initalise(Reference.MOD_ID);
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		this.packetChannel.postInitialise();
	}
	
	// ~Events~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/*
	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase targetEntity = event.entityLiving;

		if (targetEntity.isPotionActive(PvZ.empower)) {
			if ((targetEntity.worldObj.rand.nextInt(20) != 0)
					|| (targetEntity.getCreatureAttribute() == PvZ.plantAttribute)) {
				((EntityPlantBase) targetEntity)
				.heal(((EntityPlantBase) targetEntity).getMaxHealth());
			} else if (!(targetEntity instanceof EntityZombie)) {
				if ((targetEntity instanceof EntityPlayer)) {
					((EntityPlayer) targetEntity)
					.heal(((EntityPlayer) targetEntity).getMaxHealth());
				}

			}

			if (targetEntity.getActivePotionEffect(PvZ.empower).getDuration() == 0) {
				targetEntity.removePotionEffect(PvZ.empower.id);
				return;
			}
		}
	}
	 */
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~Fuel Handler~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public int getBurnTime(ItemStack fuel) {
		return 0;
	}
	
	// ~Gui Handler~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEnt = world.getTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new ContainerGreenhouse(player.inventory, (TileEntityGreenhouse) tileEnt);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEnt = world.getTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new GuiGreenhouse(player.inventory, (TileEntityGreenhouse) tileEnt);
		}
		if (ID == 3) {
			return new GuiGuide((ItemGuideBook) player.inventory.getCurrentItem().getItem());
		}
		return null;
	}
	
	public void gravestones() {
		GameRegistry.registerTileEntity(TileEntityGravestone.class, "Gravestone");
		
		gravestone = new BlockGravestone(0, Reference.MOD_ID, "gravestone",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestone, "gravestone");
		
		gravestoneReg = new BlockGravestone(1, Reference.MOD_ID, "gravestoneReg",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneReg, "gravestoneReg");
		
		gravestoneFootball = new BlockGravestone(2, Reference.MOD_ID, "gravestoneFootball",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneFootball, "gravestoneFootball");
		
		gravestoneFlag = new BlockGravestone(3, Reference.MOD_ID, "gravestoneFlag",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneFlag, "gravestoneFlag");
		
		gravestoneCone = new BlockGravestone(4, Reference.MOD_ID, "gravestoneCone",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneCone, "gravestoneCone");
		
		gravestoneBucket = new BlockGravestone(5, Reference.MOD_ID, "gravestoneBucket",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneBucket, "gravestoneBucket");
		
		gravestoneCraft();
	}
	
	public void gravestoneCraft() {
		GameRegistry.addRecipe(new ItemStack(gravestoneReg, 1), new Object[] {
				"xxx", "xcx", "xxx", Character.valueOf('c'), gravestone, Character.valueOf('x'),
				Items.rotten_flesh
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFootball, 1), new Object[] {
				gravestone, footballHelm, footballChest, footballLegs, footballBoots
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFlag, 1), new Object[] {
				gravestone, flag
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneCone, 1), new Object[] {
			gravestone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneBucket, 1), new Object[] {
				gravestone, Items.bucket
		});
		
		GameRegistry.addRecipe(new ItemStack(gravestone, 1), new Object[] {
				"xx", "cc", "vv", Character.valueOf('x'), Blocks.stone, Character.valueOf('c'),
				darkenedGrass, Character.valueOf('v'), Items.rotten_flesh
		});
	}
	
}
