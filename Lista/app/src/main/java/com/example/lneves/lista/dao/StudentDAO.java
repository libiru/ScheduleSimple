package com.example.lneves.lista.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lneves.lista.model.Student;

import java.util.ArrayList;
import java.util.List;

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
        String sql = "CREATE TABLE Student (id INTEGER PRIMARY KEY, name TEXT NOT NULL, address TEXT, phone TEXT, site TEXT, evaluation REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //atualizar BD ...versaoBD
        String sql = "DROP TABLE IF EXITS Students";
        db.execSQL(sql);
        onCreate(db);//recria tabela
    }

    public void insert(Student student) {
        
        SQLiteDatabase db = getWritableDatabase(); //referencia ao BD

        ContentValues data = new ContentValues();
        data.put("name",student.getName()); //coluna , conteudo
        data.put("address",student.getAddress());
        data.put("phone",student.getPhone());
        data.put("site",student.getSite());
        data.put("evaluation",student.getAvaliation());

        db.insert("Student",null, data); //tabela


    }


    public List<Student> searchStudent() {
        String sql = "SELECT * FROM Student;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery (sql, null);

        List<Student> students = new ArrayList<Student>();
        while (c.moveToNext()){ //mover prox linha
            Student student = new Student(); //instancia aluno
            student.setId(c.getLong(c.getColumnIndex("id")));
            student.setName(c.getString(c.getColumnIndex("name")));
            student.setAddress(c.getString(c.getColumnIndex("address")));
            student.setPhone(c.getString(c.getColumnIndex("phone")));
            student.setSite(c.getString(c.getColumnIndex("site")));
            student.setAvaliation(c.getDouble(c.getColumnIndex("evaluation")));


               students.add(student); //colocando na List<>
        }
                c.close(); //encerrar o cursos
                return students;
    }
}
