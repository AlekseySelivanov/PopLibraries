package com.example.poplibraries.mvp.model.repo

import com.example.poplibraries.mvp.model.api.IDataSource
import com.example.poplibraries.mvp.model.cache.IUsersCache
import com.example.poplibraries.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: IUsersCache
) : IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUsers().flatMap {
                    users ->
                cache.putUsers(users)
                    .andThen(
                        Single.just(users)
                    )
            }
        } else {
           cache.getUsers()
        }
    }.subscribeOn(Schedulers.io())

    override fun getUserByLogin(login: String) = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUser(login)
        } else {
            cache.getUser(login)
        }
    }.subscribeOn(Schedulers.io())
}