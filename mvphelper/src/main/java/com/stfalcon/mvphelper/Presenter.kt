package com.stfalcon.mvphelper

import io.reactivex.disposables.CompositeDisposable

/*
 * Created by troy379 on 08.06.17.
 */
abstract class Presenter<VIEW> : IPresenter<VIEW> {

    protected var view: VIEW? = null
    protected val disposables = CompositeDisposable()

    override fun onViewAttached(view: VIEW, created: Boolean) {
        this.view = view
    }

    override fun onViewDetached() {
        this.view = null
    }

    override fun onDestroy() = disposables.clear()
}