package com.asuper.abocha.cs_go.MapDetail;


import android.support.annotation.NonNull;

import com.asuper.abocha.cs_go.BasePresenterImp;
import com.asuper.abocha.cs_go.Listeners;

import java.util.List;


/**
 * Created by Abocha on 19.03.2017.
 */

public class MapDetailPresenterImp extends BasePresenterImp<MapDetailView, MapDetailInteractor> implements MapDetailPresenter, Listeners.onQueryTacticImagesListener {


    public MapDetailPresenterImp(@NonNull MapDetailInteractor interactor) {
        super(interactor);
    }

    @Override
    public void detachView() {
        super.detachView();
    }


    @Override
    public void onSuccessTacticks(List<Integer> maps) {
        getView().fetchTacticksImage(maps);
    }

    @Override
    public void onSuccessMainImage(Integer image) {
        getView().fetchMainImage(image);
    }

    @Override
    public void onError() {

    }

    @Override
    public void getMainImage(Long id) {
        getInteractor().getMainImage(id, this);
    }

    @Override
    public void getTacticks(Long id) {
        getInteractor().getTacticks(id, this);
    }
}
