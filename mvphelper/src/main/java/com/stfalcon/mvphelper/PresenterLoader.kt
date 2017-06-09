package com.stfalcon.mvphelper

import android.content.Context
import android.support.v4.content.Loader

/*
 * Created by troy379 on 07.06.17.
 */
class PresenterLoader<PRESENTER : IPresenter<*>>(
        context: Context,
        val mPresenterFactory: PresenterFactory<PRESENTER>?
) : Loader<PRESENTER>(context) {

    private var mPresenter: PRESENTER? = null

    override fun onStartLoading() {
        if (mPresenter != null) {
            deliverResult(mPresenter)
            return
        }
        forceLoad()
    }

    override fun onForceLoad() {
        mPresenter = mPresenterFactory?.create()
        deliverResult(mPresenter)
    }

    override fun onReset() {
        mPresenter?.onDestroy()
        mPresenter = null
    }
}