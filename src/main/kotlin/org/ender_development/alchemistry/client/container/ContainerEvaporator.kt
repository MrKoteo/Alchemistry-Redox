package org.ender_development.alchemistry.client.container

import net.minecraft.entity.player.InventoryPlayer
import net.minecraftforge.items.SlotItemHandler
import org.ender_development.alchemistry.tiles.TileEvaporator
import org.ender_development.catalyx.client.container.BaseContainer

class ContainerEvaporator(playerInv: InventoryPlayer, tile: TileEvaporator) : BaseContainer(playerInv, tile) {
	init {
		addSlotToContainer(SlotItemHandler(tile.output, 0, 116, 75))
	}
}
