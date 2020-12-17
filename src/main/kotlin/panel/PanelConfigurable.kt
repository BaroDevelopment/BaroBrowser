package panel

import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SearchableConfigurable
import org.jetbrains.annotations.Nls
import java.io.File
import javax.swing.JComponent

class PanelConfigurable : SearchableConfigurable {
    private var panelSettingsComponent: PanelSettingsComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String {
        return "BaroBrowser"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return panelSettingsComponent?.getPreferredFocusedComponent()
    }

    override fun getId(): String = "BaroBrowser"

    override fun createComponent(): JComponent {
        val component = PanelSettingsComponent()
        panelSettingsComponent = component
        return component.getPanel()
    }

    override fun isModified(): Boolean {
        val settings: PanelSettingsState = PanelSettingsState.getInstance()
        return panelSettingsComponent!!.getSessionPath() != settings.getSessionPath()
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
        val settings: PanelSettingsState = PanelSettingsState.getInstance()
        val sessionPathString = panelSettingsComponent!!.getSessionPath()
        val sessionPath = File(sessionPathString)
        if (!sessionPath.exists())
            throw ConfigurationException("BaroBrowser session path does not point to an existent directory")
        if (!sessionPath.isDirectory)
            throw ConfigurationException("BaroBrowser session path does not point to a directory")
        settings.setSessionPath(sessionPathString)
    }

    override fun reset() {
        val settings: PanelSettingsState = PanelSettingsState.getInstance()
        val sessionPath = settings.getSessionPath()
        panelSettingsComponent!!.setSessionPath(sessionPath)
    }

    override fun disposeUIResources() {
        panelSettingsComponent = null
    }
}