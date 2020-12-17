package panel

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
        name = "panel.PanelSettingsState",
        storages = [Storage("PanelSettings.xml")]
)
class PanelSettingsState : PersistentStateComponent<PanelSettingsState.State> {
    companion object {
        fun getInstance(): PanelSettingsState {
            return ServiceManager.getService(PanelSettingsState::class.java)
        }
    }

    class State {
        var sessionPath = ""
    }

    var _state = State()

    override fun getState(): State = _state

    override fun loadState(state: State) {
        _state = state
    }

    fun getSessionPath(): String = _state.sessionPath

    fun setSessionPath(sessionPath: String) {
        _state.sessionPath = sessionPath
    }
}