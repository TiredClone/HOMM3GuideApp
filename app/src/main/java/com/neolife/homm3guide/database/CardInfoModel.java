package com.neolife.homm3guide.database;

public class CardInfoModel {
    private int id;
    private String name;
    private String caption;
    private int post_id; //TODO

    public CardInfoModel() {
    }

    public CardInfoModel(int id, String name, String caption, int post_id) {
        this.id = id;
        this.name = name;
        this.caption = caption;
        this.post_id = post_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCaption() {
        return caption;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    //TODO CREATE_TIME AND EDITED_TIME
}
