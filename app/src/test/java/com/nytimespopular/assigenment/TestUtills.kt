package com.nytimespopular.assigenment

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.nytimespopular.assigenment.data.model.Response
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TestUtills {
    var string = "{\n" +
            "  \"status\": \"OK\",\n" +
            "  \"copyright\": \"Copyright (c) 2020 The New York Times Company.  All Rights Reserved.\",\n" +
            "  \"num_results\": 20,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"uri\": \"nyt://article/d1c1b074-38a6-5896-a565-eca519420309\",\n" +
            "      \"url\": \"https://www.nytimes.com/2020/12/13/world/americas/miriam-rodriguez-san-fernando.html\",\n" +
            "      \"id\": 100000007480884,\n" +
            "      \"asset_id\": 100000007480884,\n" +
            "      \"source\": \"New York Times\",\n" +
            "      \"published_date\": \"2020-12-13\",\n" +
            "      \"updated\": \"2020-12-15 08:49:35\",\n" +
            "      \"section\": \"World\",\n" +
            "      \"subsection\": \"Americas\",\n" +
            "      \"nytdsection\": \"world\",\n" +
            "      \"adx_keywords\": \"Drug Cartels;Kidnapping and Hostages;Murders, Attempted Murders and Homicides;Extortion and Blackmail;Organized Crime;Politics and Government;Content Type: Personal Profile;Rodriguez Martinez, Miriam Elizabeth;Leal Garza, Luciano;San Fernando (Tamaulipas, Mexico);Mexico\",\n" +
            "      \"column\": null,\n" +
            "      \"byline\": \"By Azam Ahmed\",\n" +
            "      \"type\": \"Article\",\n" +
            "      \"title\": \"She Stalked Her Daughter’s Killers Across Mexico, One by One\",\n" +
            "      \"abstract\": \"Armed with a handgun, a fake ID card and disguises, Miriam Rodríguez was a one-woman detective squad, defying a system where criminal impunity often prevails.\",\n" +
            "      \"des_facet\": [\n" +
            "        \"Drug Cartels\",\n" +
            "        \"Kidnapping and Hostages\",\n" +
            "        \"Murders, Attempted Murders and Homicides\",\n" +
            "        \"Extortion and Blackmail\",\n" +
            "        \"Organized Crime\",\n" +
            "        \"Politics and Government\",\n" +
            "        \"Content Type: Personal Profile\"\n" +
            "      ],\n" +
            "      \"org_facet\": [],\n" +
            "      \"per_facet\": [\n" +
            "        \"Rodriguez Martinez, Miriam Elizabeth\",\n" +
            "        \"Leal Garza, Luciano\"\n" +
            "      ],\n" +
            "      \"geo_facet\": [\n" +
            "        \"San Fernando (Tamaulipas, Mexico)\",\n" +
            "        \"Mexico\"\n" +
            "      ],\n" +
            "      \"media\": [],\n" +
            "      \"eta_id\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"uri\": \"nyt://article/8e44673d-5d3d-5646-838d-8db7d1f8af13\",\n" +
            "      \"url\": \"https://www.nytimes.com/2020/12/13/us/politics/trump-allies-election-overturn-congress-pence.html\",\n" +
            "      \"id\": 100000007497420,\n" +
            "      \"asset_id\": 100000007497420,\n" +
            "      \"source\": \"New York Times\",\n" +
            "      \"published_date\": \"2020-12-13\",\n" +
            "      \"updated\": \"2020-12-14 19:29:53\",\n" +
            "      \"section\": \"U.S.\",\n" +
            "      \"subsection\": \"Politics\",\n" +
            "      \"nytdsection\": \"u.s.\",\n" +
            "      \"adx_keywords\": \"Presidential Election of 2020;Biden, Joseph R Jr;Trump, Donald J;Pence, Mike;Democratic Party;Republican Party;House of Representatives\",\n" +
            "      \"column\": null,\n" +
            "      \"byline\": \"By Nicholas Fandos and Michael S. Schmidt\",\n" +
            "      \"type\": \"Article\",\n" +
            "      \"title\": \"Trump Allies Eye Long-Shot Election Reversal in Congress, Testing Pence\",\n" +
            "      \"abstract\": \"Some House Republicans plan to try to use Congress’s tallying of electoral results on Jan. 6 to tip the election to President Trump. The attempt will put Republicans in a pinch.\",\n" +
            "      \"des_facet\": [\n" +
            "        \"Presidential Election of 2020\"\n" +
            "      ],\n" +
            "      \"org_facet\": [\n" +
            "        \"Democratic Party\",\n" +
            "        \"Republican Party\",\n" +
            "        \"House of Representatives\"\n" +
            "      ],\n" +
            "      \"per_facet\": [\n" +
            "        \"Biden, Joseph R Jr\",\n" +
            "        \"Trump, Donald J\",\n" +
            "        \"Pence, Mike\"\n" +
            "      ],\n" +
            "      \"geo_facet\": [],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"type\": \"image\",\n" +
            "          \"subtype\": \"photo\",\n" +
            "          \"caption\": \"The ensuing fight promises to shape how President Trump’s base views the election for years to come.\",\n" +
            "          \"copyright\": \"Stefani Reynolds for The New York Times\",\n" +
            "          \"approved_for_syndication\": 1,\n" +
            "          \"media-metadata\": [\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/12/12/us/politics/13dc-overturn-1/merlin_181149501_545a5a52-9c27-44f3-891f-1caf1453f16a-thumbStandard.jpg\",\n" +
            "              \"format\": \"Standard Thumbnail\",\n" +
            "              \"height\": 75,\n" +
            "              \"width\": 75\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/12/12/us/politics/13dc-overturn-1/merlin_181149501_545a5a52-9c27-44f3-891f-1caf1453f16a-mediumThreeByTwo210.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo210\",\n" +
            "              \"height\": 140,\n" +
            "              \"width\": 210\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/12/12/us/politics/13dc-overturn-1/merlin_181149501_545a5a52-9c27-44f3-891f-1caf1453f16a-mediumThreeByTwo440.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo440\",\n" +
            "              \"height\": 293,\n" +
            "              \"width\": 440\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"eta_id\": 0\n" +
            "    }\n" +
            "  ]\n" +
            "}"


    fun getArticles(): Response? {
        return ParseUtil.getObject(string, Response::class.java)
    }


    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    fun buildRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient())
            .build()
    }

}