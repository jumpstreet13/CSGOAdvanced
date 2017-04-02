package com.asuper.abocha.cs_go.Map;


import com.asuper.abocha.cs_go.BaseInteractor;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Listeners;

import java.util.List;

public interface MapInteractorInterface extends BaseInteractor {

    void getMaps(Listeners.onQueryMapsResultedListener listener);
}
