package com.stfalcon.mvphelpersample.features.main

import com.stfalcon.mvphelpersample.common.di.factories.FragmentsInjectorFactories
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
 * Created by troy379 on 07.06.17.
 */
@Subcomponent(modules = arrayOf(MainActivityModule::class,
        FragmentsInjectorFactories::class))
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}