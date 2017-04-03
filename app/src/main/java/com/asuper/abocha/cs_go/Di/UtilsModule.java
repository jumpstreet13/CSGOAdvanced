package com.asuper.abocha.cs_go.Di;

import android.content.Context;

import com.asuper.abocha.cs_go.Data.DaoMaster;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.google.gson.Gson;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class UtilsModule {



    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    GameDaoMapDao provideDao(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "cs-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession().getGameDaoMapDao();
    }

}
