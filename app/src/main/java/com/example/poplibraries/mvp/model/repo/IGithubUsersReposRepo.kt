package com.example.poplibraries.mvp.model.repo

import com.example.poplibraries.mvp.model.entity.GitHubRepo
import io.reactivex.rxjava3.core.Single

interface IGithubUsersReposRepo {
    fun getReposByUrl(url:String?, login: String): Single<List<GitHubRepo>>
    fun getUserRepoByName(login: String, name: String): Single<GitHubRepo>
}