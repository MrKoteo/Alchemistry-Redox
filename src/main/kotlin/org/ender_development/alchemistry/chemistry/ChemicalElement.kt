package org.ender_development.alchemistry.chemistry

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import org.ender_development.alchemistry.items.ModItems
import java.awt.Color

class ChemicalElement(override var name: String, val abbreviation: String, override var color: Color = Color.white, var group: Int = 0, var period: Int = 0) : ICompoundComponent {

	override val item: Item
		get() = ModItems.elements

	override val meta: Int
		get() = ElementRegistry.getMeta(this.name)

	override fun toItemStack(quantity: Int) = ItemStack(item, quantity, this.meta)

	override fun toString(): String = "Element: $name"

	override fun toAbbreviatedString(): String = this.abbreviation
}
