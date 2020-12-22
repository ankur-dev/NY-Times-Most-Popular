package com.xebia.assigenment.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel()
{
    private val compositeDisposable = CompositeDisposable()


//    fun getCompositeDisposable(): CompositeDisposable? {
//        return compositeDisposable
//    }

    protected fun addToDisposable(disposable: Disposable?) {
        compositeDisposable.add(disposable!!)
    }

    fun onStop() {
        compositeDisposable.dispose()
    }



}