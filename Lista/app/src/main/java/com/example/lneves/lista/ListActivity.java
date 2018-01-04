package com.example.lneves.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lneves.lista.dao.StudentDAO;
import com.example.lneves.lista.model.Student;

import org.w3c.dom.ls.LSException;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listStudents;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> list, View item, int position, long id) {
               Student student = (Student) listStudents.getItemAtPosition(position);
               Toast.makeText(ListActivity.this, "Aluno" + student.getName() + "clicado!", Toast.LENGTH_SHORT).show();

           }
       });
        // clique longo
        listStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> listt, View item, int position, long id) {
                Toast.makeText(ListActivity.this, "Click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

            Button newStudent = (Button) findViewById(R.id.new_student);
        //acao ao botao
        newStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentForm = new Intent(ListActivity.this, FormActivity.class);
                startActivity(intentForm);
            }

        });

            loadList();
        //menu contexto ------------------------------------------
        registerForContextMenu(listStudents);

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

            //DELETAR
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
       MenuItem deletar =  menu.add("Deletar");  //referencia
         deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

              //  if (listStudents.getItemAtPosition(info.position) instanceof Student){
                    Student student = (Student)listStudents.getItemAtPosition(info.position);

                    StudentDAO dao = new StudentDAO(ListActivity.this);
                    dao.delete(student);
                    dao.close();

                    loadList();
                    return false;

                   // Toast.makeText(ListActivity.this, "Deletar aluno" + student.getName(), Toast.LENGTH_SHORT).show();
                }


            //}
        });
    }


    //Atualizar lista
   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && adapter != null){
            adapter.notifyDataSetChanged();
        }*/
    }

