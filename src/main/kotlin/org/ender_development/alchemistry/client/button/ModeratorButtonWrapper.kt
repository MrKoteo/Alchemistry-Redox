package org.ender_development.alchemistry.client.button

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import org.ender_development.alchemistry.Reference
import org.ender_development.catalyx.client.button.AbstractButtonWrapper

class ModeratorButtonWrapper(x: Int, y: Int) : AbstractButtonWrapper(x, y) {
	override val textureLocation = ResourceLocation(Reference.MODID, "textures/gui/container/template_redox.png")

	override val drawButton: () -> GuiButton.(Minecraft, Int, Int, Float) -> Unit = { { mc, mouseX, mouseY, partialTicks ->
		mc.textureManager.bindTexture(textureLocation)
		GlStateManager.color(1f, 1f, 1f)
		drawTexturedModalRect(x, y, 48, 32, 16, 16)
	} }
}
