plugins {
    id("java")
}

group = "ru.infomaximum"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

var openCsvVersion = "5.7.1"
var junitVersion = "5.9.2"
var jacksonVersion = "2.14.2"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("com.opencsv:opencsv:$openCsvVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}