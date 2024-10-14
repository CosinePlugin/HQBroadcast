package kr.cosine.broadcast.service

import kr.cosine.broadcast.config.SettingConfig
import kr.cosine.broadcast.netty.packet.BroadcastPacket
import kr.hqservice.framework.bukkit.core.extension.colorize
import kr.hqservice.framework.bukkit.core.netty.server.ProxiedNettyServer
import kr.hqservice.framework.global.core.component.Service
import kr.hqservice.framework.netty.api.NettyServer
import kr.hqservice.framework.netty.api.PacketSender
import org.bukkit.command.CommandSender

@Service
class BroadcastService(
    private val packetSender: PacketSender,
    private val nettyServer: NettyServer,
    private val settingConfig: SettingConfig
) {
    fun broadcast(sender: CommandSender, message: String) {
        val broadcastFormat = settingConfig.getBroadcastFormat {
            it.replace("%message%", message).replace("%player%", sender.name)
        }.joinToString("\n").colorize()
        if (nettyServer is ProxiedNettyServer) {
            val broadcastPacket = BroadcastPacket(broadcastFormat)
            packetSender.sendPacketAll(broadcastPacket)
        } else {
            sender.server.broadcastMessage(broadcastFormat)
        }
    }
}