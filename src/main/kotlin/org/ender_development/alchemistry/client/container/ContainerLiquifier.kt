package org.ender_development.alchemistry.client.container

import net.minecraft.entity.player.InventoryPlayer
import net.minecraftforge.items.SlotItemHandler
import org.ender_development.alchemistry.tiles.TileLiquifier
import org.ender_development.catalyx.client.container.BaseContainer

class ContainerLiquifier(playerInv: InventoryPlayer, tile: TileLiquifier) : BaseContainer(playerInv, tile) {
	init {
		addSlotToContainer(SlotItemHandler(tile.input, 0, 44, 75))
	}
}
