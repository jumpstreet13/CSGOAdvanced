package com.asuper.abocha.cs_go.Map;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.App;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Di.InteractorModule;
import com.asuper.abocha.cs_go.Di.MapperModule;
import com.asuper.abocha.cs_go.Di.PresenterModule;
import com.asuper.abocha.cs_go.MapDetail.MapDetail;
import com.asuper.abocha.cs_go.Adapter.MapAdapter;
import com.asuper.abocha.cs_go.Model.GameMap;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends BaseActivity implements MapView, MapAdapter.MapClickListener {

    @Inject MapPresenterInterface presenter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.image_collapse) ImageView mImageView;
    @BindView(R.id.activity_map_coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        injectComponent();
        Glide.with(this)
                .load(R.drawable.main)
                .centerCrop()
                .into(mImageView);
    }

    @Override
    public void injectComponent() {
        App.get(this).plusPresenterComponent().inject(this);
        presenter.attachView(this);
        presenter.loadData();
    }

    @Override
    public void onMapClick(ImageView imageView) {
        doAnimation(imageView, R.anim.resize_imageview_to_small);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startWithTransition(MapDetail.class, imageView, "mapImage");
        } else {
            start(MapDetail.class);
            // TODO: 30.03.17 Lint Validation
        }
    }

    @Override
    public void fetchData(List<GameMap> gameMaps) {
        MapAdapter adapter = new MapAdapter(gameMaps, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // TODO: 29.03.17 GridLayoutManager
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get(this).clearPresenterComponent();
    }
}
