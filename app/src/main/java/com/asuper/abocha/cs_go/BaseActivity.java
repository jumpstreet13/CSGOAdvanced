package com.asuper.abocha.cs_go;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;


public abstract class BaseActivity extends AppCompatActivity {


    // protected DaoSession daoSession;
    // protected GameDaoMapDao gameMapDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //daoSession = ((App) getApplication()).getDaoSession();
        //gameMapDao = daoSession.getGameDaoMapDao();
    }

    // TODO: 14.04.17 Add tools to layouts to see all clear

    public void start(Class<?> where) {
        Intent intent = new Intent(this, where);
        startActivity(intent);
    }

    public void startWithTransition(Class<?> where, View view, String name, boolean flag) {
        Intent intent = new Intent(this, where);
        if (flag) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, name);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }


    public void start(Class<?> where, boolean flag) {
        Intent intent = new Intent(this, where);
        if (flag) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        startActivity(intent);
    }

    //// TODO: 12.04.17 Singleton with id of element which is selected

    public void startWithTransition(Class<?> where, View view, String name) {
        Intent intent = new Intent(this, where);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, name);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }

    public void doAnimation(View targetView, int animation) {
        targetView.startAnimation(AnimationUtils.loadAnimation(this, animation));
    }

    public void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //daoSession.clear();
    }

    public abstract void injectComponent();

}
