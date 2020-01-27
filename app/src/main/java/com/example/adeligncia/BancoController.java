package com.example.adeligncia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;
    private static final String NOME = "nome";
    private static final String TABELA = "usuarios";
    private static final String ID = "_id";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";
    private static final int VERSAO = 4;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, String mail, String senha) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put(SENHA, senha);
        valores.put(NOME, nome);
        valores.put(EMAIL, mail);



        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }

    public Cursor fazerLogin (String email, String senha){
        db= banco.getWritableDatabase();
        String sql= "SELECT * FROM "+TABELA+" WHERE "+EMAIL+"= ? AND "+SENHA+"= ?";
        String[] selectionArgs= new String[]{email, senha};
        Cursor cursor= db.rawQuery(sql,selectionArgs);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        }else{
            return null;
        }
    }
}




