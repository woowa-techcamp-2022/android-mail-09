object Versions {
    const val APP_COMPAT = "1.4.2"
    const val MATERIAL = "1.6.1"
    const val CONSTRAINT_LAYOUT = "2.1.4"

    const val CORE = "1.7.0"
    const val ACTIVITY = "1.5.0"
    const val FRAGMENT = "1.5.0"

    const val JUNIT = "4.13.2"
    const val JUNIT_TEST = "1.1.3"

    const val ESPRESSO_CORE = "3.4.0"

    const val COROUTINE = "1.6.0"

    const val KOIN = "3.0.1"

    const val TIMBER = "4.7.1"
}

object Libraries {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
        const val ACTIVITY = "androidx.activity:activity-ktx:${Versions.ACTIVITY}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    }

    object JUnit {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }

    object Test {
        const val JUNIT = "androidx.test.ext:junit:${Versions.JUNIT_TEST}"
        const val KOIN = "io.insert-koin:koin-test:${Versions.KOIN}"
    }

    object AndroidTest {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    }

    object Coroutine {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    }

    object Koin {
        const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
        const val EXT = "io.insert-koin:koin-android-ext:${Versions.KOIN}"
    }

    object TIMBER {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }
}