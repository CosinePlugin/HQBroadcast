package kr.cosine.broadcast.netty.module

import kr.cosine.broadcast.netty.packet.BroadcastPacket
import kr.hqservice.framework.bukkit.core.component.module.Module
import kr.hqservice.framework.bukkit.core.component.module.Setup
import kr.hqservice.framework.bukkit.core.netty.server.LocalNettyServer
import kr.hqservice.framework.netty.api.NettyServer
import org.bukkit.Server

@Module
class PacketModule(
    private val nettyServer: NettyServer,
    private val server: Server
) {
    @Setup
    fun setup() {
        if (nettyServer is LocalNettyServer) return
        nettyServer.registerInnerPacket(BroadcastPacket::class) { broadcastPacket, _ ->
            server.broadcastMessage(broadcastPacket.message)
        }
        nettyServer.registerOuterPacket(BroadcastPacket::class)
    }
}