package com.asuper.abocha.cs_go.MapDetail;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Listeners;
import com.asuper.abocha.cs_go.Managers.QueryManager;
import com.asuper.abocha.cs_go.Mapper.Mapper;

/**
 * Created by Abocha on 19.03.2017.
 */

public class MapDetailInteractorImp implements MapDetailInteractor {

    private QueryManager mQueryManager;
    private Mapper<GameDaoMap, GameDtoMap> mapper;

    public MapDetailInteractorImp(QueryManager queryManager, Mapper<GameDaoMap, GameDtoMap> mapper) {
        mQueryManager = queryManager;
        this.mapper = mapper;
    }

    @Override
    public void getTacticks(int id, Listeners.onQueryTacticImagesListener listener) {
        GameDaoMap gameDaoMapList = mQueryManager.getMapById(id);
        if(gameDaoMapList != null){
            listener.onSuccessTacticks(mapper.mapTo(gameDaoMapList).getSmokes());
        }else{
            listener.onError();
        }
    }

    @Override
    public void getMainImage(int id, Listeners.onQueryTacticImagesListener listener) {
        GameDaoMap gameDaoMapList = mQueryManager.getMapById(id);
        if(gameDaoMapList != null){
            listener.onSuccessMainImage(mapper.mapTo(gameDaoMapList).getImage());
        }else{
            listener.onError();
        }
    }
}
