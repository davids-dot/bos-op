plugins {
    java
    application
    id("java-library")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.4"
}


allprojects {
    group = "com.luoge.ns"
    version = "1.0-SNAPSHOT"

    val env = System.getenv("profile") ?: "dev"
    val repoBaseUrl = "http://192.168.6.12:8081/repository"

    extra["repoGroupUrl"] = if (env == "dev") "$repoBaseUrl/ns-dev-group/" else "$repoBaseUrl/ns-group/"
    extra["repoSnapshotsUrl"] = if (env == "dev") "$repoBaseUrl/ns-dev-snapshots/" else "$repoBaseUrl/ns-snapshots/"
    extra["repoReleaseUrl"] = if (env == "dev") "$repoBaseUrl/ns-dev-release/" else "$repoBaseUrl/ns-release/"

    // 依赖仓库配置
    repositories {
        mavenLocal()
        maven {
            isAllowInsecureProtocol = true
            setUrl(extra["repoGroupUrl"].toString())
            credentials {
                username = project.properties["NS_USER"].toString()
                password = project.properties["NS_PASSWD"].toString()
            }
        }
        maven("https://maven.aliyun.com/repository/public")
        maven("https://repo.spring.io/milestone")
        maven("https://repo.spring.io/snapshot")
        maven("https://mirrors.huaweicloud.com/repository/maven/huaweicloudsdk")
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    java {
        withSourcesJar()
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.6")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.4")
        }
    }

    configurations.all {
        // check for updates every build
        resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }

}



