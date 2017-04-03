package com.asuper.abocha.cs_go.Map;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Listeners;
import com.asuper.abocha.cs_go.Managers.QueryManager;
import com.asuper.abocha.cs_go.Mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abocha on 04.03.2017.
 */

public class MapInteractor implements MapInteractorInterface {

    private QueryManager mQueryManager;
    private Mapper<GameDaoMap, GameDtoMap>  mMapper;


    public MapInteractor(QueryManager queryManager, Mapper<GameDaoMap, GameDtoMap>  mMapper ) {
        mQueryManager = queryManager;
        this.mMapper = mMapper;
    }


    @Override
    public void getMaps(Listeners.onQueryMapsResultedListener listener) {
        List<GameDtoMap> maps = new ArrayList<>();
        for(GameDaoMap gmp : mQueryManager.getAllMaps()){
            maps.add(mMapper.mapTo(gmp));
        }
        if(!maps.isEmpty()){
            listener.onSuccess(maps);
        }else{
            listener.onError();
        }
        // TODO: 31.03.17 I need a list of elements
    }
}
