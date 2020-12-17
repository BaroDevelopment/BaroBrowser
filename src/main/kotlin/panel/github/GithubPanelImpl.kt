package panel.github

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JComponent

class GithubPanelImpl(toolWindow: ToolWindow?) {
    private val viewer: GithubViewer = GithubViewer(toolWindow!!)
    val githubContent: JComponent
        get() = viewer.content
}