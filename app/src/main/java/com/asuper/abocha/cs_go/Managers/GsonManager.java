package com.asuper.abocha.cs_go.Managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public class GsonManager {

    private Gson mGson;

    public GsonManager(Gson mGson){
        this.mGson = mGson;
    }

    public String makeJsonFromIntegerList(List<Integer> list){
        return mGson.toJson(list);
    }

    public List<Integer> getListIntegerFromJson(String json){
        return mGson.fromJson(json, new TypeToken<List<Integer>>(){}.getType());
    }

}
