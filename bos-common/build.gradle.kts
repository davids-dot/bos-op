plugins {
    id("java")
}

dependencies {
    implementation("com.luoge.ns:base-core:1.0-SNAPSHOT")
    // third
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.41")
}
// gradle build -x test -b bos-common/build.gradle.kts