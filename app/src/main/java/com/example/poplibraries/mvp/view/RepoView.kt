package com.example.poplibraries.mvp.view


import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface RepoView : MvpView {
    fun showRepoId(id: String)
    fun showRepoName(name: String)
    fun showRepoDescription(description: String)
    fun showRepoForksCount(forksCount: String)
    fun showError(message: String?)
}