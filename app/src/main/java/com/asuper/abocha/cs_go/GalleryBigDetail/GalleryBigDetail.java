package com.asuper.abocha.cs_go.GalleryBigDetail;

import android.content.Intent;
import android.os.Bundle;
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
import com.asuper.abocha.cs_go.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.asuper.abocha.cs_go.R.id.start;

public class GalleryBigDetail extends BaseActivity implements GalleryBigAdapter.GalleryBigClickListener {


    @Inject MyTransitionManager transition;
    @Inject QueryManager manager;
    @Inject Mapper<GameDaoMap, GameDtoMap> mapper;
    @BindView(R.id.recyclerView_in_bigdetail_activity) RecyclerView mRecyclerView;

    @OnClick(R.id.activity_gallery_big_detail)
    void onClick() {
        start(MapDetailActivity.class, true);
        // TODO: 30.03.17 Add intent for making new Task and push the past activtiy to the toop of the stack
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_big_detail);
        ButterKnife.bind(this);
        GalleryBigAdapter galleryAdapter = new GalleryBigAdapter(mapper.mapTo(manager.getMapById(transition.getLastTransition())).getSmokes(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(galleryAdapter);
        // TODO: 29.03.17 If click on background of activity go back to last activity
    }

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }

    @Override
    public void onGalleryItemClick(ImageView imageView) {
    }


}
