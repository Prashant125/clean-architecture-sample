plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //Dagger-hilt
    alias(libs.plugins.dagger)
    kotlin("kapt")
}

android {
    namespace = "com.example.cleanarchitecturesampleapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cleanarchitecturesampleapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.google.dagger.hilt.android.testing.HiltTestRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.testing)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //retrofit dependencies
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    //Dagger_hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.kapt)
    implementation(libs.hilt.compose.navigation)

    //LiveData
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.runtime.compose)

    //coil
    implementation(libs.coil)

    //test
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinTest)
    kaptAndroidTest(libs.dagger.kapt)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.dagger.hilt.testing)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.hilt.compose.navigation)

}