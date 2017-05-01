package com.asuper.abocha.cs_go.Managers;


import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;

import java.util.List;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

public class QueryManager {

    private GameDaoMapDao mGameMapDao;

    public QueryManager(GameDaoMapDao gameMapDao) {
        mGameMapDao = gameMapDao;
    }

    public List<GameDaoMap> getAllMaps(){
        return mGameMapDao.loadAll();
    }

    public GameDaoMap getMapById(int id){
        return mGameMapDao.queryBuilder()
                .where(GameDaoMapDao.Properties.IdForSearch.eq(id))
                .unique();
    }

}
