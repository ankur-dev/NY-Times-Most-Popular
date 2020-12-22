package com.nytimespopular.assigenment.data.repository

import com.nytimespopular.assigenment.data.model.Response
import com.nytimespopular.assigenment.data.network.ApiService
import io.reactivex.Observable

class ArticleRepository(var apiService: ApiService) {

    fun getArticleList(dayValue: Int,apiKey: String):
            Observable<Response> {
        return apiService.getArticleList(dayValue, apiKey)
    }
}