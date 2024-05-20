plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.ifeel.components"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            aarMetadata {
                minCompileSdk = 23
            }
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    publishing {
//        singleVariant("release") {
//            withSourcesJar()
//        }
//    }
}

//publishing {
//    publications {
//        register<MavenPublication>("release") {
//            groupId = "com.ifeel"
//            artifactId = "components"
//            version = "1.0"
//            artifact("$buildDir/outputs/aar/components-debug.aar")
//
//            afterEvaluate {
//                from(components["release"])
//            }
//        }
//    }
//
//    repositories {
//        name = "GitHubPackages"
//        url = uri("https://maven.pkg.github.com/GermanIfeelDev/Ifeel-Components")
//    }
//}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.6")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
}