package org.ender_development.alchemistry.compat.jei.combiner

import mezz.jei.api.gui.IRecipeLayout
import mezz.jei.api.recipe.transfer.IRecipeTransferError
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import org.ender_development.alchemistry.client.container.ContainerChemicalCombiner
import org.ender_development.alchemistry.network.ChemicalCombinerTransferPacket
import org.ender_development.alchemistry.network.PacketHandler

class CombinerTransferHandler : IRecipeTransferHandler<ContainerChemicalCombiner> {
	override fun getContainerClass() = ContainerChemicalCombiner::class.java

	override fun transferRecipe(container: ContainerChemicalCombiner, recipeLayout: IRecipeLayout, player: EntityPlayer, maxTransfer: Boolean, doTransfer: Boolean): IRecipeTransferError? {
		val output: ItemStack? = recipeLayout.itemStacks.guiIngredients.entries.last().value.displayedIngredient
		if(output != null && doTransfer) {
			PacketHandler.INSTANCE!!.sendToServer(ChemicalCombinerTransferPacket(container.tile.pos, output))
		}
		return null
	}
}
