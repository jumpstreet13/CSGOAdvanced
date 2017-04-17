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
import com.asuper.abocha.cs_go.Managers.MyTransitionManager;
import com.asuper.abocha.cs_go.R;
import com.asuper.abocha.cs_go.StateImageView;
import com.asuper.abocha.cs_go.Tacticks;
import com.asuper.abocha.cs_go.VoiceRecordActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapDetailActivity extends BaseActivity implements MapDetailView, GalleryAdapter.GalleryClickListener {

    @Inject MapDetailPresenter presenter;
    @Inject MyTransitionManager transition;
    @BindView(R.id.image_collapse) ImageView mapImage;
    @BindView(R.id.recyclerView_withSmokes_in_activity_map_detail) RecyclerView recyclerViewSmokes;
    @BindView(R.id.recyclerView_withFlashBangs_in_activity_map_detail) RecyclerView recyclerViewFlashBangs;
    @BindView(R.id.recyclerView_withMolotovs_in_activity_map_detail) RecyclerView recyclerViewMolotovs;
    @BindView(R.id.smokes) StateImageView smokes;
    @BindView(R.id.flashbangs) StateImageView flash;
    @BindView(R.id.molotovs) StateImageView molotovs;
    // TODO: 13.04.17 Add scrollView to layout for supporting small devices

    @OnClick(R.id.fab_in_activity_map)
    void onFabClick(){
        start(VoiceRecordActivity.class);
    }

    @OnClick(R.id.smokes)
    void onSmokeClick() {
        if(smokes.isStateTurnOn()) {
            recyclerViewSmokes.setAdapter(null);
            //smokes.setStateTurnOn(true, R.drawable);
        }else{
            presenter.getTacticks(transition.getLastTransition(), Tacticks.SMOKES);
            //smokes.setStateTurnOn(true, R.drawable);
        }
    }

    @OnClick(R.id.flashbangs)
    void onFlashClick() {
        if(flash.isStateTurnOn()) {
            recyclerViewFlashBangs.setAdapter(null);
            //flashbangs.setStateTurnOn(true, R.drawable);
        }else{
            presenter.getTacticks(transition.getLastTransition(), Tacticks.FLASHBANGS);
            //flashbangs.setStateTurnOn(true, R.drawable);
        }

    }

    @OnClick(R.id.molotovs)
    void onMolotovClick() {
        if(molotovs.isStateTurnOn()) {
            recyclerViewMolotovs.setAdapter(null);
            //molotovs.setStateTurnOn(true, R.drawable);
        }else{
            presenter.getTacticks(transition.getLastTransition(), Tacticks.MOLOTOVS);
            //molotovs.setStateTurnOn(true, R.drawable);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_detail);
        ButterKnife.bind(this);
        injectComponent();
        presenter.attachView(this);
        presenter.getMainImage(transition.getLastTransition());
        //presenter.getTacticks(transition.getLastTransition());
    }

    @Override
    public void injectComponent() {
        App.get(this).plusPresenterComponent().inject(this);
    }

    @Override
    public void onGalleryItemClick(ImageView imageView, Tacticks tacticks) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startWithTransition(GalleryBigDetail.class, imageView, "fromDetailToBig", false); // TODO: 30.03.17 Make activity transition intent
        } else start(GalleryBigDetail.class);
        switch (tacticks) {
            case MOLOTOVS:
                transition.setTrueOneAndSetFalseAnothers(Tacticks.MOLOTOVS);
                break;
            case FLASHBANGS:
                transition.setTrueOneAndSetFalseAnothers(Tacticks.FLASHBANGS);
                break;
            case SMOKES:
                transition.setTrueOneAndSetFalseAnothers(Tacticks.SMOKES);
                break;
        }
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
                .load(image)
                .centerCrop()
                .into(mapImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.resize_imageview_from_small_to_big); // TODO: 29.03.17 Make animation method in BaseActivity
        mapImage.startAnimation(animation);
    }

    @Override
    public void fetchTacticksImage(List<Integer> tacticks, Tacticks type) {
        switch (type) {
            case SMOKES:
                fetchRecycler(recyclerViewSmokes, tacticks, type);
                break;
            case FLASHBANGS:
                fetchRecycler(recyclerViewSmokes, tacticks, type);
                break;
            case MOLOTOVS:
                fetchRecycler(recyclerViewSmokes, tacticks, type);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get(this).clearPresenterComponent();
    }

    private void fetchRecycler(RecyclerView recyclerView, List<Integer> tacktics, Tacticks which) {
        RecyclerView.Adapter galleryAdapter = new GalleryAdapter(tacktics, this, which);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(galleryAdapter);
    }

}
