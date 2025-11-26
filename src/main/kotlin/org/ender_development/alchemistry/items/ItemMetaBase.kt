package org.ender_development.alchemistry.items

import org.ender_development.alchemistry.Alchemistry
import org.ender_development.catalyx.items.BaseItem

abstract class ItemMetaBase(name: String) : BaseItem(Alchemistry, name) {
	init {
		hasSubtypes = true
	}
}
