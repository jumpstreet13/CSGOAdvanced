package com.asuper.abocha.cs_go.Data;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;


@Entity
public class GameDaoMap {

    @Id
    private Long id;

    private String shortDescription;
    private String longDescription;
    private int image;
    private String smokes;
    private String flashbangs;
    private String molotovs;


    public GameDaoMap(String shortDescription, String longDescription, int image, String smokes, String flashbangs, String molotovs) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }


    @Generated(hash = 19001181)
    public GameDaoMap(Long id, String shortDescription, String longDescription, int image, String smokes, String flashbangs,
            String molotovs) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.smokes = smokes;
        this.flashbangs = flashbangs;
        this.molotovs = molotovs;
    }


    @Generated(hash = 903250481)
    public GameDaoMap() {
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
