package org.ender_development.alchemistry.client.button

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import org.ender_development.alchemistry.Reference
import org.ender_development.catalyx.client.button.AbstractButtonWrapper

class LockButtonWrapper(x: Int, y: Int) : AbstractButtonWrapper(x, y) {
	override val textureLocation = ResourceLocation(Reference.MODID, "textures/gui/container/template_redox.png")

	enum class State {
		LOCKED, UNLOCKED
	}

	var isLocked = State.UNLOCKED

	override val drawButton: () -> GuiButton.(Minecraft, Int, Int, Float) -> Unit = { { mc, mouseX, mouseY, partialTicks ->
		mc.textureManager.bindTexture(textureLocation)
		GlStateManager.color(1F, 1F, 1F)
		val i = if(isLocked == State.LOCKED) 16 else 0
		drawTexturedModalRect(x, y, 64, i, 16, 16)
	} }
}
