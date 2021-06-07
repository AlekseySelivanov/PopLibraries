package com.example.poplibraries.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplibraries.databinding.FragmentUsersBinding
import com.example.poplibraries.mvp.model.GithubUsersRepo
import com.example.poplibraries.mvp.presenter.UsersPresenter
import com.example.poplibraries.mvp.view.UsersView
import com.example.poplibraries.ui.App
import com.example.poplibraries.ui.BackButtonListener
import com.example.poplibraries.ui.adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment: MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    val presenter: UsersPresenter by moxyPresenter { UsersPresenter(
        GithubUsersRepo(),
        App.instance.router) }
    var adapter: UsersRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.rvUsers.adapter = adapter
    }
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
    override fun backPressed() = presenter.backPressed()
}