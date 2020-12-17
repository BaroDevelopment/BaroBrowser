package panel.gitlab

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JComponent

class GitlabPanelImpl(toolWindow: ToolWindow?) {
    private val viewer: GitlabViewer = GitlabViewer(toolWindow!!)
    val gitlabContent: JComponent
        get() = viewer.content
}