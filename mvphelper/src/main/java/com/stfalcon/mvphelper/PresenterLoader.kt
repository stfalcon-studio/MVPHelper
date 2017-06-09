package com.stfalcon.mvphelper

import android.content.Context
import android.support.v4.content.Loader
import javax.inject.Inject

/*
 * Created by troy379 on 07.06.17.
 */
class PresenterLoader<PRESENTER : IPresenter<*>>
@Inject constructor(
        context: Context,
        var presenter: PRESENTER?)
    : Loader<PRESENTER>(context) {

    override fun onStartLoading() {
        deliverResult(presenter)
    }

    override fun onReset() {
        presenter?.onDestroy()
        presenter = null
    }
}