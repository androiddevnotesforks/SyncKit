package com.hi.dhl.action

import com.hi.dhl.action.base.AbstractAnAction
import com.hi.dhl.common.DataManager
import com.hi.dhl.console.CommandManager
import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.konan.file.File
import com.hi.dhl.common.R
/**
 * <pre>
 *     author: dhl
 *     date  : 2022/9/10
 *     desc  :
 * </pre>
 */
class SyncToServiceAnAction : AbstractAnAction(R.String.ui.actionSyncToService) {

    override fun action(project: Project) {
        val commands = StringBuilder()
        val projectName = projectBasePath.substring(projectBasePath.lastIndexOf(File.separator) + 1)
        val remoteProjectPath = DataManager.getMachineInfo().remoteRootDir + File.separator + projectName
        CommandManager.syncLocalToRemote(commands, remoteProjectPath, remoteMachineInfo)
        execSyncRunnerConsole(project, projectBasePath, commands.toString())
    }

}