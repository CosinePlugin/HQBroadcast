package kr.cosine.broadcast.config

import kr.hqservice.framework.bukkit.core.extension.colorize
import kr.hqservice.framework.global.core.component.Bean
import kr.hqservice.framework.yaml.config.HQYamlConfiguration

@Bean
class SettingConfig(
    private val config: HQYamlConfiguration
) {
    private var broadcastFormat = emptyList<String>()

    fun load() {
        broadcastFormat = config.getStringList("broadcast-format").map(String::colorize)
    }

    fun reload() {
        broadcastFormat = emptyList()
        config.reload()
        load()
    }

    fun getBroadcastFormat(replace: (String) -> String): List<String> {
        return broadcastFormat.map(replace)
    }
}