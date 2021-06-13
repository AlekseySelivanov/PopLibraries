package com.example.poplibraries.mvp.model.repo

import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String): Single<GithubUser>
    fun getReposByUrl(url: String): Single<List<GitHubRepo>>
    fun getUserRepoByName(login: String, name: String): Single<GitHubRepo>
}