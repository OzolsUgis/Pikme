package com.ugisozols.setup_domain

class NativeLib {

    /**
     * A native method that is implemented by the 'setup_domain' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'setup_domain' library on application startup.
        init {
            System.loadLibrary("setup_domain")
        }
    }
}