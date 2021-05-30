package com.example.poplibraries.mvp.presenter

import com.example.poplibraries.mvp.model.CountersModel
import com.example.poplibraries.mvp.view.MainView

class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counter1Click() {
        val nextValue = model.next(0)
        view.setButton1Text(nextValue.toString())
    }

    fun counter2Click() {
        val nextValue = model.next(1)
        view.setButton2Text(nextValue.toString())
    }

    fun counter3Click() {
        val nextValue = model.next(2)
        view.setButton3Text(nextValue.toString())
    }

}