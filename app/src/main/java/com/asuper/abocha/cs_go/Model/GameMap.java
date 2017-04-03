package com.asuper.abocha.cs_go.Model;

import com.asuper.abocha.cs_go.Dto.GameDtoMap;

import java.util.List;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public class GameMap {

    /**
     * Field id only for search in database, at this level this field is not required (greenDao produce id by itself)
     */

    // TODO: 03.04.17 Make idForSearch and delete id which exists now
    private Long id;
    private String shortDescription;
    private String longDescription;
    private int image;
    private List<Integer> smokes;
    private List<Integer> flashbangs;
    private List<Integer> molotovs;

    public GameMap() {
    }

    public GameMap(String shortDescription, String longDescription, int image, List<Integer> smokes,
                   List<Integer> flashbangs, List<Integer> molotovs) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }

    public GameMap(GameDtoMap gameDtoMap) {
        this.id = gameDtoMap.getId();
        this.shortDescription = gameDtoMap.getShortDescription();
        this.longDescription = gameDtoMap.getLongDescription();
        this.image = gameDtoMap.getImage();
        this.smokes = gameDtoMap.getSmokes();
        this.flashbangs = gameDtoMap.getFlashbangs();
        this.molotovs = gameDtoMap.getMolotovs();
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Integer> getSmokes() {
        return smokes;
    }

    public void setSmokes(List<Integer> smokes) {
        this.smokes = smokes;
    }

    public List<Integer> getFlashbangs() {
        return flashbangs;
    }

    public void setFlashbangs(List<Integer> flashbangs) {
        this.flashbangs = flashbangs;
    }

    public List<Integer> getMolotovs() {
        return molotovs;
    }

    public void setMolotovs(List<Integer> molotovs) {
        this.molotovs = molotovs;
    }

    /**
     * Field id only for search in database, at this level this field is not required (greenDao produce id by itself)
     */
    public Long getId() {
        return id;
    }

    /**
     * Field id only for search in database, at this level this field is not required (greenDao produce id by itself)
     */
    public void setId(Long id) {
        this.id = id;
    }
}
