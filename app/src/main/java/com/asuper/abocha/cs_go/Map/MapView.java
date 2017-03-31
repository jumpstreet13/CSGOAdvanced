package com.asuper.abocha.cs_go.Map;


import com.asuper.abocha.cs_go.BaseView;
import com.asuper.abocha.cs_go.Model.GameMap;

import java.util.List;

public interface MapView extends BaseView {

    void fetchData(List<GameMap> gameMaps);
}
