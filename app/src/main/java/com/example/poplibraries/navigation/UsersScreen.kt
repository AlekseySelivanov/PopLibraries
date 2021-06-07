package com.example.poplibraries.navigation

import com.example.poplibraries.ui.fragment.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class UsersScreen() : SupportAppScreen() {
    override fun getFragment() = UsersFragment.newInstance()
}