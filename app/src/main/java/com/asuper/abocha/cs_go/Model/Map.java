package com.asuper.abocha.cs_go.Model;


import java.util.List;

public class Map {

   private String shortDescription;
   private String longDescription;
   private int image;
   private List<Integer> images;

    public Map(String shortDescription, String longDescription, int image, List<Integer> advantages) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.images = advantages;
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

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }
}
