package org.ender_development.alchemistry.blocks.machine

import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.AxisAlignedBB
import org.ender_development.alchemistry.ConfigHandler
import org.ender_development.catalyx.items.TooltipItemBlock
import org.ender_development.catalyx.utils.extensions.translate

class AtomizerBlock(name: String, tileClass: Class<out TileEntity>, guiID: Int) : BaseMachineBlock(name, tileClass, guiID, AxisAlignedBB(.0, .0, .0, 1.0, 1.0, 1.0)) {
	override val item = TooltipItemBlock(this, "tooltip.alchemistry.energy_requirement".translate(ConfigHandler.ATOMIZER.energyPerTick))
}
