plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.compose") version "1.6.1"
}

android {
    namespace = "com.app.imageslider"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.imageslider"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13" // must match your Compose version
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding=true
        compose =true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.compose.ui:ui:1.6.1")
    implementation ("androidx.compose.material:material:1.6.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.1")
    implementation ("androidx.activity:activity-compose:1.9.0")

// Accompanist Pager for horizontal image carousel
    implementation ("com.google.accompanist:accompanist-pager:0.34.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.34.0")

// Coil for Compose
    implementation("io.coil-kt:coil-compose:2.4.0")

}