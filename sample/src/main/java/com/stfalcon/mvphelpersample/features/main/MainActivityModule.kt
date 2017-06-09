package com.stfalcon.mvphelpersample.features.main

import android.support.v4.app.FragmentManager
import com.stfalcon.mvphelper.PresenterFactory
import dagger.Module
import dagger.Provides

/*
 * Created by troy379 on 07.06.17.
 */
@Module
class MainActivityModule {

    @Provides
    fun providesFragmentManager(activity: MainActivity)
            : FragmentManager = activity.supportFragmentManager

    @Provides
    fun provideView(mainActivity: MainActivity)
            : MainActivityContract.View = mainActivity

    @Provides
    fun providePresenterFactory(factory: MainActivityPresenter.Factory)
            : PresenterFactory<MainActivityContract.Presenter> = factory
}