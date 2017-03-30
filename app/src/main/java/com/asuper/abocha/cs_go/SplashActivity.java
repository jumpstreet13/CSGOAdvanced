package com.asuper.abocha.cs_go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asuper.abocha.cs_go.Map.MapActivity;
import com.asuper.abocha.cs_go.Model.GameMap;

import java.util.Map;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(gameMapDao.loadAll().size() > 0) {
            start(MapActivity.class);
        }else {

            GameMap gameMap = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, "", "", "");
            GameMap gameMap2 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, "", "", "");
            GameMap gameMap3 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno, "", "", "");
            gameMapDao.insertOrReplaceInTx(gameMap, gameMap2, gameMap3);
            start(MapActivity.class);
        }
    }
}
