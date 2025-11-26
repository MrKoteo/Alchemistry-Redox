package org.ender_development.alchemistry.client.button

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import org.ender_development.alchemistry.Reference
import org.ender_development.catalyx.client.button.AbstractButtonWrapper

class SingleButtonWrapper(x: Int, y: Int) : AbstractButtonWrapper(x, y) {
	override val textureLocation = ResourceLocation(Reference.MODID, "textures/gui/container/template_redox.png")

	enum class State {
		SINGLE, REGULAR
	}

	var isSingle = State.REGULAR

	override val drawButton: () -> GuiButton.(Minecraft, Int, Int, Float) -> Unit = { { mc, mouseX, mouseY, partialTicks ->
		mc.textureManager.bindTexture(textureLocation)
		GlStateManager.color(1F, 1F, 1F)
		val i = if(isSingle == State.SINGLE) 16 else 0
		drawTexturedModalRect(x, y, 80, i, 16, 16)
	} }
}
