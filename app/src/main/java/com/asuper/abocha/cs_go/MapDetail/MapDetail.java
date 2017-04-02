package com.asuper.abocha.cs_go.MapDetail;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryAdapter;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.GalleryBigDetail.GalleryBigDetail;
import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapDetail extends BaseActivity implements GalleryAdapter.GalleryClickListener {

    @BindView(R.id.image_collapse) ImageView mapImage;
    @BindView(R.id.recyclerView_in_activity_map_detail) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_detail);
        //doAnimation(mapImage, R.anim.resize_imageview_from_small_to_big);
        //QueryBuilder<GameDaoMap> qb = gameMapDao.queryBuilder();
       // qb.where(GameMapDao.Properties.ShortDescription.eq("De dust 2"));
       // Log.d("GreenDAO", qb.list().get(0).getLongDescription());
        ButterKnife.bind(this);
        Glide.with(this)
                .load(R.drawable.de_inferno)
                .centerCrop()
                .into(mapImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.resize_imageview_from_small_to_big); // TODO: 29.03.17 Make animation method in BaseActivity
        mapImage.startAnimation(animation);
        List<Integer> mockList = new ArrayList<>();
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        GalleryAdapter galleryAdapter = new GalleryAdapter(mockList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(galleryAdapter);
    }

    @Override
    public void injectComponent() {

    }

    @Override
    public void onGalleryItemClick(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startWithTransition(GalleryBigDetail.class, imageView, "fromDetailToBig"); // TODO: 30.03.17 Make activity transition intent
        }else start(GalleryBigDetail.class);
    }

    @Override
    public void onBackPressed() {
        // TODO: 30.03.17 Add animation in MapActivity(resize from small to big)
        doAnimation(mapImage, R.anim.resize_imageview_to_small);
        super.onBackPressed();
    }
}
