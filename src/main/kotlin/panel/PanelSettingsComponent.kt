package panel

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class PanelSettingsComponent {
    private var mainPanel: JPanel
    private val sessionPath = TextFieldWithBrowseButton()

    init {
        sessionPath.addBrowseFolderListener(TextBrowseFolderListener(FileChooserDescriptor(false, true, false, false, false, false)))
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("BaroBrowser session cache path: "), sessionPath, 1, false)
                .addComponentFillVertically(JPanel(), 0)
                .panel
    }

    fun getPanel(): JPanel {
        return mainPanel
    }

    fun getPreferredFocusedComponent(): JComponent {
        return sessionPath
    }

    fun getSessionPath(): String = sessionPath.text
    fun setSessionPath(sessionPath: String?) {
        this.sessionPath.text = sessionPath ?: ""
    }
}