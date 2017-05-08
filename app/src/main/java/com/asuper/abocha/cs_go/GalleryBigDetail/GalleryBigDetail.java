package com.asuper.abocha.cs_go.GalleryBigDetail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryBigAdapter;
import com.asuper.abocha.cs_go.App;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Managers.MyTransitionManager;
import com.asuper.abocha.cs_go.Managers.QueryManager;
import com.asuper.abocha.cs_go.MapDetail.MapDetailActivity;
import com.asuper.abocha.cs_go.Mapper.Mapper;
import com.asuper.abocha.cs_go.Model.GameMap;
import com.asuper.abocha.cs_go.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.asuper.abocha.cs_go.R.id.start;
import static com.asuper.abocha.cs_go.R.id.transition_current_scene;

public class GalleryBigDetail extends BaseActivity implements GalleryBigAdapter.GalleryBigClickListener {


    @Inject MyTransitionManager transition;
    @Inject QueryManager manager;
    @Inject Mapper<GameDaoMap, GameDtoMap> mapper;
    @Inject Mapper<GameDtoMap, GameMap> dataMapper;
    @BindView(R.id.recyclerView_in_bigdetail_activity) RecyclerView mRecyclerView;

    @OnClick(R.id.activity_gallery_big_detail)
    void onClick() {
        //start(MapDetailActivity.class, true);
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_big_detail);
        ButterKnife.bind(this);
        injectComponent();
        GalleryBigAdapter galleryAdapter = new GalleryBigAdapter(dataMapper.mapTo(mapper.mapTo(manager.getMapById(transition.getLastTransition()))).
                getExactTactick(transition.getActualTactick()), this);
        // TODO: 13.04.17 Make this logic more clear!!
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(galleryAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.smoothScrollToPosition(transition.getItemPosition());
            }
        },500);
    }

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }

    @Override
    public void onGalleryItemClick(ImageView imageView) {
    }

}
