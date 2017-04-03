package com.asuper.abocha.cs_go.Di;

import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Map.MapInteractorInterface;
import com.asuper.abocha.cs_go.Map.MapPresenter;
import com.asuper.abocha.cs_go.Map.MapPresenterInterface;
import com.asuper.abocha.cs_go.MapDetail.MapDetailInteractor;
import com.asuper.abocha.cs_go.MapDetail.MapDetailPresenter;
import com.asuper.abocha.cs_go.MapDetail.MapDetailPresenterImp;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class PresenterModule {

    @Provides
    @ActivityScope
    MapPresenterInterface provideMapPresenter(MapInteractorInterface interactorInterface, Mapper<GameDtoMap,GameMap> mapper){
        return new MapPresenter(interactorInterface, mapper);
    }

    @Provides
    @ActivityScope
    MapDetailPresenter provideMapDetailPresenter(MapDetailInteractor interactor){
        return new MapDetailPresenterImp(interactor);
    }
}
