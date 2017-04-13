package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Map.MapActivity;
import com.asuper.abocha.cs_go.MapDetail.MapDetailActivity;
import com.asuper.abocha.cs_go.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Subcomponent(modules = {PresenterModule.class, InteractorModule.class})
@ActivityScope
public interface PresenterComponent {
    void inject(MapActivity mapActivity);

    void inject(SplashActivity splashActivity);

    void inject(MapDetailActivity mapDetail);
}
