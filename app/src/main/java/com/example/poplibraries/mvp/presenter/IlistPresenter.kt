package com.example.poplibraries.mvp.presenter

import com.example.poplibraries.mvp.view.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener:((V) -> Unit)?
    fun bindView(view:V)
    fun getCount():Int
}