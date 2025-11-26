package org.ender_development.alchemistry.client.gui

import net.minecraft.entity.player.InventoryPlayer
import org.ender_development.alchemistry.client.container.ContainerFissionController
import org.ender_development.alchemistry.tiles.TileFissionController

class GuiFissionController(playerInv: InventoryPlayer, tile: TileFissionController) : GuiReactorController<TileFissionController>(ContainerFissionController(playerInv, tile), tile, "fission_controller") {

	override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY)
		drawProgressBar(70, 75, 175, 0, 36, 16)
	}
}
