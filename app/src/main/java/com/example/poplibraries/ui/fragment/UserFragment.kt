package com.example.poplibraries.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplibraries.databinding.FragmentUserBinding
import com.example.poplibraries.mvp.model.api.ApiHolder
import com.example.poplibraries.mvp.model.cache.RoomUsersCache
import com.example.poplibraries.mvp.model.cache.RoomUsersReposCache
import com.example.poplibraries.mvp.model.repo.RetrofitGithubReposRepo
import com.example.poplibraries.mvp.model.repo.RetrofitGithubUsersRepo
import com.example.poplibraries.mvp.presenter.UserPresenter
import com.example.poplibraries.mvp.view.UserView
import com.example.poplibraries.ui.App
import com.example.poplibraries.ui.adapter.ReposRVAdapter
import com.example.poplibraries.ui.network.AndroidNetworkStatus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class UserFragment : MvpAppCompatFragment(), UserView {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val userLogin by lazy {
        arguments?.getString(ARG_USER_LOGIN) ?: ""
    }
    private val presenter by moxyPresenter {
        UserPresenter(
            userLogin, AndroidSchedulers.mainThread(),
            RetrofitGithubUsersRepo(ApiHolder.api, AndroidNetworkStatus(requireContext()), RoomUsersCache()),
            RetrofitGithubReposRepo(ApiHolder.api, AndroidNetworkStatus(requireContext()), RoomUsersReposCache()),
            App.instance.router
        )
    }

    var adapter: ReposRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_USER_LOGIN = "USER_LOGIN"
        fun newInstance(userLogin: String) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userLogin)
                }
            }
    }

    override fun showUserLogin(login: String) {
        binding.userLogin.text = login
    }
    override fun showUserId(id: String) {
        binding.userId.text = id
    }
    override fun showUserRepoUrl(userRepoUrl: String) {
        binding.userRepoText.text = userRepoUrl
    }
    override fun showError(error: String?) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }

    override fun init() {
        binding.rvRepos.layoutManager = LinearLayoutManager(context)
        adapter = ReposRVAdapter(presenter.reposListPresenter)
        binding.rvRepos.adapter = adapter
    }

    override fun updateReposList() {
        adapter?.notifyDataSetChanged()
    }

}