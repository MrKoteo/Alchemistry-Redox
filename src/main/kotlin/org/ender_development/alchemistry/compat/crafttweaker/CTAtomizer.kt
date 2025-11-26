package org.ender_development.alchemistry.compat.crafttweaker

import crafttweaker.IAction
import crafttweaker.annotations.ModOnly
import crafttweaker.annotations.ZenRegister
import crafttweaker.api.item.IItemStack
import crafttweaker.api.liquid.ILiquidStack
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.FluidStack
import org.ender_development.alchemistry.Alchemistry
import org.ender_development.alchemistry.Reference
import org.ender_development.alchemistry.recipes.AtomizerRecipe
import org.ender_development.alchemistry.recipes.register.AtomizerRegister
import stanhebben.zenscript.annotations.ZenClass
import stanhebben.zenscript.annotations.ZenMethod

@ZenClass("mods.${Reference.MODID}.Atomizer")
@ModOnly(Reference.MODID)
@ZenRegister
object CTAtomizer {

	@ZenMethod
	@JvmStatic
	fun addRecipe(output: IItemStack, input: ILiquidStack) {
		Alchemistry.LATE_ADDITIONS.add(object : IAction {
			override fun describe() = "Added Atomizer recipe for [$input] -> [$output]"

			override fun apply() {
				val inputStack = input.internal as FluidStack
				val outputStack = output.internal as ItemStack
				AtomizerRegister.Companion.INSTANCE.recipes.add(AtomizerRecipe(false, inputStack, outputStack))
			}
		})
	}

	@ZenMethod
	@JvmStatic
	fun removeRecipe(input: ILiquidStack) {
		Alchemistry.LATE_REMOVALS.add(object : IAction {
			override fun describe() = "Added Atomizer recipe for [$input]"

			override fun apply() {
				val inputStack = input.internal as FluidStack
				AtomizerRegister.Companion.INSTANCE.recipes.removeIf { it.input.isFluidEqual(inputStack) }
			}
		})
	}

	@ZenMethod
	@JvmStatic
	fun removeAllRecipes() {
		Alchemistry.LATE_REMOVALS.add(object : IAction {
			override fun describe() = "Removed ALL Atomizer recipes"

			override fun apply() = AtomizerRegister.Companion.INSTANCE.recipes.clear()
		})
	}
}
