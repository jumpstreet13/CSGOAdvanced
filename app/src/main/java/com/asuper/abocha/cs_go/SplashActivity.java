package com.asuper.abocha.cs_go;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.nfc.cardemulation.HostNfcFService;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Map.MapActivity;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject GameDaoMapDao gameMapDao;
    @Inject Mapper<GameDaoMap, GameDtoMap> gameDaoMapper;
    @Inject Mapper<GameDtoMap, GameMap> gameMapMapper;
    @Inject ProgressDialog progressDialog;
    private String mFileName = null;
    private MediaPlayer mPlayer = null;
    private Handler mHandler = new Handler();
    // TODO: 13.04.17 Add ability to say hello by user voice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        injectComponent();
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += StringUtils.FILE_WITH_HELLO;   // TODO: 13.04.17 Refactor this with Dagger
        progressDialog.show();
        App.get(this).getComponent().inject(this);
        if (gameMapDao.loadAll().size() > 0) {
            startWithDelay();
        } else {
            GameMap gameMap = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno,
                    new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            GameMap gameMap2 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno,
                    new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            GameMap gameMap3 = new GameMap("De dust 2", "this is mGameMap", R.drawable.de_inferno,
                    new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
            gameMapDao.insertOrReplaceInTx(gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap2)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(gameMap3)));
            startWithDelay();
        }
    }

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }

    public void startWithDelay() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPlaying();
                while (true) {
                    if (!mPlayer.isPlaying()) break;
                }
                stopPlaying();
                start(MapActivity.class);
                progressDialog.dismiss();
            }
        }, 1500);
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            //mPlayer.setDataSource(); // TODO: 13.04.17 If file is not exist set default hello word
            Log.e("Failure", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }
}
