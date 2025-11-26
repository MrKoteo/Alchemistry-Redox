package org.ender_development.alchemistry.recipes.register

import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.recipes.FusionRecipe

class FusionRegister : AbstractRecipeRegister<FusionRecipe>() {
	companion object {
		val INSTANCE = FusionRegister()
	}

	override fun registerRecipes() {
		ElementRegistry.getAllElements().forEach { element1 ->
			ElementRegistry.getAllElements().forEach { element2 ->
				if(element2.meta >= element1.meta && ElementRegistry[element1.meta + element2.meta] != null)
					recipes.add(FusionRecipe(element1.meta, element2.meta))
			}
		}
	}
}
