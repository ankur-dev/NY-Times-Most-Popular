package com.xebia.assigenment.data.repository

import com.xebia.assigenment.data.model.Response
import com.xebia.assigenment.data.network.ApiService
import io.reactivex.Observable

class ArticleRepository(var apiService: ApiService) {

    fun getArticleList(dayValue: Int,apiKey: String):
            Observable<Response> {
        return apiService.getArticleList(dayValue, apiKey)
    }
}