package com.asuper.abocha.cs_go;

import com.asuper.abocha.cs_go.Dto.GameDtoMap;

import java.util.List;

/**
 * Created by abakarmagomedov on 02.04.17.
 */

public interface Listeners {

    interface onQueryMapsResultedListener {
        void onSuccess(List<GameDtoMap> maps);
        void onError();
    }
    
}
