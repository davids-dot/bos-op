plugins {
    id("java")
}

tasks.test {
    useTestNG()
}

dependencies {
    api(project(":op-core"))
    implementation(project(":bos-common"))

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.7")

    implementation("mysql:mysql-connector-java:8.0.22")

    implementation("com.baomidou:dynamic-datasource-spring-boot3-starter:4.2.0")

    implementation("org.mockito:mockito-inline:4.1.0")
    testImplementation("org.testng:testng:7.7.0")
}

