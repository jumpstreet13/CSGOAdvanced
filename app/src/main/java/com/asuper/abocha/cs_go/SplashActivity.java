package com.asuper.abocha.cs_go;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
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
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

// TODO: 17.04.17 Please do not scroll or watch this code it causes negative emotions

public class SplashActivity extends BaseActivity {

    @Inject GameDaoMapDao gameMapDao;
    @Inject Mapper<GameDaoMap, GameDtoMap> gameDaoMapper;
    @Inject Mapper<GameDtoMap, GameMap> gameMapMapper;
    private List<Integer> infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask; // TODO: 17.04.17 Maybe bitmaps later
    private String mFileName = null;
    private MediaPlayer mPlayer = null;
    private Handler mHandler = new Handler();
    // TODO: 13.04.17 Add ability to say hello by user voice

    // TODO: 17.04.17 Do not forget to use resizeable images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        injectComponent();
        infernoRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        nukeRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        trainRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        mirageRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        overpassRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        cobleRask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
        dust2Rask = Arrays.asList(R.drawable.de_cache, R.drawable.de_cbble, R.drawable.de_dust2, R.drawable.de_inferno, R.drawable.de_mirage);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += StringUtils.FILE_WITH_HELLO;   // TODO: 13.04.17 Refactor this with Dagger
        App.get(this).getComponent().inject(this);
        if (gameMapDao.loadAll().size() > 0) {
            startWithDelay();
        } else {
            GameMap inferno = new GameMap("Inferno", "this is mGameMap", R.drawable.de_inferno);
            GameMap nuke = new GameMap("Nuke", "this is mGameMap", R.drawable.de_nuke);
            GameMap train = new GameMap("Train", "this is mGameMap", R.drawable.de_train);
            GameMap mirage = new GameMap("Mirage", "this is mGameMap", R.drawable.de_mirage); // TODO: 01/05/17 Delete these casts
            GameMap overpass = new GameMap("Overpass", "this is mGameMap", R.drawable.de_overpass);
            GameMap coble = new GameMap("Coble", "this is mGameMap", R.drawable.de_cbble);
            GameMap dust2 = new GameMap("Dust2", "this is mGameMap", R.drawable.de_dust2);
            inferno.setIdForSearch(0);
            nuke.setIdForSearch(1);
            train.setIdForSearch(2);
            mirage.setIdForSearch(3);
            overpass.setIdForSearch(4);
            coble.setIdForSearch(5);
            dust2.setIdForSearch(6);
            //  fillSmokes(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask, 15);
            inferno.setSmokes(infernoRask);
            nuke.setSmokes(nukeRask);
            train.setSmokes(trainRask);
            mirage.setSmokes(mirageRask);
            overpass.setSmokes(overpassRask);
            coble.setSmokes(cobleRask);
            dust2.setSmokes(dust2Rask);
            //clearLists(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask);

            //fillFlashBangs(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask, 15);
            inferno.setFlashbangs(infernoRask);
            nuke.setFlashbangs(nukeRask);
            train.setFlashbangs(trainRask);
            mirage.setFlashbangs(mirageRask);
            overpass.setFlashbangs(overpassRask);
            coble.setFlashbangs(cobleRask);
            dust2.setFlashbangs(dust2Rask);
            // clearLists(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask);

            // fillMolotovs(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask, 15);
            inferno.setMolotovs(infernoRask);
            nuke.setMolotovs(nukeRask);
            train.setMolotovs(trainRask);
            mirage.setMolotovs(mirageRask);
            overpass.setMolotovs(overpassRask);
            coble.setMolotovs(cobleRask);
            dust2.setMolotovs(dust2Rask);
//            clearLists(infernoRask, nukeRask, trainRask, mirageRask, overpassRask, cobleRask, dust2Rask);

            gameMapDao.insertOrReplaceInTx(gameDaoMapper.mapFrom(gameMapMapper.mapFrom(inferno)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(nuke)), gameDaoMapper.mapFrom(gameMapMapper.mapFrom(train)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(mirage)), gameDaoMapper.mapFrom(gameMapMapper.mapFrom(overpass)),
                    gameDaoMapper.mapFrom(gameMapMapper.mapFrom(coble)), gameDaoMapper.mapFrom(gameMapMapper.mapFrom(dust2)));
            startWithDelay();
        }
    }

    // TODO: 14.04.17 Add transient button for skipping hello music, but after database is filled

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }

    public void startWithDelay() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // startPlaying();
                // while (true) {
                //     if (!mPlayer.isPlaying()) break;
                // }
                // stopPlaying();
                start(MapActivity.class);
            }
        }, 3500);
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


    private void clearLists(List<Integer> inferno, List<Integer> nuke, List<Integer> train,
                            List<Integer> mirage, List<Integer> overpass, List<Integer> coble,
                            List<Integer> dust2) {
        inferno.clear();
        nuke.clear();
        train.clear();
        mirage.clear();
        overpass.clear();
        coble.clear();
        dust2.clear();
    }


    private void fillSmokes(List<Integer> inferno, List<Integer> nuke, List<Integer> train,
                            List<Integer> mirage, List<Integer> overpass, List<Integer> coble,
                            List<Integer> dust2, int num) {
        for (int i = 0; i < num; i++) {
            if (getResources().getIdentifier(StringUtils.INFERNO_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                inferno.add(getResources().getIdentifier(StringUtils.INFERNO_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.NUKE_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                nuke.add(getResources().getIdentifier(StringUtils.NUKE_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.TRAIN_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                train.add(getResources().getIdentifier(StringUtils.TRAIN_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.MIRAGE_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                mirage.add(getResources().getIdentifier(StringUtils.MIRAGE_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.OVERPASS_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                overpass.add(getResources().getIdentifier(StringUtils.OVERPASS_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.COBLE_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                coble.add(getResources().getIdentifier(StringUtils.COBLE_RASKID_SMOKES + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.DUST2_RASKID_SMOKES + i, "drawable", getPackageName()) != 0)
                dust2.add(getResources().getIdentifier(StringUtils.DUST2_RASKID_SMOKES + i, "drawable", getPackageName()));
        }
    }


    private void fillFlashBangs(List<Integer> inferno, List<Integer> nuke, List<Integer> train,
                                List<Integer> mirage, List<Integer> overpass, List<Integer> coble,
                                List<Integer> dust2, int num) {
        for (int i = 0; i < num; i++) {
            if (getResources().getIdentifier(StringUtils.INFERNO_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                inferno.add(getResources().getIdentifier(StringUtils.INFERNO_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.NUKE_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                nuke.add(getResources().getIdentifier(StringUtils.NUKE_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.TRAIN_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                train.add(getResources().getIdentifier(StringUtils.TRAIN_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.MIRAGE_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                mirage.add(getResources().getIdentifier(StringUtils.MIRAGE_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.OVERPASS_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                overpass.add(getResources().getIdentifier(StringUtils.OVERPASS_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.COBLE_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                coble.add(getResources().getIdentifier(StringUtils.COBLE_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.DUST2_RASKID_FLASHBANGS + i, "drawable", getPackageName()) != 0)
                dust2.add(getResources().getIdentifier(StringUtils.DUST2_RASKID_FLASHBANGS + i, "drawable", getPackageName()));
        }
    }

    private void fillMolotovs(List<Integer> inferno, List<Integer> nuke, List<Integer> train,
                              List<Integer> mirage, List<Integer> overpass, List<Integer> coble,
                              List<Integer> dust2, int num) {
        for (int i = 0; i < num; i++) {
            if (getResources().getIdentifier(StringUtils.INFERNO_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                inferno.add(getResources().getIdentifier(StringUtils.INFERNO_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.NUKE_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                nuke.add(getResources().getIdentifier(StringUtils.NUKE_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.TRAIN_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                train.add(getResources().getIdentifier(StringUtils.TRAIN_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.MIRAGE_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                mirage.add(getResources().getIdentifier(StringUtils.MIRAGE_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.OVERPASS_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                overpass.add(getResources().getIdentifier(StringUtils.OVERPASS_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.COBLE_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                coble.add(getResources().getIdentifier(StringUtils.COBLE_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
            if (getResources().getIdentifier(StringUtils.DUST2_RASKID_MOLOTOVS + i, "drawable", getPackageName()) != 0)
                dust2.add(getResources().getIdentifier(StringUtils.DUST2_RASKID_MOLOTOVS + i, "drawable", getPackageName()));
        }
    }


}
