package com.example.lneves.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lneves.lista.dao.StudentDAO;
import com.example.lneves.lista.model.Student;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listStudents;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button newStudent = (Button) findViewById(R.id.new_student);
        //acao ao botao
        newStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentForm = new Intent(ListActivity.this, FormActivity.class);
                startActivity(intentForm);
            }

        });

    }
        //refactor > extract > method
    private void loadList() { //carrega lista
        //buscaaluno
        StudentDAO dao = new StudentDAO(this);
        List<Student> student = dao.searchStudent();
        dao.close();

        //popula lista
        listStudents = (ListView) findViewById(R.id.list_students);
        adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, student);
        //joga na lista
        listStudents.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadList();
    }

    //Atualizar lista
   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && adapter != null){
            adapter.notifyDataSetChanged();
        }*/
    }

