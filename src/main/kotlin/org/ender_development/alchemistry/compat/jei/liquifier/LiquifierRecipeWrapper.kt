package org.ender_development.alchemistry.compat.jei.liquifier

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.ingredients.VanillaTypes
import org.ender_development.alchemistry.compat.jei.AlchemistryRecipeWrapper
import org.ender_development.alchemistry.recipes.LiquifierRecipe

class LiquifierRecipeWrapper(recipe: LiquifierRecipe) : AlchemistryRecipeWrapper<LiquifierRecipe>(recipe) {

	override fun getIngredients(ingredients: IIngredients) {
		ingredients.setInput(VanillaTypes.ITEM, recipe.input)
		ingredients.setOutput(VanillaTypes.FLUID, recipe.output)
	}
}
