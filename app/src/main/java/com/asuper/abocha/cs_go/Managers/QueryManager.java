package com.asuper.abocha.cs_go.Managers;


import com.asuper.abocha.cs_go.Data.GameDaoMapDao;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

public class QueryManager {

    private GameDaoMapDao mGameMapDao;

    public QueryManager(GameDaoMapDao gameMapDao) {
        mGameMapDao = gameMapDao;
    }

}
