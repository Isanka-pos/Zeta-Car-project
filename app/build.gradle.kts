plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
val verCode: Int = (project.findProperty("verCode") as String?)?.toIntOrNull() ?: 1
android {
    namespace = "com.zeta.car"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.zeta.car"
        minSdk = 26
        targetSdk = 34
        versionCode = verCode
        versionName = "1.0.$verCode"
    }
    signingConfigs {
        create("zeta") {
            storeFile = file("$rootDir/zeta.keystore")
            storeType = "pkcs12"
            storePassword = "zetaboard"
            keyAlias = "zeta"
            keyPassword = "zetaboard"
        }
    }
    buildTypes {
        debug { signingConfig = signingConfigs.getByName("zeta") }
        release { isMinifyEnabled = false; signingConfig = signingConfigs.getByName("zeta") }
    }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
    lint { abortOnError = false; checkReleaseBuilds = false }
}
dependencies {
    implementation("androidx.core:core:1.13.1")
    implementation("androidx.webkit:webkit:1.11.0")
}
