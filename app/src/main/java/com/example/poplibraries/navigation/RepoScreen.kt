package com.example.poplibraries.navigation


import com.example.poplibraries.ui.fragment.RepoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class RepoScreen(private val userLogin: String, private val repoName: String) : SupportAppScreen() {
    override fun getFragment() = RepoFragment.newInstance(userLogin, repoName)
}