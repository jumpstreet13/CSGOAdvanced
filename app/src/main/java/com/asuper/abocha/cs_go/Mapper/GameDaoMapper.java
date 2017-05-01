package com.asuper.abocha.cs_go.Mapper;

import com.asuper.abocha.cs_go.Data.GameDaoMap;
import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Managers.GsonManager;

import javax.inject.Inject;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public class GameDaoMapper implements Mapper<GameDaoMap, GameDtoMap> {

    private GsonManager mGsonManager;

    public GameDaoMapper(GsonManager gsonManager) {
        mGsonManager = gsonManager;
    }

    @Override
    public GameDtoMap mapTo(GameDaoMap gameDaoMap) {
        GameDtoMap gameDtoMap = new GameDtoMap();
        gameDtoMap.setIdForSearch(gameDaoMap.getIdForSearch());
        gameDtoMap.setShortDescription(gameDaoMap.getShortDescription());
        gameDtoMap.setLongDescription(gameDaoMap.getLongDescription());
        gameDtoMap.setImage(gameDaoMap.getImage());
        gameDtoMap.setSmokes(mGsonManager.getListIntegerFromJson(gameDaoMap.getSmokes()));
        gameDtoMap.setFlashbangs(mGsonManager.getListIntegerFromJson(gameDaoMap.getFlashbangs()));
        gameDtoMap.setMolotovs(mGsonManager.getListIntegerFromJson(gameDaoMap.getMolotovs()));
        return gameDtoMap;
    }

    @Override
    public GameDaoMap mapFrom(GameDtoMap gameDtoMap) {
        GameDaoMap gameDaoMap = new GameDaoMap();
        gameDaoMap.setIdForSearch(gameDtoMap.getIdForSearch());
        gameDaoMap.setShortDescription(gameDtoMap.getShortDescription());
        gameDaoMap.setLongDescription(gameDtoMap.getLongDescription());
        gameDaoMap.setImage(gameDtoMap.getImage());
        gameDaoMap.setSmokes(mGsonManager.makeJsonFromIntegerList(gameDtoMap.getSmokes()));
        gameDaoMap.setFlashbangs(mGsonManager.makeJsonFromIntegerList(gameDtoMap.getFlashbangs()));
        gameDaoMap.setMolotovs(mGsonManager.makeJsonFromIntegerList(gameDtoMap.getMolotovs()));
        return gameDaoMap;
    }
}
