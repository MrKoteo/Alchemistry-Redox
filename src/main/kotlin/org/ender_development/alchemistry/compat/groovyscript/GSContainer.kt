package org.ender_development.alchemistry.compat.groovyscript

import com.cleanroommc.groovyscript.api.Result
import com.cleanroommc.groovyscript.api.infocommand.InfoParserRegistry
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer
import com.cleanroommc.groovyscript.compat.mods.GroovyPropertyContainer
import net.minecraft.item.ItemStack
import org.ender_development.alchemistry.chemistry.ChemicalCompound
import org.ender_development.alchemistry.chemistry.ChemicalElement
import org.ender_development.alchemistry.chemistry.CompoundRegistry
import org.ender_development.alchemistry.chemistry.ElementRegistry
import org.ender_development.alchemistry.compat.groovyscript.content.Content
import org.ender_development.alchemistry.compat.groovyscript.parser.Compound
import org.ender_development.alchemistry.compat.groovyscript.parser.Element
import org.ender_development.alchemistry.compat.groovyscript.register.*

class GSContainer : GroovyPropertyContainer() {
	val atomizer: Atomizer = Atomizer()
	val combiner: Combiner = Combiner()
	val dissolver: Dissolver = Dissolver()
	val electrolyzer: Electrolyzer = Electrolyzer()
	val evaporator: Evaporator = Evaporator()
	val liquifier: Liquifier = Liquifier()
	val content: Content = Content()

	init {
		addProperty(atomizer)
		addProperty(combiner)
		addProperty(dissolver)
		addProperty(electrolyzer)
		addProperty(evaporator)
		addProperty(liquifier)
		addProperty(content)
	}

	override fun initialize(owner: GroovyContainer<*>) {
		owner.objectMapperBuilder("element", ItemStack::class.java)
			.parser { s, args ->
				val parsedName = s.trim().lowercase().replace(" ", "_")
				val compound: ChemicalCompound? = CompoundRegistry[parsedName]
				if(compound == null || compound.toItemStack(1).isEmpty) {
					val element: ChemicalElement? = ElementRegistry[parsedName]
					if(element == null || element.toItemStack(1).isEmpty) {
						return@parser Result.error()
					}
					return@parser Result.some(element.toItemStack(1))
				}
				return@parser Result.some(compound.toItemStack(1))
			}
			.defaultValue { ItemStack.EMPTY }
			.completerOfNamed(CompoundRegistry::compounds, ChemicalCompound::name)
			.completerOfNamed(ElementRegistry::getAllElements, ChemicalElement::name)
			.docOfType("chemical element or compound as item stack")
			.register()

		InfoParserRegistry.addInfoParser(Compound.instance)
		InfoParserRegistry.addInfoParser(Element.instance)
	}
}
