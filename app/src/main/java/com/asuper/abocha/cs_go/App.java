package com.asuper.abocha.cs_go;

import android.app.Application;
import android.content.Context;

import com.asuper.abocha.cs_go.Data.DaoMaster;
import com.asuper.abocha.cs_go.Data.DaoSession;
import com.asuper.abocha.cs_go.Di.AppComponent;
import com.asuper.abocha.cs_go.Di.AppModule;
import com.asuper.abocha.cs_go.Di.DaggerAppComponent;
import com.asuper.abocha.cs_go.Di.UtilsModule;

import org.greenrobot.greendao.database.Database;



public class App extends Application {

    private DaoSession mDaoSession;
    private AppComponent component;


    @Override
    public void onCreate(){
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "cs-db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        buildComponent();
    }

    public AppComponent getComponent() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    void buildComponent() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilsModule(new UtilsModule(mDaoSession))
                .build();

    }



}
