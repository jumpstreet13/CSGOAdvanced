package com.asuper.abocha.cs_go.Model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class GameMap {

    @Id
    private Long id;

    private String shortDescription;
    private String longDescription;
    private int image;
    private String smokes;
    private String flashbangs;
    private String molotovs;


    public GameMap(String shortDescription, String longDescription, int image, String smokes, String flashbangs, String molotovs) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }


    @Generated(hash = 1525961820)
    public GameMap(Long id, String shortDescription, String longDescription, int image, String smokes, String flashbangs,
            String molotovs) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }


    @Generated(hash = 1289771811)
    public GameMap() {
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

    public String getSmokes() {
        return smokes;
    }

    public void setSmokes(String smokes) {
        this.smokes = smokes;
    }

    public String getFlashbangs() {
        return flashbangs;
    }

    public void setFlashbangs(String flashbangs) {
        this.flashbangs = flashbangs;
    }

    public String getMolotovs() {
        return molotovs;
    }

    public void setMolotovs(String molotovs) {
        this.molotovs = molotovs;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
