package org.ender_development.alchemistry.compat.jei.electrolyzer

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.ingredients.VanillaTypes
import net.minecraft.client.Minecraft
import org.ender_development.alchemistry.Alchemistry
import org.ender_development.alchemistry.compat.jei.AlchemistryRecipeWrapper
import org.ender_development.alchemistry.recipes.ElectrolyzerRecipe
import java.awt.Color

class ElectrolyzerRecipeWrapper(recipe: ElectrolyzerRecipe) : AlchemistryRecipeWrapper<ElectrolyzerRecipe>(recipe) {

	override fun drawInfo(minecraft: Minecraft, recipeWidth: Int, recipeHeight: Int, mouseX: Int, mouseY: Int) {
		//TODO localization support
		val textFirst = "${Alchemistry.DECIMAL_FORMAT.format(recipe.output3Probability)}%"
		val textLast = "${Alchemistry.DECIMAL_FORMAT.format(recipe.output4Probability)}%"

		val x = 114
		var y = 50
		if(!recipe.outputs[2].isEmpty) minecraft.fontRenderer.drawString(textFirst, x, y, Color.BLACK.rgb)
		y += 18
		if(!recipe.outputs[3].isEmpty) minecraft.fontRenderer.drawString(textLast, x, y, Color.BLACK.rgb)
	}

	override fun getIngredients(ingredients: IIngredients) {
		ingredients.setInput(VanillaTypes.FLUID, recipe.input)
		ingredients.setInputs(VanillaTypes.ITEM, recipe.electrolytes)
		ingredients.setOutputs(VanillaTypes.ITEM, recipe.outputs)
	}
}
