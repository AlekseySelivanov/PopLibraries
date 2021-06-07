package com.example.poplibraries.navigation

import com.example.poplibraries.ui.fragment.UserFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class UserScreen(private val userLogin:String) : SupportAppScreen() {
    override fun getFragment() = UserFragment.newInstance(userLogin)
}