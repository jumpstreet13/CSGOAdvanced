package com.asuper.abocha.cs_go.MapDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryAdapter;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.GalleryBigDetail.GalleryBigDetail;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

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
    public void onGalleryItemClick(ImageView imageView) {
        start(GalleryBigDetail.class);
    }
}
