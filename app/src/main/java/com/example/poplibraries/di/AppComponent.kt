package com.example.poplibraries.di

import com.example.poplibraries.di.modules.*
import com.example.poplibraries.mvp.presenter.MainPresenter
import com.example.poplibraries.mvp.presenter.RepoPresenter
import com.example.poplibraries.mvp.presenter.UserPresenter
import com.example.poplibraries.mvp.presenter.UsersPresenter
import com.example.poplibraries.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        NavigationModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)
    fun inject(mainActivity: MainActivity)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userPresenter: UserPresenter)
    fun inject(repoPresenter: RepoPresenter)
}