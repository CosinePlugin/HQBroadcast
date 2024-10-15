package kr.cosine.broadcast.netty.packet

import io.netty.buffer.ByteBuf
import kr.hqservice.framework.global.core.extension.compress
import kr.hqservice.framework.global.core.extension.decompress
import kr.hqservice.framework.netty.packet.Packet
import kr.hqservice.framework.netty.packet.extension.readString
import kr.hqservice.framework.netty.packet.extension.writeString

class BroadcastPacket(
    var senderName: String,
    var message: String
) : Packet() {
    override fun read(buf: ByteBuf) {
        senderName = buf.readString()
        val byteArray = ByteArray(buf.readableBytes())
        buf.readBytes(byteArray)
        message = byteArray.decompress().decodeToString()
    }

    override fun write(buf: ByteBuf) {
        buf.writeString(senderName)
        val byteArray = message.encodeToByteArray().compress()
        buf.writeBytes(byteArray)
    }
}