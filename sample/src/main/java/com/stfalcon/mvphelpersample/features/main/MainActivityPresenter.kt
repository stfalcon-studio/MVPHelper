package com.stfalcon.mvphelpersample.features.main

import android.os.Handler
import com.stfalcon.mvphelper.Presenter
import com.stfalcon.mvphelper.PresenterFactory
import javax.inject.Inject

/*
 * Created by troy379 on 07.06.17.
 */
class MainActivityPresenter
    : Presenter<MainActivityContract.View>(), MainActivityContract.Presenter {

    var loading: Boolean = false
    var loaded: Boolean = false

    override fun onViewAttached(view: MainActivityContract.View) {
        super.onViewAttached(view)
        view.showLoading(loading)
        loadData()
    }

    override fun loadData() {
        if (!loading && !loaded) {
            changeLoadingState(true)

            Handler().postDelayed({
                view?.showData("Here is some data!")
                changeLoadingState(false)
            }, 10000)
        }
    }

    fun changeLoadingState(loading: Boolean) {
        this.view?.showLoading(loading)
        this.loading = loading
        this.loaded = !loading
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    class Factory @Inject constructor() : PresenterFactory<MainActivityContract.Presenter> {

        override fun create(): MainActivityPresenter = MainActivityPresenter()
    }
}