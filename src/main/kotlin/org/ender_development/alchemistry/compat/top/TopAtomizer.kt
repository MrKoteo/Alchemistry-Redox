package org.ender_development.alchemistry.compat.top

import mcjty.theoneprobe.api.IProbeHitData
import mcjty.theoneprobe.api.IProbeInfo
import mcjty.theoneprobe.api.ProbeMode
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import org.ender_development.alchemistry.items.ItemCompound
import org.ender_development.alchemistry.items.ItemElement
import org.ender_development.alchemistry.tiles.TileAtomizer
import org.ender_development.catalyx.utils.extensions.translate

class TopAtomizer : TopTileHandler<TileAtomizer>("atomizer", TileAtomizer::class.java) {
	override fun addInfo(mode: ProbeMode, info: IProbeInfo, player: EntityPlayer, world: World, state: IBlockState, data: IProbeHitData, te: TileAtomizer) {
		te.currentRecipe?.apply {
			var outputName = output.displayName
			if(output.item is ItemCompound || output.item is ItemElement)
				outputName += " ${"$generic.molecules".translate()}"
			info.item(output).text("$translationKey.atomizing".translate(input.localizedName, outputName))
		}
	}
}
