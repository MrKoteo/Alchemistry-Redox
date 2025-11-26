package org.ender_development.alchemistry.proxy

import net.minecraftforge.client.model.obj.OBJLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.ender_development.alchemistry.Reference
import org.ender_development.alchemistry.items.ModItems

@SideOnly(Side.CLIENT)
class ClientProxy : CommonProxy() {

	override fun preInit(e: FMLPreInitializationEvent) {
		super.preInit(e)
		OBJLoader.INSTANCE.addDomain(Reference.MODID)
	}

	override fun postInit(e: FMLPostInitializationEvent) {
		super.postInit(e)
		ModItems.initColors()
		MinecraftForge.EVENT_BUS.register(ClientEventHandler())
	}
}
