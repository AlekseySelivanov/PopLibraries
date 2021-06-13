package com.example.poplibraries.mvp.model.repo

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}