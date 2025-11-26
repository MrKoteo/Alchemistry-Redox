package org.ender_development.alchemistry.client.gui

import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import org.ender_development.alchemistry.Reference
import org.ender_development.alchemistry.client.container.ContainerChemicalDissolver
import org.ender_development.alchemistry.tiles.TileChemicalDissolver
import org.ender_development.catalyx.client.gui.BaseGui
import org.ender_development.catalyx.client.gui.wrappers.CapabilityEnergyDisplayWrapper

class GuiChemicalDissolver(playerInv: InventoryPlayer, tile: TileChemicalDissolver) : BaseGui(ContainerChemicalDissolver(playerInv, tile), tile) {
	override val textureLocation = ResourceLocation(Reference.MODID, "textures/gui/container/chemical_dissolver_gui_redox.png")

	init {
		this.displayData.add(CapabilityEnergyDisplayWrapper(8, 21, 16, 70, tile::energyStorage))
	}

	override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY)
		drawProgressBar(63, 43, 175, 0, 32, 44)
	}
}
