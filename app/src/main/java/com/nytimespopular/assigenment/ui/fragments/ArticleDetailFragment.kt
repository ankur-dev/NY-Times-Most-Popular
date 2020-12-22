package com.nytimespopular.assigenment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nytimespopular.assigenment.R
import com.nytimespopular.assigenment.databinding.FragmentArticleDetailBinding
import com.nytimespopular.assigenment.ui.viewModel.HomeViewModel
import com.nytimespopular.assigenment.util.CollectionUtils
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