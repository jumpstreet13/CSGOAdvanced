package com.asuper.abocha.cs_go.GalleryBigDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryBigAdapter;
import com.asuper.abocha.cs_go.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GalleryBigDetail extends AppCompatActivity implements GalleryBigAdapter.GalleryBigClickListener {


    @BindView(R.id.recyclerView_in_bigdetail_activity) RecyclerView mRecyclerView;

    @OnClick(R.id.activity_gallery_big_detail)
    void onClick(){
        super.onBackPressed();
        // TODO: 30.03.17 Add intent for making new Task and push the past activtiy to the toop of the stack
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_big_detail);
        ButterKnife.bind(this);
        Intent intent = new Intent();
        List<Integer> mockList = new ArrayList<>();
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        mockList.add(R.drawable.de_cache);
        mockList.add(R.drawable.de_nuke);
        GalleryBigAdapter galleryAdapter = new GalleryBigAdapter(mockList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(galleryAdapter);
        // TODO: 29.03.17 If click on background of activity go back to last activity
    }

    @Override
    public void onGalleryItemClick(ImageView imageView) {
    }


}
