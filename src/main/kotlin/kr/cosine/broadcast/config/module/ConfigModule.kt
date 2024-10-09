package kr.cosine.broadcast.config.module

import kr.cosine.broadcast.config.SettingConfig
import kr.hqservice.framework.bukkit.core.component.module.Module
import kr.hqservice.framework.bukkit.core.component.module.Setup

@Module
class ConfigModule(
    private val settingConfig: SettingConfig
) {
    @Setup
    fun setup() {
        settingConfig.load()
    }
}