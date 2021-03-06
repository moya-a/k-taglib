plugins {
  kotlin("multiplatform") version "1.5.10"
  kotlin("plugin.serialization") version "1.5.10"
  java
  jacoco
  id("org.sonarqube") version "3.2.0"
}

group = "fr.amoya"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

  // Junit5 Test-Framework
  testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

  testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")

  testImplementation("org.testcontainers:testcontainers:1.15.3")
  testImplementation("org.testcontainers:junit-jupiter:1.15.3")
}



jacoco {
  toolVersion = "0.8.6"
}
sonarqube {
  properties {
    property("sonar.host.url", "https://sonarcloud.io")
    property("sonar.organization", "moya-a")
    property("sonar.projectKey", "moya-a_k-taglib")
    property("sonar.projectName", "K-TagLib")
    property("sonar.projectVersion", version)
    property("sonar.java.coveragePlugin", "jacoco")
    property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/test/jacocoTestReport.xml")
  }
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }
  withType<JacocoReport> {
    dependsOn("jvmTest")
    group = "Reporting"
    description = "Generate Jacoco coverage reports."
    val coverageSourceDirs = arrayOf(
      "commonMain/src",
      "jvmMain/src"
    )
    val classFiles = File("${buildDir}/classes/kotlin/jvm/")
      .walkBottomUp()
      .toSet()
    classDirectories.setFrom(classFiles)
    sourceDirectories.setFrom(files(coverageSourceDirs))
    additionalSourceDirs.setFrom(files(coverageSourceDirs))

    executionData.setFrom(files("${buildDir}/jacoco/jvmTest.exec"))
    reports {
      xml.isEnabled = true
      html.isEnabled = true
      html.destination = File("${buildDir}/jacoco-reports/html")
    }
  }

  kotlin {
    targets.all {
      compilations.all {
        kotlinOptions {
          // allWarningsAsErrors = true
          freeCompilerArgs = listOf(
            "-Xuse-experimental=kotlin.ExperimentalUnsignedTypes",
            "-XXLanguage:+InlineClasses"
          )
        }
      }
    }

    jvm {
      withJava()
      compilations.all {
        kotlinOptions.jvmTarget = "11"
      }
      testRuns["test"].executionTask.configure {
        useJUnitPlatform()
      }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when
    {
      hostOs == "Mac OS X" -> macosX64("native")
      hostOs == "Linux"    -> linuxX64("native")
      isMingwX64           -> mingwX64("native")
      else                 -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
      val commonMain by getting {
        dependencies {
          implementation(kotlin("stdlib"))
          implementation(kotlin("stdlib-common"))
          implementation(kotlin("reflect"))
          implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
        }
      }
      val commonTest by getting {
        dependencies {
          implementation(kotlin("test"))
          implementation(kotlin("test-common"))
          implementation(kotlin("test-annotations-common"))
        }
      }
      val jvmMain by getting
      val jvmTest by getting {
        dependencies {
          implementation(kotlin("test"))
        }
      }
      val nativeMain by getting
      val nativeTest by getting
    }
  }
}
