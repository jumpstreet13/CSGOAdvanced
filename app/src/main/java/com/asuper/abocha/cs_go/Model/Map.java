package com.asuper.abocha.cs_go.Model;


public class Map {

   private String shortDescription;
   private String longDescription;
   private int image;

    public Map(String shortDescription, String longDescription, int image) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
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
}
