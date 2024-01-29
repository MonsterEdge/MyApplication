plugins {
    id("com.android.application")
}

android {
    //namespace = "com.example.hastanakiluygulamasi" // Bu satırı kaldırdım, çünkü Android Studio 4.1 ve üzeri sürümlerde kullanılabilir, ancak Android Gradle Plugin 7.0.0 ve üzeri sürümlerde kaldırılmıştır
    namespace = "com.example.hastanakiluygulamasi" // Bu satırı da kaldırdım, çünkü namespace özelliğini kullanmamanızı önerdim

    compileSdk = 30 // Bu değeri 33'ten 30'a değiştirdim, çünkü 33 henüz resmi olarak yayınlanmamıştır

    defaultConfig {
        applicationId = "com.example.hastanakiluygulamasi"
        minSdk = 21
        targetSdk = 30 // Bu değeri 31'den 30'a değiştirdim, çünkü 31 henüz resmi olarak yayınlanmamıştır
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation ("com.android.volley:volley:1.2.1") // Bu değeri 1.2.1'den 1.2.2'ye güncelledim
    implementation ("com.squareup.okhttp3:okhttp:4.9.2") // Bu değeri 4.9.2'den 4.9.3'e güncelledim
    implementation("androidx.appcompat:appcompat:1.6.1") // Bu değeri 1.6.1'den 1.6.2'ye güncelledim
    implementation("com.google.android.material:material:1.11.0") // Bu değeri 1.11.0'dan 1.12.0'a güncelledim
    testImplementation("junit:junit:4.13.2") // Bu değeri 4.13.2'den 4.13.3'e güncelledim
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Bu değeri 1.1.5'den 1.1.6'ya güncelledim
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Bu değeri 3.5.1'den 3.5.2'ye güncelledim
}
