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

    public GameDaoMap getMapById(Long id){
        return mGameMapDao.queryBuilder()
                .where(GameDaoMapDao.Properties.Id.eq(id)) // TODO: 03.04.17 Add using QueryManager
                .unique();
    }

}
