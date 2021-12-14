package com.example.bodycalculator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "BodyCalcLite";

    public static final String TABLE_RESULTS = "body_result";


    public static final String KEY_ID = "_id";

    public static final String KEY_RESULT_JSON = "key_result";

    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_RESULTS +
                "(" + KEY_ID + " integer primary key," + KEY_RESULT_JSON + " text " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_RESULTS);
        onCreate(db);
    }
}
