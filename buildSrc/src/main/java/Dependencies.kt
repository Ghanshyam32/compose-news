object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx: ${Versions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { ("androidx.compose:compose-bom:${Versions.composeBom}") }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler: ${Versions.hilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
}


object Modules {
    const val utilities = ":utilities"
}