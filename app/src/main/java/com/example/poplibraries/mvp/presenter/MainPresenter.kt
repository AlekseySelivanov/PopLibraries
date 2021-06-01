package com.example.poplibraries.mvp.presenter

import com.example.poplibraries.mvp.view.MainView
import com.example.poplibraries.navigation.UsersScreen
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen())
    }

    fun backClick() {
        router.exit()
    }


}