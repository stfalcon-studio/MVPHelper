package com.stfalcon.mvphelpersample.common.di.builders

import android.app.Activity
import com.stfalcon.mvphelpersample.features.main.MainActivity
import com.stfalcon.mvphelpersample.features.main.MainActivitySubComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/*
 * Created by troy379 on 07.06.17.
 */
@Module
abstract class ActivitiesBuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(
            builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}