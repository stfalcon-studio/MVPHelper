package com.stfalcon.mvphelpersample

import android.app.Activity
import android.app.Application
import com.stfalcon.mvphelpersample.common.di.components.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasDispatchingActivityInjector
import javax.inject.Inject

/*
 * Created by troy379 on 08.06.17.
 */
class App : Application(), HasDispatchingActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector;
    }
}