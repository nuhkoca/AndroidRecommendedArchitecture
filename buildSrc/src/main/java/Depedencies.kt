object Versions {
    const val compile_sdk = 28
    const val min_sdk = 21
    const val target_sdk = 28

    const val version_code = 1
    const val version_name = "1.0"

    const val x = "1.7.1"
    const val material = "1.13.0"
    const val constraint_layout = "2.2.1"
    const val room = "2.8.4"
    const val dagger = "2.58"
    const val paging = "3.3.6"
    const val livedata = "2.10.0"
    const val rxjava = "2.2.21"
    const val rxandroid = "2.1.1"
    const val jetbrains = "26.0.2-1"
    const val retrofit = "3.0.0"
    const val okhttp = "5.3.2"
    const val glide = "5.0.5"
    const val kotlin_version = "2.3.0"
    const val databinding = "9.0.0"
}

object Libs {
    val x = "androidx.appcompat:appcompat:${Versions.x}"
    val material = "com.google.android.material:material:${Versions.material}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.material}"
    val cardview = "androidx.cardview:cardview:${Versions.material}"
    val constrain_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val room = "androidx.room:room-common:${Versions.room}"
    val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    val paging = "androidx.paging:paging-common:${Versions.paging}"
    val paging_runtime = "androidx.paging:paging-runtime:${Versions.paging}"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.livedata}"
    val lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:${Versions.livedata}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val rxjava_android = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val jetbrains = "org.jetbrains:annotations:${Versions.jetbrains}"
    val retrofit_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val okhttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}
