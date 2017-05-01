package com.asuper.abocha.cs_go.MapDetail;

import com.asuper.abocha.cs_go.BaseInteractor;
import com.asuper.abocha.cs_go.Listeners;

/**
 * Created by Abocha on 19.03.2017.
 */

public interface MapDetailInteractor extends BaseInteractor {

    void getTacticks(int id, Listeners.onQueryTacticImagesListener listener);
    void getMainImage(int id, Listeners.onQueryTacticImagesListener listener);
}
