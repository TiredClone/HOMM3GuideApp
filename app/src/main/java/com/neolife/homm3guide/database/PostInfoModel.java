package com.neolife.homm3guide.database;

public class PostInfoModel {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String text;

    public PostInfoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PostInfoModel(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }
//TODO images or smth other
}
