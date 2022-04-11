apply{
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.registerDomain))

    "implementation"(project(Modules.core_ui))

}
