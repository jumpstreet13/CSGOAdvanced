package com.asuper.abocha.cs_go.Map;


import android.support.annotation.NonNull;

import com.asuper.abocha.cs_go.BasePresenterImp;

public class MapPresenter extends BasePresenterImp<MapView, MapInteractorInterface> implements MapPresenterInterface {

    private MapInteractorInterface interactor;

    public MapPresenter(@NonNull MapInteractorInterface interactor) {
        super(interactor);
    }

    @Override
    public void detachView() {
        super.detachView();
    }
}
