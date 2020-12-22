package com.xebia.assigenment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xebia.assigenment.R
import com.xebia.assigenment.databinding.FragmentArticleDetailBinding
import com.xebia.assigenment.ui.viewModel.HomeViewModel
import com.xebia.assigenment.util.CollectionUtils
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ArticleDetailFragment : Fragment() {
    private val mViewModel: HomeViewModel by sharedViewModel()
    private lateinit var mBinding: FragmentArticleDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_article_detail, container, false)
        val item = mViewModel.selectedArticleItem
        mBinding.item = item


        if (!CollectionUtils.isEmpty(item?.media) && item?.media?.get(0) != null &&
            !CollectionUtils.isEmpty(item.media!![0].mediaMetadata) && item.media!![0].mediaMetadata?.get(
                0
            ) != null
        ) {
            mBinding.imageUrl = item.media!![0].mediaMetadata?.get(0)?.url ?: ""
        }


        return mBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ArticleDetailFragment().apply {

            }
    }
}