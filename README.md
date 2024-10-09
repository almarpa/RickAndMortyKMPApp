This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


* `Snapshots:`


![image](https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/1.png?raw=true)

![image](https://github.com/user-attachments/assets/ee51150b-4720-4a61-a0f3-d6578f5fd67c)
