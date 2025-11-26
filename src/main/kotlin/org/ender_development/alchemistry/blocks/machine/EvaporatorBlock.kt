package org.ender_development.alchemistry.blocks.machine

import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraftforge.fml.client.registry.ClientRegistry
import org.ender_development.alchemistry.client.TESREvaporator
import org.ender_development.alchemistry.tiles.TileEvaporator
import org.ender_development.catalyx.items.TooltipItemBlock
import org.ender_development.catalyx.utils.extensions.translate

class EvaporatorBlock(name: String, tileClass: Class<out TileEntity>, guiID: Int) : BaseMachineBlock(name, tileClass, guiID,
	AxisAlignedBB(.0625, .0625, .0625, .9375, .75, .9375), AxisAlignedBB(.25, .0, .25, .75, .0625, .75)) {
	init {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEvaporator::class.java, TESREvaporator())
	}

	override val item = TooltipItemBlock(this, "tile.alchemistry:evaporator.tooltip".translate())
}
