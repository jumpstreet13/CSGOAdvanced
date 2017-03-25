package com.asuper.abocha.cs_go;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity extends AppCompatActivity {


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

}
