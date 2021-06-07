package com.example.poplibraries.mvp.presenter

import com.example.poplibraries.mvp.view.UserView
import moxy.MvpPresenter

class UserPresenter(val userLogin: String):MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showUser(userLogin)
    }

}