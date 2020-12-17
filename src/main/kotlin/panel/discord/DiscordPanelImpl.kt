package panel.discord

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JComponent

class DiscordPanelImpl(toolWindow: ToolWindow?) {
    private val viewer: DiscordViewer = DiscordViewer(toolWindow!!)
    val discordContent: JComponent
        get() = viewer.content
}