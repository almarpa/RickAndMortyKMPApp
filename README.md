This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


* `Snapshots:`
<h3>
<img src="https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/1.png?raw=true" width=30% height=50%>
<img src="https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/2.png?raw=true" width=30% height=50%>
<img src="https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/3.png?raw=true" width=30% height=50%>
<img src="https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/4.png?raw=true" width=30% height=50%>
<img src="https://github.com/almarpa/RickAndMortyApp/blob/develop/composeApp/src/commonMain/snapshots/5.png?raw=true" width=30% height=50%>
</h3>
