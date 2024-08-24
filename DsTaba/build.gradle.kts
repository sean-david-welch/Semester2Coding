plugins {
    id("java")
    id("com.google.protobuf") version "0.9.4" // Protobuf plugin for Gradle
}

group = "taba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:4.27.2")
    implementation("io.grpc:grpc-netty-shaded:1.65.1")
    implementation("io.grpc:grpc-protobuf:1.65.1")
    implementation("io.grpc:grpc-stub:1.65.1")

    implementation("javax.annotation:javax.annotation-api:1.3.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

// Protobuf Plugin Configuration
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.65.1"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
            }
        }
    }
}
