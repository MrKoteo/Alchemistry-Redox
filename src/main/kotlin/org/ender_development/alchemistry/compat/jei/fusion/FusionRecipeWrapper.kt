package org.ender_development.alchemistry.compat.jei.fusion

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.ingredients.VanillaTypes
import net.minecraft.item.ItemStack
import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.compat.jei.AlchemistryRecipeWrapper
import org.ender_development.alchemistry.recipes.FusionRecipe

class FusionRecipeWrapper(recipe: FusionRecipe) : AlchemistryRecipeWrapper<FusionRecipe>(recipe) {

	override fun getIngredients(ingredients: IIngredients) {
		val input1 = ElementRegistry[recipe.inputMeta1]?.toItemStack(1)
		var input2 = ElementRegistry[recipe.inputMeta2]?.toItemStack(1)
		var output1 = ElementRegistry[recipe.outputMeta]?.toItemStack(1)
		ingredients.setInputs(VanillaTypes.ITEM, listOf(input1, input2))
		ingredients.setOutput(VanillaTypes.ITEM, output1 ?: ItemStack.EMPTY)
	}
}
