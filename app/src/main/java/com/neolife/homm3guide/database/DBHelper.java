package com.neolife.homm3guide.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "hmm3_info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPostQuery = "CREATE TABLE post (id INTEGER PRIMARY KEY,name TEXT, markdown_text TEXT);";
        String createCardQuery = "CREATE TABLE card (id INTEGER PRIMARY KEY,name TEXT,caption TEXT,post_id INTEGER,FOREIGN KEY(post_id) REFERENCES post(id));";
        String createHomeQuery = "CREATE TABLE home (id INTEGER PRIMARY KEY,card_id INTEGER, FOREIGN KEY(card_id) REFERENCES card(id));";
        //        String createSettingsQuery = "CREATE TABLE settings (id INTEGER RIMARY KEY,name TEXT,value TEXT);";
        db.execSQL(createPostQuery);
        db.execSQL(createCardQuery);
        db.execSQL(createHomeQuery);
//        db.execSQL(createSettingsQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }

    public List<CardInfoModel> getAllCardsFromHome() {
        List<CardInfoModel> res = new ArrayList<>();

        String query = "SELECT * FROM home;";
        SQLiteDatabase db = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do {
                int card_id = cursor.getInt(0);
                String name = cursor.getString(1);
                String caption = cursor.getString(2);
                int post_id = cursor.getInt(3);

                CardInfoModel newCard = new CardInfoModel(card_id,name,caption,post_id);
                res.add(newCard);
            }while (cursor.moveToNext());
        }  //hz che tut poka dobavity. tut kodgda nichevo ne srabotalo


        return res;
    }


    public List<CardInfoModel> getAllCards() {
        List<CardInfoModel> res = new ArrayList<>();

        String query = "SELECT * FROM card;";
        SQLiteDatabase db = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do {
                int card_id = cursor.getInt(0);
                String name = cursor.getString(1);
                String caption = cursor.getString(2);
                int post_id = cursor.getInt(3);

                CardInfoModel newCard = new CardInfoModel(card_id,name,caption,post_id);
                res.add(newCard);
            }while (cursor.moveToNext());
        }  //hz che tut poka dobavity. tut kodgda nichevo ne srabotalo


        return res;
    }

    public void removeCard(int post_id) {
        String query = "DELETE FROM card WHERE id = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query, new String[]{String.valueOf(post_id)});
        db.execSQL("DELETE FROM post WHERE id = ?", new String[]{String.valueOf(post_id)});
    }

    public void updateCardAndPost(String name, String caption, String header, String markdown_text, int post_id){
        String query = "SELECT * FROM card WHERE post_id = ?;";
        SQLiteDatabase db = this.getReadableDatabase();
        CardInfoModel res = new CardInfoModel();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(post_id)});

        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String fname = cursor.getString(1);
                String fcaption = cursor.getString(2);
                int ppost_id = cursor.getInt(3);

                res = new CardInfoModel(id, fname, fcaption, ppost_id);
            } while (cursor.moveToNext());
        } else {
            return;
        }

        ContentValues values = new ContentValues();
        values.put("name",header);
        values.put("markdown_text",markdown_text);

        ContentValues values2 = new ContentValues();
        values2.put("name",name);
        values2.put("caption",caption);

        db.update("post",values,"id = ?", new String[]{String.valueOf(post_id)});
        db.update("card",values2,"id = ?", new String[]{String.valueOf(res.getPost_id())});
    }

    public void createCardAndPost(String name, String caption, String header, String markdown_text) {
        String queryCreateCard = "INSERT INTO card (name, caption, post_id) VALUES (?,?,?)";

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",header);
        values.put("markdown_text",markdown_text);
        long t = db.insert("post", null, values);
        Log.d("info", String.valueOf(t));
        db.execSQL(queryCreateCard, new String[]{name, caption, String.valueOf(t)});
    }

    public PostInfoModel getPostById(int post_id) {

        String query = "SELECT * FROM post WHERE id = ?;";
        SQLiteDatabase db = this.getReadableDatabase();
        PostInfoModel res = new PostInfoModel(9999999, "untitled", "There's no **TEXT**");
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(post_id)});

        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String text = cursor.getString(2);

                res = new PostInfoModel(id, name, text);
            } while (cursor.moveToNext());
        }

        return res;
    }

    public CardInfoModel getCardById(int post_id) {

        String query = "SELECT * FROM card WHERE post_id = ?;";
        SQLiteDatabase db = this.getReadableDatabase();
        CardInfoModel res = new CardInfoModel();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(post_id)});

        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String caption = cursor.getString(2);
                int ppost_id = cursor.getInt(3);

                res = new CardInfoModel(id, name, caption, ppost_id);
            } while (cursor.moveToNext());
        }

        return res;
    }

}
