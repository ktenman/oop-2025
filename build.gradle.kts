import java.nio.charset.StandardCharsets

group = "ee.ut"
version = "0.0.1-SNAPSHOT"

val assertjCoreVersion = "3.26.3"
val junitJupiterVersion = "5.11.0"
val jsoupVersion = "1.18.1"
val selenideVersion = "7.4.2"

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jsoup:jsoup:$jsoupVersion")
    implementation("com.codeborne:selenide:$selenideVersion")
    testImplementation("org.assertj:assertj-core:$assertjCoreVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = StandardCharsets.UTF_8.name()
}
