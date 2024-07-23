plugins {
    id("java")
}

dependencies {
    api(project(":op-core"))

    // Second-party packages
    implementation("com.luoge.ns:base-core:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-api:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-context:1.0-SNAPSHOT")

    // Third-party packages
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("cn.hutool:hutool-all:5.8.18")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.7")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
    implementation("org.apache.dubbo:dubbo-spring-boot-starter:3.2.6")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2022.0.0.0")
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("cn.hutool:hutool-core:5.8.22")
    implementation("cn.hutool:hutool-extra:5.8.22")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("com.github.binarywang:weixin-java-miniapp:4.5.0")
    implementation("com.github.binarywang:weixin-java-mp:4.5.0")

    implementation("mysql:mysql-connector-java:8.0.22")

    implementation("com.baomidou:dynamic-datasource-spring-boot3-starter:4.2.0")

    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.testng:testng:7.7.0")
}
