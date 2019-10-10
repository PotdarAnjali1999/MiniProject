package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;
public class Registration_Admin extends  AppCompatActivity  implements View.OnClickListener {

//The view objects
private EditText editTextName, editTextAddress, editTextMobile,editTextMessname,
        editTextPassword;

private Button buttonSubmit;
SQLiteOpenHelper openHelper;
SQLiteDatabase db;


//defining AwesomeValidation object
private AwesomeValidation awesomeValidation;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__admin);

        //initializing awesomevalidation object
        /*
         * The library provides 3 types of validation
         * BASIC
         * COLORATION
         * UNDERLABEL
         * */
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //initializing view objects
        editTextName = (EditText) findViewById(R.id.uname);
       editTextAddress = (EditText) findViewById(R.id.address);
        editTextPassword = (EditText) findViewById(R.id.pass);
        editTextMobile = (EditText) findViewById(R.id.cno);
        editTextMessname=(EditText) findViewById(R.id.mess);

        buttonSubmit = (Button) findViewById(R.id.createbtn);
        openHelper=new DatabaseHelper(this);


        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.uname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
       // awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.pass, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.cno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.mess, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);



        buttonSubmit.setOnClickListener(this);
        }

private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
                Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), CALogin.class);
                startActivity(i);
        }
                else
        {

                        Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show();

        //process the data further
        }
        }

@Override
public void onClick(View view) {
        if (view == buttonSubmit) {
        submitForm();
        db=openHelper.getWritableDatabase();
        String Uname=editTextName.getText().toString();
        String Contact_No=editTextMobile.getText().toString();
        String Password=editTextPassword.getText().toString();
        String Address=editTextAddress.getText().toString();
        String Messname=editTextMessname.getText().toString();
        insertdata(Uname,Contact_No,Password,Address,Messname);

        }}

        public  void insertdata(String Uname,String Contact_No,String Password,String Address,String Messname)
        {
                ContentValues cosssntentValues=new ContentValues();
                ContentValues.put(DatabaseHelper.COL_1,Uname);
                ContentValues.put(DatabaseHelper.COL_2,Contact_No);
                ContentValues.put(DatabaseHelper.COL_3,Password);
                ContentValues.put(DatabaseHelper.COL_4,Address);

                long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        }

}