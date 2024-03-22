buildscript {
    val agp_version by extra("4.0.2")
    val agp_version1 by extra("7.4.0")
    val agp_version2 by extra("8.0.0")
    val agp_version3 by extra("8.2.0-rc01")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-rc01" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}