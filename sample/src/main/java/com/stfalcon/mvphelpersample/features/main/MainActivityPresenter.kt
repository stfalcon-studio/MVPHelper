package com.stfalcon.mvphelpersample.features.main

import android.os.Handler
import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/*
 * Created by troy379 on 07.06.17.
 */
class MainActivityPresenter @Inject constructor()
    : Presenter<MainActivityContract.View>(), MainActivityContract.Presenter {

    var loading: Boolean = false
    var loaded: Boolean = false

    override fun onViewAttached(view: MainActivityContract.View, created: Boolean) {
        super.onViewAttached(view, created)
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
}