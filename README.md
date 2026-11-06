Arctic Move
Move it. Track it. Delivered.

Arctic Move is an Android parcel delivery application built with Kotlin and Jetpack Compose. It provides an interface for booking same-day deliveries, reviewing delivery quotes, viewing orders and checking delivery status.

Developed as an academic Software Development project at Rosebank College, the application combines an Arctic-inspired interface, local delivery storage with Room, and Firebase Authentication.
Project status
Development in progress — Android builds pass and physical-device testing is underway.

The delivery workflow and local storage have been implemented. Authentication has moved from local Room account checks to Firebase email/password authentication. Google sign-in has been added and the updated project builds successfully; end-to-end Google sign-in testing on a physical phone is pending confirmation.
Area	Current status
Android debug build	Successful after the Google sign-in patch
Physical-device installation	Previously completed successfully; latest build being distributed for testing
Firebase email/password authentication	Registration and login tested; user creation confirmed in Firebase Console
Incorrect-password handling	Tested during email/password verification
Google sign-in	Implemented and build verified; phone test pending
Delivery booking and Room storage	Implemented; regression testing remains necessary after updates
Retrofit networking layer	Defined; complete backend integration remains in progress
Multilingual settings	Work in progress; language switching requires further verification
Cloud delivery synchronization	Not yet verified as implemented
Push notifications	Firebase Messaging dependency included; delivery and handling not yet verified
Automated test coverage	Expansion and documented results remain outstanding


A successful build confirms compilation and packaging. It does not establish that every feature works correctly on a device.
Features
Authentication
- Email/password registration and login through Firebase Authentication.
- Registration form validation, including password confirmation.
- Duplicate-account and authentication-error handling.
- Logout functionality.
- Google sign-in button using Android Credential Manager and Firebase Authentication.
- Firebase-based retrieval of the signed-in user's identity.
The Firebase project has Email/Password and Google providers enabled. The development signing fingerprint has been registered, and the Android configuration file has been refreshed.

New authentication flows do not save passwords to Room. Legacy user tables and data from earlier prototype versions may still exist; removing old stored credentials requires a separate cleanup or database migration.
Book a delivery
Users provide pickup and destination addresses, recipient details, delivery instructions and package information such as type, description and weight.
Quote and review
Users review the pickup and delivery locations, recipient details, package details, delivery fee and estimated delivery time before confirming a booking.
Delivery confirmation
The booking workflow generates an Arctic Move order number, saves delivery information locally and includes a PIN-based delivery confirmation screen.

The delivery PIN belongs to the booking workflow. It is not Firebase phone authentication or verified SMS delivery.
My Orders
The orders interface retrieves locally stored deliveries and presents active and previous/delivered orders associated with the user's account.
Track Delivery
The tracking interface displays delivery information and status. Live driver GPS tracking and a complete external delivery-status feed are future improvements.
Profile and support
Users can view account information, access support options and log out. Email/password registration stores profile details locally where needed. Cloud profile synchronization is not yet complete. A Google account may not provide a phone number.
Interface and settings
- Arctic-inspired blue and cyan styling.
- Animated loading screen with mountains, clouds, aurora effects and an aircraft.
- Jetpack Compose screens and navigation.
- Settings interface for application preferences.
- Theme and multilingual settings work, with further device verification required.
Delivery workflow
1. Register or sign in.
2. Open Home and select Book a Delivery.
3. Enter pickup and delivery addresses.
4. Enter recipient details.
5. Enter package details.
6. Review the quote.
7. Complete delivery confirmation.
8. View the booking in My Orders or Track Delivery.
Architecture and data storage
Component	Responsibility
Compose screens	User interface, form input and feedback
Navigation Compose	Routes between authentication, home and delivery screens
UserRepository	Firebase authentication, current-user mapping and logout
GoogleSignInHelper	Google credential selection and token retrieval
Firebase Authentication	Email/password and Google identity authentication
DeliveryRepository and Room DAOs	Local delivery persistence and retrieval
DeliveryViewModel	Delivery-related screen state
Retrofit API layer	Definitions for planned delivery-service communication


Room remains responsible for local delivery data, including order identifiers, user email, addresses, recipient and package information, prices, estimated times and delivery status.

Local Room persistence does not by itself provide cloud synchronization. Including Firestore and Messaging libraries also does not establish that cloud delivery storage or push notifications are operational.
REST API
The existing Retrofit layer defines the following intended operations:
Method	Endpoint	Purpose
GET	/deliveries	Retrieve deliveries
GET	/deliveries/{orderId}	Retrieve a delivery
POST	/deliveries	Create a delivery
PUT	/deliveries/{orderId}	Update a delivery


The networking components include DeliveryApiModel.kt, ArcticMoveApiService.kt and RetrofitClient.kt. These definitions describe the intended API contract; a deployed server and complete Android-to-server integration are not yet confirmed.
Technologies
- Kotlin, Android Studio and Gradle.
- Jetpack Compose and Material Design 3.
- Navigation Compose and Kotlin Coroutines.
- Room Database and KSP.
- Firebase Authentication.
- Android Credential Manager and Google Identity libraries.
- Firebase Firestore and Messaging dependencies for planned integration.
- Retrofit, Gson Converter and OkHttp.
- Git and GitHub.
Build configuration
Setting	Current configuration
Application ID	com.example.arcticmove
Minimum Android SDK	24
Compile / target SDK	36 / 36
Java source / target compatibility	11
Gradle wrapper	9.1.0
Firebase BoM	34.4.0


Firebase BoM 34.4.0 is pinned because a newer dependency combination previously caused a Kotlin metadata compatibility error. Review Kotlin, Android Gradle Plugin and Firebase compatibility together before upgrading. Java source compatibility is distinct from the JDK used to run Gradle.
Key project files
Paths below are relative to app/src/main/java/com/example/arcticmove/.
Location	Main files
api/	ArcticMoveApiService.kt, DeliveryApiModel.kt, RetrofitClient.kt
data/	ArcticMoveDatabase.kt, DeliveryRepository.kt, delivery entities/DAOs, UserRepository.kt, User.kt, GoogleSignInHelper.kt
navigation/	AppNavigation.kt, Screen.kt
screens/	Loading, Login, Register, Home, booking, recipient, package, quote, PIN, orders, tracking, profile and settings screens
ui/theme/	Theme, colour and typography definitions
viewmodel/	DeliveryViewModel.kt
Application entry point	MainActivity.kt


Legacy UserDao.kt and UserEntity.kt may remain in the project during the transition away from local authentication.
Setup and running
Requirements
- Android Studio with a compatible Gradle JDK.
- Android SDK 36 and the SDK components requested by the project.
- An Android device or emulator meeting the minimum SDK.
- Internet access for dependencies and online authentication.
- A Firebase project configured for this application.
- For Google sign-in testing, a device with Google Play services and an available Google account.
Firebase configuration
1. Register the Android application using com.example.arcticmove.
2. Enable Email/Password and Google in Firebase Authentication.
3. Configure the Google provider's support email.
4. Obtain the development signing certificate report from the project root:
   .\gradlew.bat signingReport
5. Register the appropriate SHA-1 fingerprint in the Firebase Android app settings.
6. Download the updated configuration file and place it at app/google-services.json.
7. Ensure its filename is exactly google-services.json, without a duplicate-download suffix such as (1).
When building on another computer or with a different signing key, check that its fingerprint is registered. Release signing requires its own configuration; a debug fingerprint alone does not validate a release build.
Build
1. Clone or download the repository.
2. Open the project root containing app/ and gradlew.bat in Android Studio.
3. Complete Firebase configuration and synchronize Gradle.
4. Run from the project root on Windows:
   .\gradlew.bat assembleDebug
5. Find the generated APK at:
   app/build/outputs/apk/debug/app-debug.apk
6. Run on a connected Android device, or transfer the APK to the test phone and install it.
For an existing installation signed with the same key, install the new APK as an update. Uninstalling or clearing application data can remove locally stored deliveries.
Testing
Testing has included Android builds and manual installation on a physical Android phone. Email/password registration and login have been exercised, including checking that a registered account appears in Firebase Authentication and testing incorrect-password rejection.

The latest Google sign-in implementation has passed the debug build. Runtime verification remains pending.
Next verification checklist
- [ ] Install the latest APK and confirm the Google sign-in button appears.
- [ ] Open the Google account picker, select an account and reach Home.
- [ ] Confirm the selected account in Firebase Authentication and the app profile.
- [ ] Log out, cancel Google sign-in and confirm the Login screen remains usable.
- [ ] Sign in again and verify account switching where multiple accounts are available.
- [ ] Recheck email/password registration and correct/incorrect-password login.
- [ ] Verify useful error feedback when authentication has no internet connection.
- [ ] Create a delivery and check its quote, confirmation, order listing and tracking details.
- [ ] Restart the app and verify local delivery persistence.
- [ ] Check that one account cannot access another account's deliveries.
- [ ] Verify settings, theme behaviour and language changes across screens.
Automated test coverage and repeatable CI validation still need to be expanded. This README does not claim a complete automated test suite or full test coverage.
Known limitations and planned work
- Complete Google sign-in device testing and record evidence.
- Resolve and verify multilingual switching.
- Complete the delivery API backend and Retrofit integration.
- Implement authenticated cloud delivery storage and offline-to-online synchronization.
- Implement and test push notification delivery, permissions and navigation.
- Add cloud profile storage where required.
- Remove legacy locally stored passwords through an appropriate migration.
- Add automated tests for authentication handling, booking validation and data access.
- Configure release signing and prepare a release build for distribution.
- Complete documentation, demonstration evidence and final assessment checks.
Security and privacy
Arctic Move is an academic prototype. Firebase Authentication handles the new authentication flows, but production readiness also requires authorization rules, secure backend validation and careful handling of names, email addresses, phone numbers and delivery addresses.

Do not commit service-account private keys, signing keystores, passwords or authentication tokens. Do not store Google ID tokens or user passwords in the delivery database. Any future Firestore or API integration must enforce access by the authenticated user, rather than trusting a user identifier supplied by the client.
Developer
Lethukuthula Phelelani Dlomo
Diploma in Software Development
Rosebank College — Durban
Status note: This README records implemented work and reported verification separately. Pending checks should be marked complete only after the corresponding feature has been tested successfully.
