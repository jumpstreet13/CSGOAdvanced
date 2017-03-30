package com.asuper.abocha.cs_go.Di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

@Singleton
@Component(modules = {ManagersModule.class,})
public interface AppComponent {
}
