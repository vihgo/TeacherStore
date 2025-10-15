plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.teacherstore"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.teacherstore"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    // 1. Asegúrate de que tu Compose BOM (Bill of Materials) esté actualizado en tu archivo libs.versions.toml
    //    Para las versiones alpha/beta de Compose 1.9.x, necesitarás un BOM específico.
    //    Si prefieres estabilidad, usa un BOM más estable como "2024.09.00".
    implementation(platform(libs.androidx.compose.bom))

    // 2. Dependencias de Compose UI - El BOM gestionará sus versiones.
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)

    // 3. ACTUALIZAR: Usa la versión de Material3 del BOM.
    //    La versión 1.3.0 es demasiado nueva para ser estable pero puede que el BOM la alinee.
    //    Asegúrate de que libs.androidx.material3 no tenga una versión fija si usas el BOM.
    implementation(libs.androidx.material3)

    // 4. ACTUALIZAR: Usa la versión de navigation-compose compatible.
    //    La versión 2.7.7 es estable. Si usas versiones alpha/beta de Compose,
    //    podrías necesitar una versión alpha/beta de navigation también.
    //    Por ahora, la 2.7.7 debería funcionar si ajustas las demás dependencias.
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // 5. Dependencias de Lifecycle y Coroutines (estas suelen ser compatibles)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.kotlinx.coroutines.android)

    // 6. Dependencias de Datastore (estas versiones están bien)
    implementation("androidx.datastore:datastore-preferences:1.1.7")
    // Nota: has incluido datastore-preferences-core, que es una dependencia transitiva de la anterior.
    // Puedes eliminar la siguiente línea si ya tienes "datastore-preferences".
    // implementation(libs.androidx.datastore.preferences.core)

    // 7. Otras dependencias
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material.icons.extended) // También gestionado por el BOM

    // Dependencias de testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Dependencias de Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}