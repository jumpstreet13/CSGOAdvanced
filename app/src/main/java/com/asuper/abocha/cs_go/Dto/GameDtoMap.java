package com.asuper.abocha.cs_go.Dto;


import java.util.List;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

public class GameDtoMap {

    private int idForSearch;
    private String shortDescription;
    private String longDescription;
    private int image;
    private List<Integer> smokes;
    private List<Integer> flashbangs;
    private List<Integer> molotovs;

    public GameDtoMap() {
    }

    public GameDtoMap(int id,String shortDescription, String longDescription, int image, List<Integer> smokes,
                      List<Integer> flashbangs, List<Integer>molotovs) {
        this.idForSearch = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }


    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public int getImage() {
        return image;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
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

    public int getIdForSearch() {
        return idForSearch;
    }

    public void setIdForSearch(int idForSearch) {
        this.idForSearch = idForSearch;
    }
}
