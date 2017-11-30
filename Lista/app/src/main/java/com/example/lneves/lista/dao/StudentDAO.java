package com.example.lneves.lista.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lneves on 11/28/2017.
 */

public class StudentDAO extends SQLiteOpenHelper {

    public StudentDAO(Context context) { //construtor
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //criar BD
        //criar tabela
        String sql = "CREATE TABLE Student (id INTEGER PRIMARY KEY, name TEXT NOT NULL, address TEXT, phone TEXT, site TEXT, phone TEXT, evaluation REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //versaoBD
        String sql = "DROP TABLE IF EXITS Students";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Student student) {
        
        SQLiteDatabase db = getWritableDatabase();


    }

}
