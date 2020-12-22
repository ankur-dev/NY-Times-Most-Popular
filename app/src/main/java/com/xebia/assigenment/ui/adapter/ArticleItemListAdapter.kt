package com.xebia.assigenment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.xebia.assigenment.R
import com.xebia.assigenment.data.model.ResultsItem
import com.xebia.assigenment.databinding.ListItemArticleBinding
import com.xebia.assigenment.ui.callbacks.IArticlesListSelectionCallback
import com.xebia.assigenment.util.CollectionUtils

class ArticleItemListAdapter constructor(
    var context: Context, var callback: IArticlesListSelectionCallback
) :
    RecyclerView.Adapter<ArticleItemListAdapter.ViewHolder>() {
    private var mItems = ArrayList<ResultsItem>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleItemListAdapter.ViewHolder {
        val binding: ListItemArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_article,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    fun updateData(items: List<ResultsItem>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ArticleItemListAdapter.ViewHolder, position: Int) {
        val item: ResultsItem = mItems[position]
        holder.binding.articleItem = item
        if (!CollectionUtils.isEmpty(item.media) && item.media?.get(0) != null &&
            !CollectionUtils.isEmpty(item.media!![0].mediaMetadata) && item.media!![0].mediaMetadata?.get(
                0
            ) != null
        ) {
            holder.binding.imgUrl = item.media!![0].mediaMetadata?.get(0)?.url ?: ""
        }

        holder.binding.rowView.setOnClickListener {
            callback.onItemClick(item)
        }

    }


    inner class ViewHolder(
        val binding: ListItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root)


}