package panel.youtube

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JComponent

class YoutubePanelImpl(toolWindow: ToolWindow?) {
    private val viewer: YoutubeViewer = YoutubeViewer(toolWindow!!)
    val youtubeContent: JComponent
        get() = viewer.content
}