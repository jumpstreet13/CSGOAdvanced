package com.asuper.abocha.cs_go.MapDetail;

import com.asuper.abocha.cs_go.BasePresenter;

/**
 * Created by Abocha on 19.03.2017.
 */

public interface MapDetailPresenter extends BasePresenter<MapDetailView, MapDetailInteractor> {

    void getMainImage(Long id);
    void getTacticks(Long id);

}
