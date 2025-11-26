package org.ender_development.alchemistry.proxy

import crafttweaker.CraftTweakerAPI
import net.minecraft.nbt.NBTBase
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import org.ender_development.alchemistry.Alchemistry
import org.ender_development.alchemistry.Reference
import org.ender_development.alchemistry.blocks.ModBlocks
import org.ender_development.alchemistry.capability.AlchemistryDrugInfo
import org.ender_development.alchemistry.chemistry.CompoundRegistry
import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.client.gui.GuiHandler
import org.ender_development.alchemistry.compat.top.TopHandler
import org.ender_development.alchemistry.items.ModItems
import org.ender_development.alchemistry.network.PacketHandler
import org.ender_development.alchemistry.recipes.ModRecipes

open class CommonProxy {

	companion object {
		private var stage: LoadingStage = LoadingStage.PRE_INIT

		fun getStage(): LoadingStage {
			return stage
		}
	}

	open fun preInit(e: FMLPreInitializationEvent) {
		stage = LoadingStage.PRE_INIT
		Alchemistry.logger = e.modLog

		ModBlocks.nya()
		ModItems.nya()

		registerCapabilities()
		if(ElementRegistry.getAllElements().isEmpty()) {
			Alchemistry.logger.info("ElementRegistry isn't initialized yet, initializing")
			ElementRegistry.init()
		}
		if(CompoundRegistry.compounds().isEmpty()) {
			Alchemistry.logger.info("CompoundRegistry isn't initialized yet, initializing")
			CompoundRegistry.init()
		}
		PacketHandler.registerMessages(Reference.MODID)

		if(Loader.isModLoaded("crafttweaker")) CraftTweakerAPI.tweaker.loadScript(false, Reference.MODID)
	}

	open fun init(e: FMLInitializationEvent) {
		stage = LoadingStage.INIT
		ModRecipes.initOredict()
		NetworkRegistry.INSTANCE.registerGuiHandler(Alchemistry, GuiHandler())
		MinecraftForge.EVENT_BUS.register(CommonEventHandler())

		if(Loader.isModLoaded("theoneprobe")) {
			TopHandler.register()
		}
	}

	open fun postInit(e: FMLPostInitializationEvent) {
		stage = LoadingStage.POST_INIT
		ModRecipes.init()
	}

	private fun registerCapabilities() {
		CapabilityManager.INSTANCE.register(
			AlchemistryDrugInfo::class.java, object : Capability.IStorage<AlchemistryDrugInfo> {

				override fun writeNBT(capability: Capability<AlchemistryDrugInfo>, instance: AlchemistryDrugInfo, side: EnumFacing): NBTBase? {
					throw UnsupportedOperationException()
				}

				override fun readNBT(capability: Capability<AlchemistryDrugInfo>, instance: AlchemistryDrugInfo, side: EnumFacing, nbt: NBTBase) {
					throw UnsupportedOperationException()
				}
			}) { throw UnsupportedOperationException() }
	}

	enum class LoadingStage {
		PRE_INIT, INIT, POST_INIT
	}
}
