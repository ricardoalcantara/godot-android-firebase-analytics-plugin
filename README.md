# Godot Firebase Analytics

This is Godot Android Firebase Analytics Plugin for Godot 3.2.2 using the new plugin system.

This is based on this other plugin https://github.com/yalcin-ata/godot-android-plugin-firebase

## Why?

Because I wanted a simple and clean Firebase Analytics Only integration.

## Steps to add this plugin to your Godot project are as follows:

- Open your project in Godot
- Install Export Templates if necessary
- Install Android build template
- Download from this repository's ```downloads``` directory both __Firebase.release.aar__ and __Firebase.release.gdpa__ and copy them to ```[GODOT-PROJECT]/android/plugins/```
- Download from this repository's ```downloads``` directory __godot-firebase-config.json__ and copy it to ```[GODOT-PROJECT]/android/build/assets``` (create the directory if necessary) and edit it to match your settings (especially AdMob App ID and ad unit IDs)
- Download your project's __google-services.json__ from Firebase Console and copy it to ```[GODOT-PROJECT]/android/build/```
- Edit ```[GODOT-PROJECT]/android/build/build.gradle```:
  - add ```classpath 'com.google.gms:google-services:4.3.3'``` above the line ```//CHUNK_BUILDSCRIPT_DEPENDENCIES_BEGIN```
  - add ```apply plugin: 'com.google.gms.google-services'``` above the line ```//CHUNK_GLOBAL_BEGIN```
- In Godot select menu Project > Export, add Android and edit your settings (package unique name, keystores, etc.) and select under Custom Template: Use Custom Build and also under Plugins: GodotFirebaseAnalytics.

That should be it!

## Compiling

Prerequisites:

- Android SDK (platform version 29)
- the Godot Android library (`godot-lib.***.release.aar`) for your version of Godot from the [downloads page](https://godotengine.org/download).

Steps to build:

1. Clone this Git repository
2. Copy `godot-lib.***.release.aar` to `./godot-firebase-analytics/libs`
2. Run `./gradlew build` in the cloned repository

When finished the  `.aar` for both debug and release can be found here: ```build/outputs/aar```
