package com.neolife.homm3guide.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
//        String createSettingsQuery = "CREATE TABLE settings (id INTEGER PRIMARY KEY,name TEXT,value TEXT);";
        db.execSQL(createPostQuery);
        db.execSQL(createCardQuery);

        db.execSQL("INSERT INTO post (name, markdown_text) values ('test bro test', '# Markdown Example\n" +
                "\n" +
                "This is a **Markdown** example demonstrating various formatting options:\n" +
                "\n" +
                "## Lists\n" +
                "\n" +
                "- **Ordered List:**\n" +
                "  1. First item\n" +
                "  2. Second item\n" +
                "  3. Third item\n" +
                "\n" +
                "- **Unordered List:**\n" +
                "  - Item 1\n" +
                "  - Item 2\n" +
                "  - Item 3\n" +
                "\n" +
                "## Text Formatting\n" +
                "\n" +
                "- *Italic Text*\n" +
                "- **Bold Text**\n" +
                "- ~~Strikethrough Text~~\n" +
                "\n" +
                "## Links and Images\n" +
                "\n" +
                "- [Link to Google](https://www.google.com)\n" +
                "- ![Markdown Logo](https://markdown-here.com/img/icon256.png)\n" +
                "\n" +
                "## Code\n" +
                "\n" +
                "Inline code: `print(\"Hello, Markdown!\")`\n" +
                "\n" +
                "Block code:\n" +
                "```python\n" +
                "def greet():\n" +
                "    print(\"Hello, Markdown!\")\n" +
                "greet() ')");
        db.execSQL("INSERT INTO card (name, caption, post_id) values ('test', 'wow, test', 1)");
        db.execSQL("INSERT INTO card (name, caption) values ('omagadable', 'this is amazing')");
//        db.execSQL(createSettingsQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
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
        } else {
            //hz che tut poka dobavity. tut kodgda nichevo ne srabotalo
        }

        return res;
    }

    public PostInfoModel getPostById(int post_id) {
        PostInfoModel res = new PostInfoModel();

        String query = "SELECT * FROM post WHERE id = ?;";
        SQLiteDatabase db = this.getReadableDatabase();

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


}
