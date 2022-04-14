
buildscript{
    dependencies{
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)

    }
}
plugins {
    id(Plugins.androidApplication) version Plugins.androidApplication_version apply false
    id(Plugins.androidLibrary) version Plugins.androidApplication_version apply false
    id(Plugins.kotlinAndroid) version Plugins.kotlinAndroid_version apply false
    id(Plugins.kotlinJvm) version Plugins.kotlinAndroid_version apply false



}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
