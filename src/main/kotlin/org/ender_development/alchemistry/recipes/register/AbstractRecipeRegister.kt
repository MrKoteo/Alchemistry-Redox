package org.ender_development.alchemistry.recipes.register

import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.oredict.OreDictionary
import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.recipes.IRecipe

abstract class AbstractRecipeRegister<T : IRecipe> {
	val recipes: MutableList<T> = mutableListOf()

	val heathens: Map<String, String> = mapOf(
		"aluminium" to "aluminum",
		"caesium" to "cesium"
	)

	val metals: List<String> = mutableListOf<String>()
		.apply { addAll(heathens.keys) }
		.apply { addAll(ElementRegistry.getAllElements().map { it.name }) }

	abstract fun registerRecipes()

	fun fluidExists(name: String): Boolean = FluidRegistry.isFluidRegistered(name)

	fun oreNotEmpty(ore: String) = OreDictionary.doesOreNameExist(ore) && OreDictionary.getOres(ore).isNotEmpty()
}
