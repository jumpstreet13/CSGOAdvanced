package com.asuper.abocha.cs_go;

import android.os.Bundle;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Map.MapActivity;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;

import java.util.ArrayList;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject GameDaoMapDao gameMapDao;
    @Inject Mapper<GameDaoMap, GameDtoMap> gameDaoMapper;
    @Inject Mapper<GameDtoMap, GameMap> gameMapMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        App.get(this).getComponent().inject(this);
        if(gameMapDao.loadAll().size() > 0) {
            start(MapActivity.class);
        }else {

            GameMap gameMap =  new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            GameMap gameMap2 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            GameMap gameMap3 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            gameMapDao.insertOrReplaceInTx(gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap2)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap3)));
            start(MapActivity.class);
        }
    }

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }
}
