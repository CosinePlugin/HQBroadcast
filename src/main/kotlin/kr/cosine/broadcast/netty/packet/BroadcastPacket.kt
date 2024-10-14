package kr.cosine.broadcast.netty.packet

import io.netty.buffer.ByteBuf
import kr.hqservice.framework.netty.packet.Packet
import kr.hqservice.framework.netty.packet.extension.readString
import kr.hqservice.framework.netty.packet.extension.writeString

class BroadcastPacket(
    var message: String
) : Packet() {
    override fun read(buf: ByteBuf) {
        message = buf.readString()
    }

    override fun write(buf: ByteBuf) {
        buf.writeString(message)
    }
}