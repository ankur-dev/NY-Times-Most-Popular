package com.nytimespopular.assigenment.data.network

import com.nytimespopular.assigenment.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("viewed/{period}.json")
    fun getArticleList(@Path("period") period:Int, @Query("api-key") apiKey:String): Observable<Response>

}