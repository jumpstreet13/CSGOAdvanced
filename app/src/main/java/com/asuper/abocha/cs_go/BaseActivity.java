package com.asuper.abocha.cs_go;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.asuper.abocha.cs_go.Model.DaoSession;
import com.asuper.abocha.cs_go.Model.GameMapDao;

public class BaseActivity extends AppCompatActivity {


    protected DaoSession daoSession;
    protected GameMapDao gameMapDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        daoSession = ((App) getApplication()).getDaoSession();
        gameMapDao = daoSession.getGameMapDao();
    }

    public void start(Class<?> where) {
        Intent intent = new Intent(this, where);
        startActivity(intent);
    }

    public void startWithTransition(Class<?> where, View view, String name){
        Intent intent = new Intent(this, where);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, name);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }

    public void doAnimation(View targetView, int animation){
        targetView.startAnimation(AnimationUtils.loadAnimation(this, animation));
    }

    public void setupToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        daoSession.clear();
    }
}
