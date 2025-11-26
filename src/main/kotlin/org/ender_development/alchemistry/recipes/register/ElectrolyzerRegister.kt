package org.ender_development.alchemistry.recipes.register

import net.minecraftforge.fluids.FluidRegistry
import org.ender_development.alchemistry.recipes.ElectrolyzerRecipe
import org.ender_development.alchemistry.utils.extensions.chemical
import org.ender_development.catalyx.utils.extensions.toIngredient
import org.ender_development.catalyx.utils.extensions.toStack

class ElectrolyzerRegister : AbstractRecipeRegister<ElectrolyzerRecipe>() {
	companion object {
		val INSTANCE = ElectrolyzerRegister()
	}

	override fun registerRecipes() {
		recipes.add(
			ElectrolyzerRecipe(
				FluidRegistry.WATER.toStack(125),
				"calcium_carbonate".chemical().toIngredient(),
				20,
				"hydrogen".chemical(4),
				"oxygen".chemical(2)
			)
		)

		recipes.add(
			ElectrolyzerRecipe(
				FluidRegistry.WATER.toStack(125),
				"sodium_chloride".chemical().toIngredient(),
				20,
				"hydrogen".chemical(2),
				"oxygen".chemical(1),
				"chlorine".chemical(2),
				10
			)
		)
	}
}
