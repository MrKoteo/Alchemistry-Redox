package org.ender_development.alchemistry.client.gui

import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import org.ender_development.alchemistry.Reference
import org.ender_development.alchemistry.client.container.ContainerAtomizer
import org.ender_development.alchemistry.tiles.TileAtomizer
import org.ender_development.catalyx.client.gui.BaseGui
import org.ender_development.catalyx.client.gui.wrappers.CapabilityEnergyDisplayWrapper
import org.ender_development.catalyx.client.gui.wrappers.CapabilityFluidDisplayWrapper

class GuiAtomizer(playerInv: InventoryPlayer, tile: TileAtomizer) : BaseGui(ContainerAtomizer(playerInv, tile), tile) {
	override val textureLocation = ResourceLocation(Reference.MODID, "textures/gui/container/atomizer_gui_redox.png")

	init {
		this.displayData.add(CapabilityEnergyDisplayWrapper(8, 21, 16, 70, tile::energyStorage))
		this.displayData.add(CapabilityFluidDisplayWrapper(44, 21, 16, 70, tile::inputTank))
	}

	override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY)
		drawProgressBar(70, 75, 175, 0, 36, 16)
	}
}
