package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Data.DaoSession;
import com.asuper.abocha.cs_go.Map.MapInteractor;
import com.asuper.abocha.cs_go.Map.MapInteractorInterface;
import com.asuper.abocha.cs_go.Mapper.Mapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */


@Module
public class InteractorModule {

    @Provides
    MapInteractorInterface provideMapInteractor(DaoSession session, Mapper mapper){
        return new MapInteractor(session, mapper);
    }

}
