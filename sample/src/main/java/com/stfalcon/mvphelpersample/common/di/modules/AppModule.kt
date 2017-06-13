package com.stfalcon.mvphelpersample.common.di.modules

import android.content.Context
import com.stfalcon.mvphelpersample.App
import com.stfalcon.mvphelpersample.features.main.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by troy379 on 07.06.17.
 */
@Module(subcomponents = arrayOf(
        MainActivitySubComponent::class
))
class AppModule {

    @Singleton
    @Provides
    internal fun provideContext(application: App): Context = application.applicationContext

}