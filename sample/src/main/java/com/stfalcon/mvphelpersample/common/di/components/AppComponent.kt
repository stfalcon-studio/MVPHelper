package com.stfalcon.mvphelpersample.common.di.components

import com.stfalcon.mvphelpersample.App
import com.stfalcon.mvphelpersample.common.di.factories.ActivitiesInjectorFactories
import com.stfalcon.mvphelpersample.common.di.factories.FragmentsInjectorFactories
import com.stfalcon.mvphelpersample.common.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
 * Created by troy379 on 07.06.17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivitiesInjectorFactories::class,
        FragmentsInjectorFactories::class,
        AppModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

}