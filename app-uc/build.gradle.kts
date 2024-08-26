plugins {
    id("java")
}

tasks.test {
    useTestNG()
}

dependencies {
    api(project(":op-core"))

    implementation(project(":app-data"))
    implementation(project(":bos-common"))

    // Second-party packages
    implementation("com.luoge.ns:uc-api:1.1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-context:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-api:1.0-SNAPSHOT")
    implementation("com.luoge.ns:account-api:1.0.0-SNAPSHOT")
    implementation("com.luoge.ns:base-core:1.0-SNAPSHOT")

// Spring Boot starters
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

// Alibaba Cloud and Dubbo
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:2022.0.0.0")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2022.0.0.0")
    implementation("org.apache.dubbo:dubbo-spring-boot-starter:3.2.9")
    implementation("com.alibaba:easyexcel:3.3.2")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.7")
    implementation("com.baomidou:dynamic-datasource-spring-boot3-starter:4.2.0")

// Database and JDBC
    implementation("mysql:mysql-connector-java:8.0.22")

// Common libraries
    implementation("commons-codec:commons-codec:1.16.0")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.41")
    implementation("cn.hutool:hutool-all:5.8.22")
    implementation("com.alicp.jetcache:jetcache-starter-redis:2.7.4")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
    implementation("org.apache.dubbo:dubbo-spring-boot-starter:3.2.6")
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("com.github.binarywang:weixin-java-miniapp:4.5.0")
    implementation("com.github.binarywang:weixin-java-mp:4.5.0")
    implementation("com.github.binarywang:weixin-java-cp:4.5.0")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("com.sun.xml.bind:jaxb-core:2.3.0.1")
    implementation("com.sun.xml.bind:jaxb-impl:2.3.1")

// Testing
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.testng:testng:7.7.0")
}

