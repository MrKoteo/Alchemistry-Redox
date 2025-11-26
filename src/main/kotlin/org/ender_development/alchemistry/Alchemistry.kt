package org.ender_development.alchemistry

import crafttweaker.CraftTweakerAPI
import crafttweaker.IAction
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.*
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.Logger
import org.ender_development.alchemistry.blocks.ModBlocks
import org.ender_development.alchemistry.command.DissolverCommand
import org.ender_development.alchemistry.crafting.DankFoodHandler
import org.ender_development.alchemistry.crafting.MachineResettingHandler
import org.ender_development.alchemistry.crafting.SaltyFoodHandler
import org.ender_development.alchemistry.proxy.CommonProxy
import org.ender_development.catalyx.core.ICatalyxMod
import org.ender_development.catalyx.utils.extensions.toStack
import java.text.DecimalFormat
import java.util.*

@Mod(
	modid = Reference.MODID,
	name = Reference.MOD_NAME,
	version = Reference.VERSION,
	dependencies = "required-after:configanytime;required-after:forgelin_continuous@[${Reference.KOTLIN_VERSION},);required-after:catalyx;after:crafttweaker;after:groovyscript@[${Reference.GROOVYSCRIPT_VERSION},);before:jei;",
	modLanguageAdapter = ICatalyxMod.MOD_LANGUAGE_ADAPTER
)
object Alchemistry : ICatalyxMod {
	val DECIMAL_FORMAT = DecimalFormat("#0.00")

	override val creativeTab =
		object : CreativeTabs(Reference.MODID) {
			override fun createIcon() = ModBlocks.chemical_combiner.toStack()
		}

	// https://github.com/jaredlll08/ModTweaker/blob/1.12/src/main/java/com/blamejared/ModTweaker.java
	val LATE_REMOVALS: LinkedList<IAction> = LinkedList()
	val LATE_ADDITIONS: LinkedList<IAction> = LinkedList()

	lateinit var logger: Logger

	@SidedProxy(clientSide = "org.ender_development.alchemistry.proxy.ClientProxy", serverSide = "org.ender_development.alchemistry.proxy.CommonProxy")
	var proxy: CommonProxy? = null

	@EventHandler
	fun preInit(e: FMLPreInitializationEvent) = proxy!!.preInit(e)

	@EventHandler
	fun init(e: FMLInitializationEvent) = proxy!!.init(e)

	@EventHandler
	fun postInit(e: FMLPostInitializationEvent) = proxy!!.postInit(e)

	@EventHandler
	fun serverStarting(e: FMLServerStartingEvent) = e.registerServerCommand(DissolverCommand())

	@EventHandler
	fun loadComplete(e: FMLLoadCompleteEvent) {
		try {
			LATE_REMOVALS.forEach(CraftTweakerAPI::apply)
			LATE_ADDITIONS.forEach(CraftTweakerAPI::apply)
		} catch (e: Exception) {
			e.printStackTrace()
			CraftTweakerAPI.logError("Error while applying actions", e)
		}
		LATE_REMOVALS.clear()
		LATE_ADDITIONS.clear()
	}

	@Mod.EventBusSubscriber(modid = Reference.MODID)
	object Registration {
		@JvmStatic
		@SubscribeEvent
		fun registerCraftingHandler(event: RegistryEvent.Register<IRecipe>) {
			event.registry.register(DankFoodHandler())
			event.registry.register(SaltyFoodHandler())
			event.registry.register(MachineResettingHandler())
		}
	}
}
