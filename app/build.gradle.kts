plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
}

android {

    namespace = "com.example.arcticmove"

    compileSdk {
        version = release(36)
    }

    defaultConfig {

        applicationId = "com.example.arcticmove"

        minSdk = 24
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    // =========================================
    // ANDROID CORE
    // =========================================

    implementation(
        libs.androidx.core.ktx
    )

    implementation(
        libs.androidx.lifecycle.runtime.ktx
    )

    implementation(
        libs.androidx.activity.compose
    )


    // =========================================
    // NAVIGATION
    // =========================================

    implementation(
        "androidx.navigation:navigation-compose:2.9.5"
    )


    // =========================================
    // JETPACK COMPOSE BOM
    // =========================================

    implementation(
        platform(libs.androidx.compose.bom)
    )


    // =========================================
    // COMPOSE UI
    // =========================================

    implementation(
        libs.androidx.compose.ui
    )

    implementation(
        libs.androidx.compose.ui.graphics
    )

    implementation(
        libs.androidx.compose.ui.tooling.preview
    )


    // =========================================
    // MATERIAL 3
    // =========================================

    implementation(
        libs.androidx.compose.material3
    )


    // =========================================
    // MATERIAL ICONS
    // =========================================

    implementation(
        "androidx.compose.material:material-icons-extended"
    )


    // =========================================
    // ROOM DATABASE
    // =========================================

    implementation(
        libs.androidx.room.runtime
    )

    implementation(
        libs.androidx.room.ktx
    )

    ksp(
        libs.androidx.room.compiler
    )


    // =========================================
    // REST API - RETROFIT
    // =========================================

    implementation(
        "com.squareup.retrofit2:retrofit:2.11.0"
    )


    // =========================================
    // REST API - GSON JSON CONVERTER
    // =========================================

    implementation(
        "com.squareup.retrofit2:converter-gson:2.11.0"
    )


    // =========================================
    // REST API - OKHTTP LOGGING
    // =========================================

    implementation(
        "com.squareup.okhttp3:logging-interceptor:4.12.0"
    )


    // =========================================
    // UNIT TESTING
    // =========================================

    testImplementation(
        libs.junit
    )


    // =========================================
    // ANDROID TESTING
    // =========================================

    androidTestImplementation(
        libs.androidx.junit
    )

    androidTestImplementation(
        libs.androidx.espresso.core
    )

    androidTestImplementation(
        platform(libs.androidx.compose.bom)
    )

    androidTestImplementation(
        libs.androidx.compose.ui.test.junit4
    )


    // =========================================
    // DEBUG TOOLS
    // =========================================

    debugImplementation(
        libs.androidx.compose.ui.tooling
    )

    debugImplementation(
        libs.androidx.compose.ui.test.manifest
    )
}