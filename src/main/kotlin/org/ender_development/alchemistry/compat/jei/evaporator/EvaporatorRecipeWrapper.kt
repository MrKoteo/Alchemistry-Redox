package org.ender_development.alchemistry.compat.jei.evaporator

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.ingredients.VanillaTypes
import org.ender_development.alchemistry.compat.jei.AlchemistryRecipeWrapper
import org.ender_development.alchemistry.recipes.EvaporatorRecipe

class EvaporatorRecipeWrapper(recipe: EvaporatorRecipe) : AlchemistryRecipeWrapper<EvaporatorRecipe>(recipe) {

	override fun getIngredients(ingredients: IIngredients) {
		ingredients.setInput(VanillaTypes.FLUID, recipe.input)
		ingredients.setOutputs(VanillaTypes.ITEM, listOf(recipe.output))
	}
}
