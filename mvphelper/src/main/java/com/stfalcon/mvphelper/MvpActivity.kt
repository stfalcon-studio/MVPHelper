package com.stfalcon.mvphelper

import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import dagger.android.support.DaggerAppCompatActivity
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/*
 * Created by troy379 on 07.06.17.
 */
abstract class MvpActivity<PRESENTER : IPresenter<VIEW>, VIEW> : DaggerAppCompatActivity(),
        LoaderManager.LoaderCallbacks<PRESENTER> {

    protected abstract fun getLayoutResId(): Int

    @Inject lateinit var presenterFactory: PresenterFactory<PRESENTER>
    protected var presenter: PRESENTER? = null
    private var firstStart: Boolean = false
    private val needToCallStart = AtomicBoolean(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        parseIntent()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        firstStart = true
        supportLoaderManager.initLoader(0, Bundle.EMPTY, this).startLoading()
    }

    override fun onStart() {
        super.onStart()
        if (presenter == null) needToCallStart.set(true)
        else doStart()
    }

    override fun onStop() {
        if (presenter != null) presenter?.onViewDetached()
        super.onStop()
    }

    override fun onCreateLoader(id: Int, args: Bundle): Loader<PRESENTER>
            = PresenterLoader(this, presenterFactory)

    override fun onLoadFinished(loader: Loader<PRESENTER>, presenter: PRESENTER) {
        this.presenter = presenter
        if (needToCallStart.compareAndSet(true, false)) {
            doStart()
        }
    }

    override fun onLoaderReset(loader: Loader<PRESENTER>) {
        presenter = null
    }

    protected fun parseIntent() {
        //do nothing
    }

    @Suppress("UNCHECKED_CAST")
    private fun doStart() {
        presenter?.onViewAttached(this as VIEW)
        firstStart = false
    }
}