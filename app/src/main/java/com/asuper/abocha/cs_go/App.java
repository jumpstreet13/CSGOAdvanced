package com.asuper.abocha.cs_go;

import android.app.Application;
import android.content.Context;

import com.asuper.abocha.cs_go.Model.DaoMaster;
import com.asuper.abocha.cs_go.Model.DaoSession;

import org.greenrobot.greendao.database.Database;


public class App extends Application {

    private DaoSession mDaoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "cs-db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }


    public DaoSession getDaoSession(){
        return mDaoSession;
    }

}
