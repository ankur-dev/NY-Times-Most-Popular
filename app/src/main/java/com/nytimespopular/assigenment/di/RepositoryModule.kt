package com.nytimespopular.assigenment.di

import com.nytimespopular.assigenment.data.repository.ArticleRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        ArticleRepository(get())
    }

}