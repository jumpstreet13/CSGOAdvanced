package com.asuper.abocha.cs_go.Map;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.App;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.MapDetail.MapDetail;
import com.asuper.abocha.cs_go.Model.DaoSession;
import com.asuper.abocha.cs_go.Model.GameMap;
import com.asuper.abocha.cs_go.Adapter.MapAdapter;
import com.asuper.abocha.cs_go.Model.GameMapDao;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends BaseActivity implements MapView, MapAdapter.MapClickListener {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.image_collapse) ImageView mImageView;
    @BindView(R.id.activity_map_coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        Glide.with(this)
                .load(R.drawable.main)
                .centerCrop()
                .into(mImageView);
        GameMap gameMap = new GameMap("De dust 2", "this is mGameMap",R.drawable.de_inferno, "", "", "");
        GameMap gameMap2 = new GameMap("De dust 2", "this is mGameMap",R.drawable.de_inferno, "", "", "");
        GameMap gameMap3 = new GameMap("De dust 2", "this is mGameMap",R.drawable.de_inferno, "", "", "");
        gameMapDao.insertInTx(gameMap, gameMap2, gameMap3);
        ArrayList<GameMap> arrayList = new ArrayList<GameMap>();
        arrayList.add(gameMap);
        arrayList.add(gameMap2);
        arrayList.add(gameMap3);
        MapAdapter adapter = new MapAdapter(arrayList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // TODO: 29.03.17 GridLayoutManager
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onMapClick(ImageView imageView) {
        doAnimation(imageView, R.anim.resize_imageview_to_small);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startWithTransition(MapDetail.class, imageView, "mapImage");
        } else {
            start(MapDetail.class);
        }
    }
}
