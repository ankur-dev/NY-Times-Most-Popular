package com.nytimespopular.assigenment


import com.nytimespopular.assigenment.data.model.Response
import com.nytimespopular.assigenment.data.network.ApiService
import io.reactivex.observers.TestObserver
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var articlesService: ApiService? = null
    var testObserver: TestObserver<Response> = TestObserver()
    var retrofit: Retrofit? = null


    var testUtils: TestUtills? = null

    @Before
    fun before() {
        testUtils = TestUtills()
        retrofit = testUtils?.buildRetrofit()
        articlesService = retrofit!!.create(ApiService::class.java)
    }

    @Test
    fun testResponse() {
        articlesService?.getArticleList(7, "SkaG6bWfLKboyDh9NXfCnIbGCZqFOvF1")
            ?.subscribe(testObserver)
        testObserver.assertValue { t ->
            val response: Response? = testUtils?.getArticles()
            t.copyright.equals(response?.copyright)
        }
    }


    @Test
    fun urlMatch_check() {
        assertEquals("https://api.nytimes.com/svc/mostpopular/v2/", BuildConfig.BASE_URL)
    }

    @Test
    fun apiSuccess_Test() {
        articlesService?.getArticleList(7, "SkaG6bWfLKboyDh9NXfCnIbGCZqFOvF1")?.subscribe({
                      assertTrue("OK" == it.status)

        },
            {

            })

    }

    @Test
    fun apiFailure_Test() {
        articlesService?.getArticleList(7, "")?.subscribe({
        },
            {
                assertTrue(true)
            })

    }

}
