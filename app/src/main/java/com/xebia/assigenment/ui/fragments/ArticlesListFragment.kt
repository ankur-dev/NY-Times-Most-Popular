package com.xebia.assigenment.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.xebia.assigenment.R
import com.xebia.assigenment.base.BaseFragment
import com.xebia.assigenment.data.model.ResultsItem
import com.xebia.assigenment.data.network.EventTask
import com.xebia.assigenment.data.network.Status
import com.xebia.assigenment.data.network.Task
import com.xebia.assigenment.databinding.FragmentArticlesListBinding
import com.xebia.assigenment.ui.adapter.ArticleItemListAdapter
import com.xebia.assigenment.ui.callbacks.IArticlesListSelectionCallback
import com.xebia.assigenment.ui.callbacks.IFragmentToActivityCallback
import com.xebia.assigenment.ui.viewModel.HomeViewModel
import com.xebia.assigenment.util.CollectionUtils
import com.xebia.assigenment.util.Utils
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ArticlesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticlesListFragment : BaseFragment() {
    private lateinit var mBinding: FragmentArticlesListBinding
    private val mViewModel: HomeViewModel by sharedViewModel()
    private lateinit var mAdapter: ArticleItemListAdapter
    private lateinit var mListener: IFragmentToActivityCallback
    private var isFirstTime: Boolean? = null
    private val ARG_PARAM1 = "ARG_PARAM1"


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as IFragmentToActivityCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isFirstTime = it.getBoolean(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_articles_list, container, false)

        initRecycelerView()

        initViewModelObserver()

        // default listing is 7 days
        if (isFirstTime == true) {
            getDataFromServer(7)
            isFirstTime = false
        }
        return mBinding.root
    }

    fun getDataFromServer(day: Int) {
        mViewModel.getArticleList(day)
    }

    private fun initViewModelObserver() {
        mViewModel.articleListResponse.observe(viewLifecycleOwner, Observer {
            parseData(it)
        })
    }

    private fun parseData(it: EventTask<Any>) {
        when (it.status) {
            Status.ERROR -> {
                mBinding.isLoading = false
                Utils.showToast(it.msg ?: "", activity)
            }
            Status.LOADING -> mBinding.isLoading = true

            Status.SUCCESS -> {
                if (it.task == Task.GET_ARTICLE_LIST) {
                    val data = it.data as ArrayList<ResultsItem>
                    if (!CollectionUtils.isEmpty(data)) mAdapter.updateData(data)
                }
                mBinding.isLoading = false
            }

            else -> {}
        }
    }

    private fun initRecycelerView() {
        mAdapter =
            ArticleItemListAdapter(requireActivity(), object : IArticlesListSelectionCallback {
                override fun onItemClick(item: ResultsItem) {
                    mViewModel.selectedArticleItem = item
                    mListener.openDetailPage()
                }

            })

        mBinding.adapter = mAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance(isForFirstTime: Boolean) =
            ArticlesListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, isForFirstTime)
                }
            }
    }

}