package com.example.poplibraries.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, login:String, container: T)
}