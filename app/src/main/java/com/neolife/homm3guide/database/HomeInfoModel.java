package com.neolife.homm3guide.database;

public class HomeInfoModel {
    private int id;
    private int card_id;

    public HomeInfoModel() {
    }

    public HomeInfoModel(int id, int card_id) {
        this.id = id;
        this.card_id = card_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }
}
