package kr.cosine.broadcast.command

import kr.cosine.broadcast.config.SettingConfig
import kr.hqservice.framework.command.Command
import kr.hqservice.framework.command.CommandExecutor
import org.bukkit.command.CommandSender

@Command(label = "공지관리", isOp = true)
class BroadcastAdminCommand(
    private val settingConfig: SettingConfig
) {
    @CommandExecutor("리로드", "config.yml을 리로드합니다.", priority = 1)
    fun reload(sender: CommandSender) {
        settingConfig.reload()
        sender.sendMessage("§aconfig.yml을 리로드하였습니다.")
    }
}