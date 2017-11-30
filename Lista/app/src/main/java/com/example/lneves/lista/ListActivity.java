package com.example.lneves.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] alunos = {"Label1", "Label2", "Label3"};

        ListView listStudents = (ListView) findViewById(R.id.list_students);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        listStudents.setAdapter(adapter);

        //botao
        Button newStudent = (Button) findViewById(R.id.button_save_id);
        //acao ao botao
        newStudent.setOnClickListener(new View.OnClickListener() {

            //navegacao entre telas
            @Override
            public void onClick(View v) {

                Intent intentForm = new Intent(ListActivity.this, FormActivity.class);
            }


        });
    }
}
