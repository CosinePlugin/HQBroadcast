package kr.cosine.broadcast.command

import kr.cosine.broadcast.service.BroadcastService
import kr.hqservice.framework.bukkit.core.extension.colorize
import kr.hqservice.framework.global.core.component.Bean
import org.bukkit.command.*

@Bean
class BroadcastCommand(
    private val broadcastService: BroadcastService
) : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("§c메시지를 입력해주세요.")
            return true
        }
        val message = args.joinToString(" ").colorize()
        broadcastService.broadcast(sender, message)
        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): List<String> {
        return emptyList()
    }
}