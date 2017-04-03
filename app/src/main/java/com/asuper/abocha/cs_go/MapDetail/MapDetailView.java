package com.asuper.abocha.cs_go.MapDetail;

import com.asuper.abocha.cs_go.BaseView;

import java.util.List;

/**
 * Created by Abocha on 19.03.2017.
 */

public interface MapDetailView extends BaseView {

     void fetchMainImage(int image);
     void fetchTacticksImage(List<Integer> tacticks);

}
