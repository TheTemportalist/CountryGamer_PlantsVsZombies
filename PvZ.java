package com.countrygamer.pvz;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import com.countrygamer.countrygamer_core.Core;
import com.countrygamer.pvz.blocks.BlockChlorophyllBowl;
import com.countrygamer.pvz.blocks.BlockDarkenedGrass;
import com.countrygamer.pvz.blocks.BlockEndowedGrass;
import com.countrygamer.pvz.blocks.BlockGravestone;
import com.countrygamer.pvz.blocks.BlockGreenhouse;
import com.countrygamer.pvz.blocks.tiles.TileEntityChlorophyllBowl;
import com.countrygamer.pvz.blocks.tiles.TileEntityGravestone;
import com.countrygamer.pvz.blocks.tiles.TileEntityGreenhouse;
import com.countrygamer.pvz.client.gui.PvZGuiHandler;
import com.countrygamer.pvz.entities.mobs.plants.EntDec;
import com.countrygamer.pvz.entities.projectiles.EntityCreeperPod;
import com.countrygamer.pvz.entities.projectiles.EntityMoonlight;
import com.countrygamer.pvz.entities.projectiles.EntityPeaPod;
import com.countrygamer.pvz.entities.projectiles.EntityShroomPod;
import com.countrygamer.pvz.entities.projectiles.EntitySnowPod;
import com.countrygamer.pvz.entities.projectiles.EntitySunlight;
import com.countrygamer.pvz.handlers.EventHandler;
import com.countrygamer.pvz.items.ItemBasicPlants;
import com.countrygamer.pvz.items.ItemChlorophyll;
import com.countrygamer.pvz.items.ItemFlag;
import com.countrygamer.pvz.items.ItemFootballBoots;
import com.countrygamer.pvz.items.ItemFootballChest;
import com.countrygamer.pvz.items.ItemFootballHelm;
import com.countrygamer.pvz.items.ItemFootballLegs;
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
import com.google.common.collect.Sets;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class PvZ {

	public static final Logger log = Logger.getLogger(Reference.MOD_ID);
	@Mod.Instance(Reference.MOD_ID)
	public static PvZ instance = new PvZ();
	private PvZGuiHandler guiHandler = new PvZGuiHandler();

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static ServerProxy proxy;
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
	public static Block endowedGrass;
	public static String endowedGrass_top_Tex = Reference.BASE_TEX
			+ "endowedGrass_Top";
	public static String endowedGrass_bottom_Tex = Reference.BASE_TEX
			+ "endowedGrass_Bottom";
	public static String endowedGrass_side_Tex = Reference.BASE_TEX
			+ "endowedGrass_Side";
	public static Block darkenedGrass;
	public static String darkenedGrass_top_Tex = Reference.BASE_TEX
			+ "darkenedGrass_Top";
	public static String darkenedGrass_bottom_Tex = Reference.BASE_TEX
			+ "darkenedGrass_Bottom";
	public static String darkenedGrass_side_Tex = Reference.BASE_TEX
			+ "darkenedGrass_Side";
	public static Block chlorophyllBowl;
	public static String chlorophyllBowl_Empty_Tex = "/mods/CountryGamer_PlantsVsZombies/textures/blocks/Bowl Empty.png";
	public static String chlorophyllBowl_Filled_Tex = ":assets:"
			+ Reference.BASE_TEX + "textures:blocks:bowlFilled.png";
	public static Block gravestone;
	public static Block gravestoneReg;
	public static Block gravestoneFootball;
	public static Block gravestoneFlag;
	public static Block gravestoneCone;
	public static Block gravestoneBucket;
	public static Block[] gravestones = { gravestone, gravestoneReg,
			gravestoneFootball, gravestoneFlag, gravestoneCone,
			gravestoneBucket };
	public static String[] gravestoneStr = { "", "Regular", "Football", "Flag",
			"Cone", "Bucket" };
	public static Block greenhouse;
	public static Item footballHelm;
	public static Item footballChest;
	public static Item footballLegs;
	public static Item footballBoots;
	public static Item flag;
	public static Potion empower;
	public static int sunlightTimer;
	public static boolean holdSunlight;
	public static int basePodDamage;
	public static int basePlantHealth;
	public static int zombieSpawnDelay;
	public static boolean crops;
	public static double creeperPodRad;
	public static EnumCreatureAttribute plantAttribute = EnumHelper
			.addCreatureAttribute("PLANT");
	public static ItemArmor.ArmorMaterial footballArmor = EnumHelper
			.addArmorMaterial("FOOTBALL_ARMOR", 12, new int[] { 1, 4, 3, 1 }, 0);

	// public static CreativeTabs pvzTab;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		String general = "general";

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();

		sunlightTimer = config.get(general,
				"Minutes between sunlight production", 5).getInt();
		basePodDamage = config.get(general, "Basic damage of a Pea Pod", 4)
				.getInt();
		basePlantHealth = config.get(general, "Base health of all Plants", 2)
				.getInt();
		zombieSpawnDelay = config.get(general,
				"Minutes in between waves of zombies. (Whole numbers only!)",
				10).getInt();
		creeperPodRad = config.get(general, "Creeper Pod Explosion Radius",
				1.0D).getDouble(1.0D);

		config.save();

		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if ((f.getName().equals("potionTypes"))
						|| (f.getName().equals("field_76425_a"))) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & 0xFFFFFFEF);

					potionTypes = (Potion[]) (Potion[]) f.get(null);
					Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0,
							potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err
						.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}

		}

		MinecraftForge.EVENT_BUS.register(new EventHandler());
		/*
		 * pvzTab = new CreativeTabs("pvzTab") {
		 * 
		 * @Override
		 * 
		 * @SideOnly(Side.CLIENT) public Item getTabIconItem() { return
		 * PvZ.sunlight; } };
		 */
		items();
		armor();
		blocks();
		proxy.registerBlocks();
		harvestLevel();
		entities();
		crafting();

		proxy.registerRenderThings();
		proxy.registerTickHandler();

		empower = new PotionEmpower(32, false, 0)
				.setPotionName("potion.empower");

		NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent postEvent) {
	}

	public void items() {
		chlorophyll = new ItemChlorophyll(Reference.MOD_ID, "Chlorophyll");
		Core.addItemToTab(PvZ.chlorophyll);

		sunlight = new ItemSunlight(Reference.MOD_ID, "Sunlight");
		Core.addItemToTab(PvZ.sunlight);

		moonlight = new ItemMoonlight(Reference.MOD_ID, "moonlight");
		Core.addItemToTab(PvZ.moonlight);

		trowel = new ItemTrowel(Reference.MOD_ID, "trowel", 2.0F,
				Item.ToolMaterial.IRON,
				new Block[] { Blocks.dirt, Blocks.grass });
		Core.addItemToTab(PvZ.trowel);

		transTrowel = new ItemTransTrowel(Reference.MOD_ID, "transtrowel",
				2.0F, Item.ToolMaterial.IRON, new Block[] { Blocks.dirt,
						Blocks.grass });
		Core.addItemToTab(PvZ.transTrowel);

		basicPlants = new ItemBasicPlants(Reference.MOD_ID);
		Core.addItemToTab(PvZ.basicPlants);

		nightPlants = new ItemNightPlants(Reference.MOD_ID);
		Core.addItemToTab(PvZ.nightPlants);

		peaPod = new ItemPeaPod(Reference.MOD_ID, "PeaPod");
		Core.addItemToTab(PvZ.peaPod);

		snowPod = new ItemSnowPod(Reference.MOD_ID, "SnowPod");
		Core.addItemToTab(PvZ.snowPod);

		shroomPod = new ItemShroomPod(Reference.MOD_ID, "ShroomPod");
		Core.addItemToTab(PvZ.shroomPod);

	}

	public void armor() {
		int footBallMat = proxy.addArmor("football");

		footballHelm = new ItemFootballHelm(Reference.MOD_ID,
				"football_helmet", footballArmor, 0, footBallMat);
		Core.addItemToTab(PvZ.footballHelm);

		footballChest = new ItemFootballChest(Reference.MOD_ID,
				"football_chest", footballArmor, 1, footBallMat);
		Core.addItemToTab(PvZ.footballChest);

		footballLegs = new ItemFootballLegs(Reference.MOD_ID, "football_legs",
				footballArmor, 2, footBallMat);
		Core.addItemToTab(PvZ.footballLegs);

		footballBoots = new ItemFootballBoots(Reference.MOD_ID,
				"football_boots", footballArmor, 3, footBallMat);
		Core.addItemToTab(PvZ.footballBoots);

		flag = new ItemFlag(Reference.MOD_ID, "flag");
		Core.addItemToTab(PvZ.flag);

	}

	public void blocks() {
		endowedGrass = new BlockEndowedGrass(Material.grass, Reference.MOD_ID,
				"endowedGrass").setHardness(0.6F).setStepSound(
				Block.soundTypeGrass);
		Core.addBlockToTab(PvZ.endowedGrass);

		darkenedGrass = new BlockDarkenedGrass(Material.grass,
				Reference.MOD_ID, "darkenedGrass").setHardness(0.6F)
				.setStepSound(Block.soundTypeGrass);
		Core.addBlockToTab(PvZ.darkenedGrass);

		GameRegistry.registerTileEntity(TileEntityChlorophyllBowl.class,
				"Chlorophyll Bowl");
		chlorophyllBowl = new BlockChlorophyllBowl(Material.wood,
				Reference.MOD_ID, "chlorophyllBowl",
				TileEntityChlorophyllBowl.class).setHardness(0.2F)
				.setResistance(3.0F);
		Core.addBlockToTab(PvZ.chlorophyllBowl);

		GameRegistry.registerTileEntity(TileEntityGreenhouse.class,
				"Greenhouse");
		greenhouse = new BlockGreenhouse(Material.rock, Reference.MOD_ID,
				"greenhouse", TileEntityGreenhouse.class).setHardness(0.2F)
				.setResistance(3.0F);
		Core.addBlockToTab(PvZ.greenhouse);

	}

	public void gravestones() {
		GameRegistry.registerTileEntity(TileEntityGravestone.class,
				"Gravestone");

		gravestone = new BlockGravestone(0, Reference.MOD_ID, "gravestone",
				TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestone, "gravestone");

		gravestoneReg = new BlockGravestone(1, Reference.MOD_ID,
				"gravestoneReg", TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneReg, "gravestoneReg");

		gravestoneFootball = new BlockGravestone(2, Reference.MOD_ID,
				"gravestoneFootball", TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneFootball, "gravestoneFootball");

		gravestoneFlag = new BlockGravestone(3, Reference.MOD_ID,
				"gravestoneFlag", TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneFlag, "gravestoneFlag");

		gravestoneCone = new BlockGravestone(4, Reference.MOD_ID,
				"gravestoneCone", TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneCone, "gravestoneCone");

		gravestoneBucket = new BlockGravestone(5, Reference.MOD_ID,
				"gravestoneBucket", TileEntityGravestone.class);
		GameRegistry.registerBlock(gravestoneBucket, "gravestoneBucket");

		gravestoneCraft();
	}

	public void gravestoneCraft() {
		GameRegistry.addRecipe(new ItemStack(gravestoneReg, 1), new Object[] {
				"xxx", "xcx", "xxx", Character.valueOf('c'), gravestone,
				Character.valueOf('x'), Items.rotten_flesh });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFootball, 1),
				new Object[] { gravestone, footballHelm, footballChest,
						footballLegs, footballBoots });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFlag, 1),
				new Object[] { gravestone, flag });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneCone, 1),
				new Object[] { gravestone });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneBucket, 1),
				new Object[] { gravestone, Items.bucket });

		GameRegistry.addRecipe(new ItemStack(gravestone, 1), new Object[] {
				"xx", "cc", "vv", Character.valueOf('x'), Blocks.stone,
				Character.valueOf('c'), darkenedGrass, Character.valueOf('v'),
				Items.rotten_flesh });
	}

	public void harvestLevel() {
		trowel.setHarvestLevel("shovel", 2);
		transTrowel.setHarvestLevel("shovel", 5);

		chlorophyllBowl.setHarvestLevel("axe", 0);
		greenhouse.setHarvestLevel("pickaxe", 0);
		// gravestone.setHarvestLevel("pickaxe", 2);
	}

	public void entities() {
		int throwEntityID = 5;
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityPeaPod.class, "Pea Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySnowPod.class, "Snow Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySunlight.class, "Sunlight",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityMoonlight.class, "Moonlight",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityShroomPod.class, "Shroom Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityCreeperPod.class, "Creeper Pod",
				throwEntityID, this, 64, 1, true);

		EntDec.mobEnts();
	}

	public void crafting() {
		GameRegistry.addRecipe(new ItemStack(peaPod, 1), new Object[] { " x ",
				"xxx", " x ", Character.valueOf('x'), chlorophyll });

		GameRegistry.addRecipe(new ItemStack(snowPod, 1),
				new Object[] { " x ", "xcx", " x ", Character.valueOf('x'),
						chlorophyll, Character.valueOf('c'), Items.snowball });

		GameRegistry.addRecipe(new ItemStack(shroomPod, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll,
				Character.valueOf('c'), moonlight });

		GameRegistry.addRecipe(new ItemStack(chlorophyllBowl, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll,
				Character.valueOf('c'), Items.bowl });

		Object[] chloIngred = { Blocks.tallgrass, Blocks.leaves,
				Items.wheat_seeds, Items.carrot, Items.potato, Blocks.cactus };

		int[] chloResult = { 3, 4, 2, 2, 2, 5 };

		if (chloIngred.length == chloResult.length) {
			for (int i = 0; i < chloIngred.length; i++) {
				GameRegistry.addShapelessRecipe(new ItemStack(chlorophyll,
						chloResult[i]), new Object[] { chloIngred[i] });
			}
		} else {
			GameRegistry.addShapelessRecipe(new ItemStack(sunlight, 1),
					new Object[] { chlorophyll });
		}

		GameRegistry.addRecipe(new ItemStack(trowel, 1), new Object[] { " x ",
				"xxx", " c ", Character.valueOf('x'), Items.iron_ingot,
				Character.valueOf('c'), Items.stick });

		GameRegistry.addShapelessRecipe(new ItemStack(transTrowel, 1),
				new Object[] { trowel, sunlight });

		GameRegistry
				.addRecipe(
						new ItemStack(greenhouse, 1),
						new Object[] { "xxx", "x x", "vcv",
								Character.valueOf('x'), Blocks.glass_pane,
								Character.valueOf('v'), Blocks.cobblestone,
								Character.valueOf('c'), Blocks.dirt });
	}

}