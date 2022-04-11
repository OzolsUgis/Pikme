apply{
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.registerDomain))

    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.gsonConverter)

    "implementation"(Coroutines.coroutines)

    "implementation"(Gson.gson)
}
