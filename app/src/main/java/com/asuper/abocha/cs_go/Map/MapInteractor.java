package com.asuper.abocha.cs_go.Map;

import com.asuper.abocha.cs_go.Data.DaoSession;
import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abocha on 04.03.2017.
 */

public class MapInteractor implements MapInteractorInterface {

    private DaoSession session;
    private Mapper<GameDaoMap, GameDtoMap>  mMapper;


    public MapInteractor(DaoSession session, Mapper<GameDaoMap, GameDtoMap>  mMapper ) {
        this.session = session;
        this.mMapper = mMapper;
    }


    @Override
    public void getMaps(onQueryMapsResultedListener listener) {
        List<GameDtoMap> maps = new ArrayList<>();
        for(GameDaoMap gmp : session.getGameDaoMapDao().loadAll()){
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
