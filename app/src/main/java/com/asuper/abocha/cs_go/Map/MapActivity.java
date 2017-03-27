package com.asuper.abocha.cs_go.Map;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.MapDetail.MapDetail;
import com.asuper.abocha.cs_go.Model.Map;
import com.asuper.abocha.cs_go.Adapter.MapAdapter;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

public class MapActivity extends BaseActivity implements MapView, MapAdapter.MapClickListener {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.image_collapse) ImageView mImageView;
    @BindView(R.id.toolbar_in_map_activity) Toolbar toolbar;
    @BindView(R.id.activity_map_coordinator_layout) CoordinatorLayout mCoordinatorLayout;
    Map map = new Map("De dust 2", "this is map",R.drawable.de_inferno);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        setupToolbar();
        Glide.with(this)
                .load(R.drawable.main)
                .centerCrop()
                .into(mImageView);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Map map2 = new Map("De Cache", "this is map", R.drawable.de_cache);
        Map map3 = new Map("De nuke", "this is map",R.drawable.de_nuke);
        ArrayList<Map> arrayList = new ArrayList<Map>();
        arrayList.add(map);
        arrayList.add(map2);
        arrayList.add(map3);
        MapAdapter adapter = new MapAdapter(arrayList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }


    public void setupToolbar(){
        setSupportActionBar(toolbar);
    }

    @Override
    public void onMapClick(ImageView imageView) {
        Snackbar.make(mCoordinatorLayout, "you tapped me!", LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startWithTransition(MapDetail.class, imageView, "mapImage");
        } else {
            start(MapDetail.class);
        }
    }
}
