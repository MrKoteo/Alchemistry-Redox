package org.ender_development.alchemistry.compat.groovyscript

import com.cleanroommc.groovyscript.documentation.linkgenerator.BasicLinkGenerator
import org.ender_development.alchemistry.Reference

class LinkGenerator : BasicLinkGenerator() {
	override fun id(): String? {
		return Reference.MODID
	}

	override fun domain(): String? {
		return "https://github.com/Ender-Development/Alchemistry/"
	}
}
