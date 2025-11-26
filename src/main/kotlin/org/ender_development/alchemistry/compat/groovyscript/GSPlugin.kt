package org.ender_development.alchemistry.compat.groovyscript

import com.cleanroommc.groovyscript.api.GroovyBlacklist
import com.cleanroommc.groovyscript.api.GroovyPlugin
import com.cleanroommc.groovyscript.api.IGroovyContainer
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer
import com.cleanroommc.groovyscript.compat.mods.GroovyPropertyContainer
import com.cleanroommc.groovyscript.documentation.linkgenerator.LinkGeneratorHooks
import org.ender_development.alchemistry.Reference

class GSPlugin : GroovyPlugin {
	companion object {
		@GroovyBlacklist
		var instance: GSContainer? = null
	}

	override fun createGroovyPropertyContainer(): GroovyPropertyContainer? {
		instance = GSContainer()
		return instance
	}

	override fun getModId(): String {
		return Reference.MODID
	}

	override fun getContainerName(): String {
		return Reference.MOD_NAME
	}

	override fun onCompatLoaded(container: GroovyContainer<*>?) {
		LinkGeneratorHooks.registerLinkGenerator(LinkGenerator())
	}

	override fun getOverridePriority(): IGroovyContainer.Priority {
		return IGroovyContainer.Priority.OVERRIDE_HIGHEST
	}
}
