package org.ender_development.alchemistry.utils.extensions

import net.minecraft.item.ItemStack
import org.ender_development.alchemistry.chemistry.CompoundRegistry
import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.catalyx.utils.extensions.toStack

fun String.chemical(quantity: Int = 1, meta: Int = 0): ItemStack {
	ElementRegistry[this]?.apply { return toItemStack(quantity) }
	CompoundRegistry[this]?.apply { return toItemStack(quantity) }

	return toStack(quantity, meta)
}
