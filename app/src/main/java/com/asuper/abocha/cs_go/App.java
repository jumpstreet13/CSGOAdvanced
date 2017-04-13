package com.asuper.abocha.cs_go;

import android.app.Application;
import android.content.Context;

import com.asuper.abocha.cs_go.Di.AppComponent;
import com.asuper.abocha.cs_go.Di.AppModule;
import com.asuper.abocha.cs_go.Di.DaggerAppComponent;
import com.asuper.abocha.cs_go.Di.InteractorModule;
import com.asuper.abocha.cs_go.Di.ManagersModule;
import com.asuper.abocha.cs_go.Di.MapperModule;
import com.asuper.abocha.cs_go.Di.PresenterComponent;
import com.asuper.abocha.cs_go.Di.PresenterModule;
import com.asuper.abocha.cs_go.Di.UtilsModule;


public class App extends Application {

    private PresenterComponent mPresenterComponent;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
    }

    public PresenterComponent plusPresenterComponent() {
        if (mPresenterComponent == null) {
            mPresenterComponent = component.plusPresenterComponent(new PresenterModule(), new InteractorModule());
        }
        return mPresenterComponent;
    }

    public void clearPresenterComponent() {
        mPresenterComponent = null;
    }

    public AppComponent getComponent() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    void buildComponent() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilsModule(new UtilsModule())
                .managersModule(new ManagersModule())
                .mapperModule(new MapperModule())
                .build();
    }

}
