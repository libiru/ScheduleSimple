package com.example.lneves.lista;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.lneves.lista.model.Student;

/**
 * Created by lneves on 11/28/2017.
 */

public class FormHelper {

    private final EditText addressField;
    private final EditText siteField;
    private final EditText phoneField;
    private final RatingBar evaluationField;
    private final EditText nameField;


    public FormHelper(FormActivity activity){
        nameField = (EditText) activity.findViewById(R.id.address_id);
        addressField = (EditText) activity.findViewById(R.id.address_id);
        siteField = (EditText) activity.findViewById(R.id.site_id);
        phoneField = (EditText) activity.findViewById(R.id.phone_id);
        evaluationField = (RatingBar) activity.findViewById(R.id.rating_bar_id);
    }

    public Student getStudent() {
        Student student = new Student();
        
        student.setName(nameField.getText().toString());
        student.setAddress(addressField.getText().toString());
        student.setPhone(phoneField.getText().toString());
        student.setSite(siteField.getText().toString());
        student.setAvaliation(Double.valueOf(evaluationField.getProgress()));
        return null;
    }
}
