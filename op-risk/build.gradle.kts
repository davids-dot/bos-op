dependencies {
    api("com.luoge.ns:base-core:1.1.0-SNAPSHOT")
    api("cn.hutool:hutool-core:5.8.22")
    api("commons-io:commons-io:2.13.0")
    api("org.apache.commons:commons-lang3:3.13.0")
    api("org.apache.commons:commons-collections4:4.4")

    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.3")

    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.testng:testng:7.8.0")
}

tasks.test {
    useTestNG()
}

