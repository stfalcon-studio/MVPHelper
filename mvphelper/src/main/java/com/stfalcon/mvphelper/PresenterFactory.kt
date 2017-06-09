package com.stfalcon.mvphelper

/*
 * Created by troy379 on 08.06.17.
 */
interface PresenterFactory<PRESENTER : IPresenter<*>> {
    fun create(): PRESENTER
}