package com.example.bonnie.mynewnotebook;

//数据库类
import android.provider.BaseColumns;

public class WordDatabaseInfo {
    public static abstract class Word implements BaseColumns {
        public static final String TABLE_NAME = "words";
        public static final String COLUMN_NAME_ENG = "eng";
        public static final String COLUMN_NAME_FRE = "fre";
        public static final String COLUMN_NAME_DOMAIN = "domain";
    }
}
