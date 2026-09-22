package com.example.arcticmove.data

import android.content.Context

object UserRepository {

    // =========================================
    // ROOM DATABASE
    // =========================================

    private lateinit var userDao: UserDao


    // =========================================
    // CURRENT LOGGED-IN USER
    // =========================================

    private var currentUser: User? = null


    // =========================================
    // INITIALIZE DATABASE
    // =========================================

    fun initialize(context: Context) {

        val database =
            ArcticMoveDatabase.getDatabase(context)

        userDao = database.userDao()
    }


    // =========================================
    // REGISTER USER
    // =========================================

    suspend fun registerUser(user: User) {

        val userEntity = UserEntity(
            email = user.email.trim(),
            fullName = user.fullName,
            phoneNumber = user.phoneNumber,
            password = user.password
        )

        userDao.insertUser(userEntity)
    }


    // =========================================
    // LOGIN USER
    // =========================================

    suspend fun loginUser(
        email: String,
        password: String
    ): Boolean {

        val foundUser = userDao.loginUser(
            email = email.trim(),
            password = password
        )

        return if (foundUser != null) {

            currentUser = User(
                fullName = foundUser.fullName,
                email = foundUser.email,
                phoneNumber = foundUser.phoneNumber,
                password = foundUser.password
            )

            true

        } else {

            currentUser = null

            false
        }
    }


    // =========================================
    // CHECK IF EMAIL ALREADY EXISTS
    // =========================================

    suspend fun emailExists(email: String): Boolean {

        return userDao.emailExists(
            email.trim()
        )
    }


    // =========================================
    // GET CURRENT LOGGED-IN USER
    // =========================================

    fun getCurrentUser(): User? {

        return currentUser
    }


    // =========================================
    // LOG OUT USER
    // =========================================

    fun logoutUser() {

        currentUser = null
    }
}