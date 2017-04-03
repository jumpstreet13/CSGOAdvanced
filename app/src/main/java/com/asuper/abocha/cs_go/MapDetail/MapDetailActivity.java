package com.asuper.abocha.cs_go.MapDetail;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryAdapter;
import com.asuper.abocha.cs_go.App;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.GalleryBigDetail.GalleryBigDetail;
import com.asuper.abocha.cs_go.R;
import com.asuper.abocha.cs_go.StringUtils;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapDetailActivity extends BaseActivity implements MapDetailView, GalleryAdapter.GalleryClickListener {

    @Inject MapDetailPresenter presenter;
    @BindView(R.id.image_collapse) ImageView mapImage;
    @BindView(R.id.recyclerView_in_activity_map_detail) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_detail);
        ButterKnife.bind(this);
        injectComponent();
        presenter.attachView(this);
        presenter.getMainImage(getIntent().getLongExtra(StringUtils.ID_TAG_IN_INTENT, 0));
      //  presenter.getTacticks(getIntent().getLongExtra(StringUtils.ID_TAG_IN_INTENT, 0));
    }

    @Override
    public void injectComponent() {
        App.get(this).plusPresenterComponent().inject(this);
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

    @Override
    public void fetchMainImage(int image) {
        Glide.with(this)
                .load(R.drawable.de_inferno)
                .centerCrop()
                .into(mapImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.resize_imageview_from_small_to_big); // TODO: 29.03.17 Make animation method in BaseActivity
        mapImage.startAnimation(animation);
    }

    @Override
    public void fetchTacticksImage(List<Integer> tacticks) {
        GalleryAdapter galleryAdapter = new GalleryAdapter(tacticks, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(galleryAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get(this).clearPresenterComponent();
    }

}
