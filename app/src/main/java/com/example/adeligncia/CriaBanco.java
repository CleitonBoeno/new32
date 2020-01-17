package com.example.adeligncia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO="banco.db";
    public static final String TABELA="usuarios";
    public static final String ID="id";
    public static final String NOME="nome";
    public static final String MAIL="mail";
    public static final String SENHA="senha";
    private static final int VERSAO=2;

    public CriaBanco(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql= "CREATE TABLE "+TABELA+"("
                +ID+"integer primary key autoincrement,"
                +NOME+"text,"
                +MAIL+"text,"
                +SENHA+"text"
                +")";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE [IF EXISTS]."+TABELA);
        onCreate(db);
    }
}

