package com.stfalcon.mvphelpersample.features.main

import android.content.Context
import android.support.v4.app.FragmentManager
import com.stfalcon.mvphelper.PresenterLoader
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
    fun providePresenterLoader(context: Context, presenter: MainActivityPresenter)
            : PresenterLoader<MainActivityContract.Presenter> = PresenterLoader(context, presenter)
}