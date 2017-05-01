package com.asuper.abocha.cs_go.MapDetail;

import com.asuper.abocha.cs_go.BasePresenter;
import com.asuper.abocha.cs_go.Tacticks;

/**
 * Created by Abocha on 19.03.2017.
 */

public interface MapDetailPresenter extends BasePresenter<MapDetailView, MapDetailInteractor> {

    void getMainImage(int id);
    void getTacticks(int id, Tacticks tacticks);

}
