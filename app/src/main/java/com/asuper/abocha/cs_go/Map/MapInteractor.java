package com.asuper.abocha.cs_go.Map;

import com.asuper.abocha.cs_go.Data.DaoSession;

/**
 * Created by Abocha on 04.03.2017.
 */

public class MapInteractor implements MapInteractorInterface {

    private DaoSession session;

    public MapInteractor(DaoSession session) {
        this.session = session;
    }



}
