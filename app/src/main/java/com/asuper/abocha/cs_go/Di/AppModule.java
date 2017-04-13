package com.asuper.abocha.cs_go.Di;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @NonNull
    @Provides
    @Singleton
    Context provideContext(){
        return application.getApplicationContext();
    }
}
