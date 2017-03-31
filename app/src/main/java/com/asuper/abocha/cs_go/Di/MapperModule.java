package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Mapper.GameDaoMapper;
import com.asuper.abocha.cs_go.Mapper.GameMapMapper;
import com.asuper.abocha.cs_go.Mapper.Mapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class MapperModule {

    @Provides
    GameDaoMapper provideGameDaoMapper(){
        return new GameDaoMapper();
    }

    @Provides
    GameMapMapper provideGameMapMapper(){
        return new GameMapMapper();
    }

}
