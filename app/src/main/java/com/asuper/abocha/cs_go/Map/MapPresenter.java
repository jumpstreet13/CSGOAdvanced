package com.asuper.abocha.cs_go.Map;


import android.support.annotation.NonNull;

import com.asuper.abocha.cs_go.BasePresenterImp;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Listeners;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter extends BasePresenterImp<MapView, MapInteractorInterface> implements MapPresenterInterface, Listeners.onQueryMapsResultedListener{

    private Mapper<GameDtoMap,GameMap> mapper;

    public MapPresenter(@NonNull MapInteractorInterface interactor, Mapper<GameDtoMap,GameMap> mapper) {
        super(interactor);
        this.mapper = mapper;
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadData() {
        getInteractor().getMaps(this);
    }

    @Override
    public void onSuccess(List<GameDtoMap> maps) {
        ArrayList<GameMap> gameMaps = new ArrayList<>();
        for (GameDtoMap gameMap : maps) {
            gameMaps.add(mapper.mapTo(gameMap));
        }
        getView().fetchData(gameMaps);
    }

    @Override
    public void onError() {

    }
}
