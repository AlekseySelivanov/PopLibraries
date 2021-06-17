package com.example.poplibraries.mvp.view

interface UserItemView:IItemView {
    fun setLogin(text: String)
    fun loadImage(url: String, login:String)
}