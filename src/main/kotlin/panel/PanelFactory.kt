package panel

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import panel.discord.DiscordPanelImpl
import panel.github.GithubPanelImpl
import panel.gitlab.GitlabPanelImpl
import panel.youtube.YoutubePanelImpl

class PanelFactory : ToolWindowFactory, DumbAware {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        val content = ContentFactory.SERVICE.getInstance()

        val githubWindow = GithubPanelImpl(toolWindow)
        val githubContent = content.createContent(githubWindow.githubContent, "Github", false)
        toolWindow.contentManager.addContent(githubContent)

        val gitlabWindow = GitlabPanelImpl(toolWindow)
        val gitlabContent = content.createContent(gitlabWindow.gitlabContent, "Gitlab", false)
        toolWindow.contentManager.addContent(gitlabContent)

        val youtubeWindow = YoutubePanelImpl(toolWindow)
        val youtubeContent = content.createContent(youtubeWindow.youtubeContent, "Youtube", false)
        toolWindow.contentManager.addContent(youtubeContent)

        val discordWindow = DiscordPanelImpl(toolWindow)
        val discordContent = content.createContent(discordWindow.discordContent, "Discord", false)
        toolWindow.contentManager.addContent(discordContent)
    }
}