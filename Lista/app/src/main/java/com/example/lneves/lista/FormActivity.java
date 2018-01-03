package com.example.lneves.lista;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.lneves.lista.dao.StudentDAO;
import com.example.lneves.lista.model.Student;

public class FormActivity extends AppCompatActivity {

    EditText mName;
    EditText mPhone;
    EditText mSite;
    EditText mAddress;
    RatingBar mRating;
    Button mButton;
    private FormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //instanciando formHelper
        //alt+enter e criar field
        this.helper = new FormHelper(this);


    }
    //Utilizando menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String fieldsToFill = "";

        //distinção para que outros menus nao tenham msm comportamento
        switch (item.getItemId()) {

            case R.id.menu_form:
                EditText editTextName = (EditText) findViewById(R.id.name_id);
                if (editTextName.length() == 0) {
                     fieldsToFill += "nome";
                }

                EditText address = (EditText) findViewById(R.id.address_id);
                if (address.length() == 0) {

                    if (fieldsToFill.length() > 0) fieldsToFill += ", ";
                    fieldsToFill += "endereço";
                }

                EditText phone = (EditText) findViewById(R.id.phone_id);

                if (phone.length() == 0){

                    if (fieldsToFill.length() > 0) fieldsToFill += ", ";
                    fieldsToFill += "telefone";
                }

                EditText site = (EditText) findViewById(R.id.site_id);

                if (site.length() == 0) {
                   if (fieldsToFill.length() > 0) fieldsToFill += ", ";
                    fieldsToFill += "site";
                }

                if (fieldsToFill.length() > 0) {
                    Toast.makeText(this, "Campos necessários: " + fieldsToFill, Toast.LENGTH_SHORT).show();
                    return false;
                }



                //utilizando helper
                Student student = helper.getStudent();//metodo devolve objeto student que contem os dados
                //instanciar  dao e insere o novo aluno no banco
                StudentDAO dao = new StudentDAO(this);
                dao.insert(student);
                dao.close(); //fecha conexao com BD
                Toast.makeText(FormActivity.this, "Aluno " + student.getName() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
