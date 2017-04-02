package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Managers.GsonManager;
import com.asuper.abocha.cs_go.Managers.QueryManager;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

@Module
public class ManagersModule {

    @Singleton
    @Provides
    QueryManager provideQueryManager(GameDaoMapDao gameDaoMap){
        return new QueryManager(gameDaoMap);
    }

    @Singleton
    @Provides
    GsonManager provideGsonManger(Gson gson){
        return new GsonManager(gson);
    }

}
