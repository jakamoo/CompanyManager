import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.20"

    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"

    id("org.openapi.generator") version "6.5.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"

    kotlin("plugin.spring") version "1.8.20"
    kotlin("plugin.jpa") version "1.8.20"
    id("io.freefair.lombok") version "8.3"


}

group = "enoca.company"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.swagger:swagger-annotations:1.6.8")



    runtimeOnly("org.springframework.boot:spring-boot-devtools")


    runtimeOnly("com.h2database:h2:2.1.214")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

ktlint {
    filter {
        exclude { entry ->
            entry.file.toString().contains("generated")
        }
    }
}

springBoot {
    mainClass.set("enoca.company.DemoApplication.java")
}

sourceSets {
    val main by getting
    main.java.srcDirs("src/main/java", "$buildDir/generated/src/main/java")
}



tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

