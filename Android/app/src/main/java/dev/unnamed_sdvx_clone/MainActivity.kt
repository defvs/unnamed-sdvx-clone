package dev.unnamed_sdvx_clone

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View


object MainActivity : Activity() {
    private val TAG = "SDL"

    private val libraries = listOf(
        "hidapi",
        "SDL2",
        "main",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        libraries.forEach(SDL::loadLibrary)
    }

    @JvmStatic
    fun onNativeMouse(i: Int, action: Int, x: Float, y: Float, b: Boolean) {
        throw NotImplementedError()
    }

    @JvmStatic
    fun isDeXMode(): Boolean {
        return if (Build.VERSION.SDK_INT < 24) {
            false
        } else try {
            val config: Configuration = applicationContext.resources.configuration
            val configClass: Class<*> = config.javaClass
            (configClass.getField("SEM_DESKTOP_MODE_ENABLED").getInt(configClass)
                    == configClass.getField("semDesktopModeEnabled").getInt(config))
        } catch (ignored: Exception) {
            false
        }
    }

    @JvmStatic
    fun nativeSetupJNI() {

    }

    @JvmStatic
    fun initialize() {

    }
}