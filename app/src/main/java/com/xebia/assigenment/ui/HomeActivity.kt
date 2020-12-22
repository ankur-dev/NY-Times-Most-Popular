package com.xebia.assigenment.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xebia.assigenment.R
import com.xebia.assigenment.data.network.Task
import com.xebia.assigenment.databinding.ActivityHomeBinding
import com.xebia.assigenment.ui.callbacks.IFragmentToActivityCallback
import com.xebia.assigenment.ui.fragments.ArticleDetailFragment
import com.xebia.assigenment.ui.fragments.ArticlesListFragment
import com.xebia.assigenment.ui.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), IFragmentToActivityCallback {
    private lateinit var mBinding: ActivityHomeBinding
    private lateinit var mToolbar: Toolbar
    private val mViewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setupToolbar()

        openFragment(Task.ARTICLE_LIST_FRAGMENT)
    }

    private fun setupToolbar() {
        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
    }


    private fun openFragment(id: Task) {
        lateinit var fragment: Fragment
        if (id == Task.ARTICLE_LIST_FRAGMENT) {
            fragment = ArticlesListFragment.newInstance(true)
        } else if (id == Task.DETAIL_FRAGMENT) {
            fragment = ArticleDetailFragment.newInstance()
            hideToolbar()
        }
        try {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(id.name).replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    override fun openDetailPage() {
        openFragment(Task.DETAIL_FRAGMENT)
    }

    private fun showToolbar() {
        mToolbar.visibility = View.VISIBLE
    }

    private fun hideToolbar() {
        mToolbar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.day_type_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        when (item.itemId) {
            R.id.oneDay -> {
                if (fragment is ArticlesListFragment) {
                    fragment.getDataFromServer(1)
                }
            }
            R.id.sevenDay -> {
                if (fragment is ArticlesListFragment) {
                    fragment.getDataFromServer(7)
                }
            }
            R.id.thirtyDay -> {
                if (fragment is ArticlesListFragment) {
                    fragment.getDataFromServer(30)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
            showToolbar()
        } else {
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
     //   mViewModel.onStop()
    }
}