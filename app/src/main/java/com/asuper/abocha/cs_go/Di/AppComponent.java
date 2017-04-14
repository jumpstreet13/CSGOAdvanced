package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.GalleryBigDetail.GalleryBigDetail;
import com.asuper.abocha.cs_go.SplashActivity;
import com.asuper.abocha.cs_go.Stream.StreamActivity;
import com.asuper.abocha.cs_go.VoiceRecordActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abakarmagomedov on 30.03.17.
 */


@Component(modules = {ManagersModule.class, UtilsModule.class, AppModule.class, MapperModule.class})
@Singleton
public interface AppComponent {

    PresenterComponent plusPresenterComponent(PresenterModule presenterModule, InteractorModule interactorModule);

    void inject(SplashActivity splashActivity);
    void inject(GalleryBigDetail bigDetail);
    void inject(VoiceRecordActivity voiceRecordActivity);
    void inject(StreamActivity streamActivity);
}
