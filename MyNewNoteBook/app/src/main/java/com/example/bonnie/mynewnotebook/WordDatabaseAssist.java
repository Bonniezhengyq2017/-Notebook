package com.example.bonnie.mynewnotebook;

// 数据库辅助类

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class WordDatabaseAssist extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "wordsdb";//数据库名字
    private final static int DATABASE_VERSION = 1;//数据库版本

    //建表SQL
    //表： Words.Word.TABLE_NAME 
    //该表中共4个字段：_ID,COLUMN_NAME_ENG,COLUMN_NAME_FRE,COLUMN_NAME_DOMAIN
    private final static String SQL_CREATE_DATABASE = "CREATE TABLE " +
            WordDatabaseInfo.Word.TABLE_NAME + " (" +
            WordDatabaseInfo.Word._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            WordDatabaseInfo.Word.COLUMN_NAME_ENG + " TEXT" + "," +
            WordDatabaseInfo.Word.COLUMN_NAME_FRE + " TEXT" + ","+
            WordDatabaseInfo.Word.COLUMN_NAME_DOMAIN + " TEXT" + " )";
    //删表SQL
    private final static String SQL_DELETE_DATABASE = "DROP TABLE IF EXISTS " + WordDatabaseInfo.Word.TABLE_NAME;

    public WordDatabaseAssist(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建数据库
        sqLiteDatabase.execSQL(SQL_CREATE_DATABASE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //当数据库升级时被调用，首先删除旧表，然后调用OnCreate()创建新表
        sqLiteDatabase.execSQL(SQL_DELETE_DATABASE);
        onCreate(sqLiteDatabase);
    }
}
