package com.example.poplibraries.mvp.model.cache

import com.example.poplibraries.mvp.model.entity.GitHubRepo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IUsersReposCache {
    fun putRepos(login:String, repos:List<GitHubRepo>): Completable
    fun getRepos(login:String): Single<List<GitHubRepo>>
}