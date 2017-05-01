package com.asuper.abocha.cs_go.MapDetail;


import android.support.annotation.NonNull;

import com.asuper.abocha.cs_go.BasePresenterImp;
import com.asuper.abocha.cs_go.Listeners;
import com.asuper.abocha.cs_go.Tacticks;

import java.util.List;


/**
 * Created by Abocha on 19.03.2017.
 */

public class MapDetailPresenterImp extends BasePresenterImp<MapDetailView, MapDetailInteractor> implements MapDetailPresenter, Listeners.onQueryTacticImagesListener {

    private Tacticks nowTactick;

    public MapDetailPresenterImp(@NonNull MapDetailInteractor interactor) {
        super(interactor);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void onSuccessTacticks(List<Integer> maps) {
        getView().fetchTacticksImage(maps, nowTactick);
    }

    @Override
    public void onSuccessMainImage(Integer image) {
        getView().fetchMainImage(image);
    }

    @Override
    public void onError() {}

    @Override
    public void getMainImage(int id) {
        getInteractor().getMainImage(id, this);
    }

    @Override
    public void getTacticks(int id, Tacticks tacticks) {
        nowTactick = tacticks;
        getInteractor().getTacticks(id, this);
    }
}
