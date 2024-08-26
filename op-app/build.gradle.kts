plugins {
    application
    id("com.qqviaja.gradle.MybatisGenerator") version "2.5"
}

apply(plugin = "org.springframework.boot")

tasks.test {
    useTestNG()
}

dependencies {
    implementation("com.luoge.ns:uc-api:1.1.0-SNAPSHOT")
    implementation(project(":op-invoice"))
    implementation(project(":app-bos-uc"))
    implementation(project(":app-invoice"))
    implementation(project(":app-uc"))
    implementation(project(":op-gateway"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:2022.0.0.0")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2022.0.0.0")
    implementation("org.apache.dubbo:dubbo-spring-boot-starter:3.2.9")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.7")
    implementation("mysql:mysql-connector-java:8.0.22")

    implementation("commons-codec:commons-codec:1.16.0")
    implementation("commons-io:commons-io:2.13.0")
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("org.apache.commons:commons-collections4:4.4")

    implementation("com.alibaba.fastjson2:fastjson2:2.0.41")
    implementation("cn.hutool:hutool-core:5.8.22")
    implementation("cn.hutool:hutool-extra:5.8.22")
    implementation("cn.hutool:hutool-crypto:5.8.22")
    implementation("com.alibaba:easyexcel:3.3.2")
    implementation("com.alicp.jetcache:jetcache-starter-redis:2.7.4")

    implementation("com.baomidou:dynamic-datasource-spring-boot3-starter:4.2.0")
    implementation("org.mockito:mockito-inline:4.1.0")
    testImplementation("org.testng:testng:7.7.0")
}


tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
tasks.register<Copy>("copyTask") {
    from("src/main/resources")
    into("build/output")
    // 设置重复文件处理策略
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks {
    // 配置 bootJar 任务
    withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        archiveFileName.set("bos-op-app-${project.version}.jar")
    }
}

mybatisGenerator {
    configFile = "op-app/src/main/resources/mybatis-generator/generatorConfig.xml"

    dependencies {
        mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.2")
        mybatisGenerator("mysql:mysql-connector-java:8.0.22")
    }
}
