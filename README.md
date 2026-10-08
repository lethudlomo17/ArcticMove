# Arctic Move

Move it. Track it. Delivered.

Arctic Move is a Kotlin-based Android parcel delivery application designed to provide users with a simple and convenient way to book, manage, and track same-day deliveries.

The application was developed using **Android Studio**, **Kotlin**, and **Jetpack Compose**, with **Room Database** used for local data persistence. REST API functionality using **Retrofit** is also being implemented to support communication between the Android application and the Arctic Move delivery service.


 Project Overview

Arctic Move provides a digital delivery experience where users can create an account, sign in, book a delivery, enter recipient and package information, review delivery details, confirm a delivery, view previous orders, and access delivery tracking functionality.

The application focuses on providing a clean, modern and user-friendly interface while maintaining structured local data storage.

 Features

 User Authentication
- User registration
- User login
- Duplicate email validation
- Password confirmation validation
- User information stored locally using Room Database
- Persistent registered accounts
- Logout functionality

Book a Delivery
Users can create a delivery by providing:
- Pickup address
- Delivery address
- Recipient name
- Recipient phone number
- Delivery instructions
- Package type
- Package description
- Package weight

 Quote and Review
Before confirming a delivery, users can review:
- Pickup location
- Delivery location
- Recipient information
- Package information
- Delivery fee
- Estimated delivery time

 Delivery Confirmation
After confirming a delivery:
- A unique Arctic Move order number is generated
- Delivery information is stored in the local database
- A delivery confirmation screen is displayed
- A PIN is displayed for delivery verification

 My Orders
Users can view orders associated with their account.

Orders are loaded from the Room database and separated into:
- Active orders
- Previous/delivered orders

 Track Delivery
The application includes a delivery tracking interface for displaying delivery information and order status.

REST API integration is being developed to allow tracking information to be retrieved from an external Arctic Move API.

 Profile and Support
Users can:
- View account information
- Access support options
- Log out of the application

 Settings
A dedicated settings interface is included to provide application preferences and configuration options.



 REST API

Arctic Move includes a Retrofit networking layer for REST API communication.

The Android application currently defines support for the following API operations:

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/deliveries` | Retrieve deliveries |
| GET | `/deliveries/{orderId}` | Retrieve a delivery by order ID |
| POST | `/deliveries` | Create a new delivery |
| PUT | `/deliveries/{orderId}` | Update an existing delivery |

 API Components

The Android networking layer contains:

- `DeliveryApiModel.kt`
- `ArcticMoveApiService.kt`
- `RetrofitClient.kt`

The REST server and full Android-to-API integration are currently under development.



 Database

Arctic Move uses *Room Database* for local data persistence.

The database currently stores:

 Users
- Email
- Full name
- Phone number
- Password

 Deliveries
- Order ID
- User email
- Pickup address
- Delivery address
- Recipient information
- Package information
- Delivery fee
- Estimated delivery time
- Delivery status

Room DAOs are used to perform database operations such as inserting, retrieving and updating application data.

> Note: Password storage in the current application is intended for an academic prototype. A production application should use secure server-side authentication and appropriate password hashing rather than storing plaintext passwords locally.

---

 Technologies Used

- Kotlin
- Android Studio
- Jetpack Compose
- Material Design 3
- Room Database
- Navigation Compose
- Kotlin Coroutines
- Retrofit
- Gson Converter
- OkHttp
- Git
- GitHub

 
 Project Structure

text
com.example.arcticmove
│
├── api
│   ├── ArcticMoveApiService
│   ├── DeliveryApiModel
│   └── RetrofitClient
│
├── data
│   ├── ArcticMoveDatabase
│   ├── Delivery
│   ├── DeliveryDao
│   ├── DeliveryEntity
│   ├── DeliveryRepository
│   ├── User
│   ├── UserDao
│   ├── UserEntity
│   └── UserRepository
│
├── navigation
│   ├── AppNavigation
│   └── Screen
│
├── screens
│   ├── BookDeliveryScreen
│   ├── HomeScreen
│   ├── LoginScreen
│   ├── MyOrdersScreen
│   ├── PackageDetailsScreen
│   ├── PinVerificationScreen
│   ├── ProfileSupportScreen
│   ├── QuoteReviewScreen
│   ├── RecipientDetailsScreen
│   ├── RegisterScreen
│   ├── SettingsScreen
│   └── TrackDeliveryScreen
│
├── ui.theme
│
├── viewmodel
│   └── DeliveryViewModel
│
└── MainActivity
```

Delivery Workflow

text
Login / Register
       ↓
      Home
       ↓
Book a Delivery
       ↓
Recipient Details
       ↓
Package Details
       ↓
Quote & Review
       ↓
Delivery Confirmation
       ↓
      Home
       ↓
My Orders / Track Delivery
```

---

 Running the Application

 Requirements

- Android Studio
- Android SDK
- Android emulator or compatible Android device
- Internet connection for REST API functionality

 Steps

1. Clone the repository.
2. Open the project in Android Studio.
3. Allow Gradle to synchronize the project.
4. Select an Android emulator or connected device.
5. Build the project.
6. Run the application.

---

Testing

The application is tested during development using an Android emulator.

Current functional testing includes:

- Registration
- Login
- Duplicate account validation
- Account persistence
- Navigation
- Delivery booking
- Recipient details
- Package details
- Delivery confirmation
- Room database persistence
- My Orders retrieval
- Logout

Automated tests will be added to further verify important application functionality.



 Future Improvements

Planned improvements include:

- Complete REST API server
- Full Retrofit/API integration
- Dynamic delivery status updates
- Real-time driver tracking
- Secure server-side authentication
- Persistent application settings
- Dynamic delivery pricing
- Push notifications
- Improved automated test coverage

---

 Security Notice

Arctic Move is an academic prototype.

Production deployment would require additional security measures including secure authentication, encrypted network communication, server-side password hashing, authorization controls and secure handling of personal information.

---

 Developer

**Lethukuthula Dlomo**

Diploma in Software Development


Project Status

Development in progress

Core Android functionality, Room database persistence and the primary delivery workflow have been implemented. REST API development, API integration and automated testing are the next development stages.
