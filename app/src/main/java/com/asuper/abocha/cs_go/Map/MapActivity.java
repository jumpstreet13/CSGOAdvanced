package com.asuper.abocha.cs_go.Map;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.Model.Map;
import com.asuper.abocha.cs_go.Model.MapAdapter;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends BaseActivity implements MapView {

    //@BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private Toolbar toolbar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar_in_map_activity);
        mImageView = (ImageView) findViewById(R.id.image_collapse);
        setupToolbar();
        Glide.with(this)
                .load(R.drawable.main)
                .centerCrop()
                .into(mImageView);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Map map = new Map("De dust 2", "this is map",R.drawable.de_inferno);
        Map map2 = new Map("De Cache", "this is map", R.drawable.de_cache);
        Map map3 = new Map("De nuke", "this is map",R.drawable.de_nuke);
        ArrayList<Map> arrayList = new ArrayList<Map>();
        arrayList.add(map);
        arrayList.add(map2);
        arrayList.add(map3);
        MapAdapter adapter = new MapAdapter(this, arrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    Random mRandom = new Random();



    public void setupToolbar(){
        setSupportActionBar(toolbar);
    }
}
