package com.asuper.abocha.cs_go.GalleryBigDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.asuper.abocha.cs_go.Adapter.GalleryAdapter;
import com.asuper.abocha.cs_go.Adapter.GalleryBigAdapter;
import com.asuper.abocha.cs_go.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryBigDetail extends AppCompatActivity implements GalleryBigAdapter.GalleryBigClickListener {

    @BindView(R.id.activity_gallery_big_detail) LinearLayout params;
    @BindView(R.id.recyclerView_in_bigdetail_activity) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_big_detail);
        ButterKnife.bind(this);
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
