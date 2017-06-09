package com.stfalcon.mvphelpersample.features.main

import com.stfalcon.mvphelper.IPresenter

/*
 * Created by troy379 on 07.06.17.
 */
class MainActivityContract {

    interface View {
        fun showLoading(show: Boolean)
        fun showData(data: String)
    }

    interface Presenter : IPresenter<View> {
        fun loadData()
    }
}