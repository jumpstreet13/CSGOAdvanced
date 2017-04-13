package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Mapper.GameDaoMapper;
import com.asuper.abocha.cs_go.Mapper.GameMapMapper;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class MapperModule {

    @Singleton
    @Provides
    Mapper<GameDaoMap, GameDtoMap> provideGameDaoMapper() {
        return new GameDaoMapper();
    }

    @Singleton
    @Provides
    Mapper<GameDtoMap, GameMap> provideGameMapMapper() {
        return new GameMapMapper();
    }

}
