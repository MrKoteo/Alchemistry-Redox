package org.ender_development.alchemistry.compat.jei.atomizer

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.ingredients.VanillaTypes
import org.ender_development.alchemistry.compat.jei.AlchemistryRecipeWrapper
import org.ender_development.alchemistry.recipes.AtomizerRecipe

class AtomizerRecipeWrapper(recipe: AtomizerRecipe) : AlchemistryRecipeWrapper<AtomizerRecipe>(recipe) {

	override fun getIngredients(ingredients: IIngredients) {
		ingredients.setInput(VanillaTypes.FLUID, recipe.input)
		ingredients.setOutput(VanillaTypes.ITEM, recipe.output)
	}
}
