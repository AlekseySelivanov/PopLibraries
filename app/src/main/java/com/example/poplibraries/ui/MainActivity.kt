package com.example.poplibraries.ui

import android.os.Bundle
import com.example.poplibraries.R
import com.example.poplibraries.databinding.ActivityMainBinding
import com.example.poplibraries.mvp.presenter.MainPresenter
import com.example.poplibraries.mvp.view.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    val navigatorHolder = App.instance.navigatorHolder
    val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)
    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClick()
    }
}