package org.ender_development.alchemistry.recipes.register

import net.minecraft.init.Blocks
import net.minecraftforge.fluids.FluidRegistry
import org.ender_development.alchemistry.items.ModItems
import org.ender_development.alchemistry.recipes.EvaporatorRecipe
import org.ender_development.catalyx.utils.extensions.toStack

class EvaporatorRegister : AbstractRecipeRegister<EvaporatorRecipe>() {
	companion object {
		val INSTANCE = EvaporatorRegister()
	}

	override fun registerRecipes() {
		recipes.add(EvaporatorRecipe(FluidRegistry.WATER, 125, ModItems.mineralSalt.toStack()))
		recipes.add(EvaporatorRecipe(FluidRegistry.LAVA, 1000, Blocks.MAGMA.toStack()))

		if(fluidExists("milk")) {
			recipes.add(EvaporatorRecipe(FluidRegistry.getFluid("milk"), 500, ModItems.condensedMilk.toStack()))
		}
	}
}
