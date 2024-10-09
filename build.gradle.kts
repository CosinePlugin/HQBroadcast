plugins {
    kotlin("jvm") version "1.7.21"
}

group = "kr.cosine.broadcast"
version = "1.0.1"

repositories {
    maven("https://maven.hqservice.kr/repository/maven-public")
}

dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.17.1-R0.1-SNAPSHOT")

    compileOnly("kr.hqservice", "hqframework-bukkit-core", "1.0.2-SNAPSHOT") {
        exclude("org.spigotmc")
        exclude("io.papermc.paper")
    }
    compileOnly("kr.hqservice", "hqframework-bukkit-command", "1.0.2-SNAPSHOT") {
        exclude("org.spigotmc")
        exclude("io.papermc.paper")
    }
    compileOnly("kr.hqservice", "hqframework-bukkit-inventory", "1.0.2-SNAPSHOT") {
        exclude("org.spigotmc")
        exclude("io.papermc.paper")
    }
    compileOnly("kr.hqservice", "hqframework-bukkit-nms", "1.0.2-SNAPSHOT") {
        exclude("org.spigotmc")
        exclude("io.papermc.paper")
    }

    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
}

tasks {
    test {
        useJUnitPlatform()
    }
    jar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}.jar")
        destinationDirectory.set(file("D:\\서버\\1.20.1 - 개발\\plugins"))
    }
}