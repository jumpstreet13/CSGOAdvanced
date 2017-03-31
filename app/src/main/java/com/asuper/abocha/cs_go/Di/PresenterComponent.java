package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Map.MapActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@ActivityScope
@Subcomponent(modules = {PresenterModule.class, InteractorModule.class})
public interface PresenterComponent {
    void inject(MapActivity mapActivity);
}
