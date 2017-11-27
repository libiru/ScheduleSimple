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

public class FormActivity extends AppCompatActivity {

    EditText mName;
    EditText mPhone;
    EditText mSite;
    EditText mAddress;
    RatingBar mRating;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
       /* EditText mName = (EditText) findViewById(R.id.name_id);
        EditText mPhone = (EditText) findViewById(R.id.phone_id);
        EditText mSite = (EditText) findViewById(R.id.site_id);
        EditText mAddress = (EditText) findViewById(R.id.address_id);
        RatingBar mRating = (RatingBar) findViewById(R.id.rating_bar_id);
        Button mButton = (Button) findViewById(R.id.button_save_id);*/


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
                Toast.makeText(FormActivity.this, "Salvar", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
