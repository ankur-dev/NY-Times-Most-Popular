package com.xebia.assigenment.di

import com.xebia.assigenment.data.repository.ArticleRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        ArticleRepository(get())
    }

}