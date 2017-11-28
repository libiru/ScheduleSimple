package com.example.lneves.lista;

import android.content.Intent;
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

         helper = new FormHelper(this);



           }
                @Override
                public boolean onCreateOptionsMenu(Menu menu) {
                   MenuInflater inflater= getMenuInflater();
                    inflater.inflate(R.menu.main_menu, menu);
                    return super.onCreateOptionsMenu(menu);
                }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_form:

                Student student = helper.getStudent();
                Toast.makeText(FormActivity.this, "Aluno" + student.getName()+ "Salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
