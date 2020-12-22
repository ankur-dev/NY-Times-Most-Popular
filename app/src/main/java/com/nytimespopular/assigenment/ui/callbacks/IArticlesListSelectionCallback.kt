package com.nytimespopular.assigenment.ui.callbacks

import com.nytimespopular.assigenment.data.model.ResultsItem

interface IArticlesListSelectionCallback {

    fun onItemClick(item: ResultsItem)

}