package panel.github

import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.jcef.JBCefBrowser
import com.jetbrains.cef.JCefAppConfig
import panel.PanelSettingsState
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JComponent

class GithubViewer(window: ToolWindow) {

    private val url = "https://github.com/"

    companion object {
        val ICON = IconLoader.getIcon("/icons/logo.svg")
    }

    @JvmField
    val jbrowser: JBCefBrowser
    val content: JComponent
        get() = jbrowser.component

    init {
        val cachePath = PanelSettingsState.getInstance().getSessionPath()
        if (cachePath != "") {
            val realCefSettings = JCefAppConfig.getInstance().cefSettings
            realCefSettings.cache_path = cachePath
            realCefSettings.persist_session_cookies = true
        }
        jbrowser = JBCefBrowser(url)
    }


    init {
        window.setIcon(ICON)
        window.component.addFocusListener(object : FocusListener {
            override fun focusGained(focusEvent: FocusEvent) {
                for (listener in jbrowser.component.focusListeners) listener.focusGained(focusEvent)
            }

            override fun focusLost(focusEvent: FocusEvent) {
                for (listener in jbrowser.component.focusListeners) listener.focusLost(focusEvent)
            }
        })
    }
}