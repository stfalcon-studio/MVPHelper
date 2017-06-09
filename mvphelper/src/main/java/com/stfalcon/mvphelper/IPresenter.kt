package com.stfalcon.mvphelper

/*
 * Created by troy379 on 08.06.17.
 */
interface IPresenter<in VIEW> {
    fun onViewAttached(view: VIEW)
    fun onViewDetached()
    fun onDestroy()
}