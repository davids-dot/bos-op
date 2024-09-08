plugins {
    id("java")
}

tasks.test {
    useTestNG()
}

dependencies {
    api(project(":op-core"))
    implementation(project(":bos-common"))
    implementation(project(":uc-context"))
    implementation(project(":app-data"))
    implementation("com.luoge.ns:uc-api:1.1.0-SNAPSHOT")
    //implementation("com.luoge.ns:uc-context:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-context:1.0-SNAPSHOT")
    implementation("com.luoge.ns:account-api:1.0.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-api:1.0-SNAPSHOT")


    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2022.0.0.0")
    implementation("org.apache.dubbo:dubbo-spring-boot-starter:3.2.9")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.7")

    implementation("mysql:mysql-connector-java:8.0.22")
    implementation("commons-codec:commons-codec:1.16.0")
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

