package org.ender_development.alchemistry.recipes.register

import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.recipes.FissionRecipe

class FissionRegister : AbstractRecipeRegister<FissionRecipe>() {
	companion object {
		val INSTANCE = FissionRegister()
	}

	override fun registerRecipes() {
		ElementRegistry.getAllElements().forEach {
			if(it.meta == 1)
				return@forEach

			val even = it.meta and 1 == 0 // x & 1 == x % 2
			val half = it.meta ushr 1 // x >> 1 == floor(x / 2)
			val out1 = if(even) half else half + 1
			val out2 = if(even) 0 else half
			if(ElementRegistry[out1] != null && (even || ElementRegistry[out2] != null))
				recipes.add(FissionRecipe(it.meta, out1, out2))
		}
	}
}
