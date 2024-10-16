plugins {
    id("java")
}

dependencies {
    api(project(":bos-common"))
    implementation(project(":app-uc"))

    // Second-party packages
    implementation("com.luoge.ns:base-core:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-api:1.0-SNAPSHOT")
    // implementation("com.luoge.ns:uc-context:1.0-SNAPSHOT")
    implementation("com.luoge.bos:uc-context:1.0-SNAPSHOT")
    // Third-party packages
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("cn.hutool:hutool-all:5.8.18")

    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("org.apache.commons:commons-collections4:4.4")

    implementation("cn.hutool:hutool-core:5.8.22")
    implementation("cn.hutool:hutool-extra:5.8.22")
    implementation("com.sun.mail:javax.mail:1.6.2")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}