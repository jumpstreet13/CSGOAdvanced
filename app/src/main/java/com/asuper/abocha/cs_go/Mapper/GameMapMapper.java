package com.asuper.abocha.cs_go.Mapper;

import com.asuper.abocha.cs_go.Dto.GameDtoMap;
import com.asuper.abocha.cs_go.Model.GameMap;

/**
 * Created by abakarmagomedov on 31.03.17.
 */


public class GameMapMapper implements Mapper<GameDtoMap, GameMap>  {
    @Override
    public GameMap mapTo(GameDtoMap gameDtoMap) {
        GameMap gameMap = new GameMap();
        gameMap.setIdForSearch(gameDtoMap.getIdForSearch());
        gameMap.setShortDescription(gameDtoMap.getShortDescription());
        gameMap.setLongDescription(gameDtoMap.getLongDescription());
        gameMap.setImage(gameDtoMap.getImage());
        gameMap.setSmokes(gameDtoMap.getSmokes());
        gameMap.setFlashbangs(gameDtoMap.getFlashbangs());
        gameMap.setMolotovs(gameDtoMap.getMolotovs());
        return gameMap;
    }

    @Override
    public GameDtoMap mapFrom(GameMap gameMap) {
        GameDtoMap gameDtoMap = new GameDtoMap();
        gameDtoMap.setIdForSearch(gameMap.getIdForSearch());
        gameDtoMap.setShortDescription(gameMap.getShortDescription());
        gameDtoMap.setLongDescription(gameMap.getLongDescription());
        gameDtoMap.setImage(gameMap.getImage());
        gameDtoMap.setSmokes(gameMap.getSmokes());
        gameDtoMap.setFlashbangs(gameMap.getFlashbangs());
        gameDtoMap.setMolotovs(gameMap.getMolotovs());
        return gameDtoMap;
    }
}
