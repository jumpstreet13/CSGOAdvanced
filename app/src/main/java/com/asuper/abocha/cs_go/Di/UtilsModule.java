package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Data.DaoSession;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.bumptech.glide.util.Util;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class UtilsModule {


    private DaoSession mDaoSession;

    public UtilsModule(DaoSession daoSession){
        mDaoSession = daoSession;
    }

    @Provides
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    GameDaoMapDao provideDao(){
        return mDaoSession.getGameDaoMapDao();
    }

}
