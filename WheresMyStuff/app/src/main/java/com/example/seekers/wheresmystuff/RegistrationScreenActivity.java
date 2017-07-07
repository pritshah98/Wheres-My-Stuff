package com.example.seekers.wheresmystuff;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * This class represents the controller for the Registration Screen
 * to handle the scenarios for a successful and unsuccessful registration.
 *
 */
public class RegistrationScreenActivity extends AppCompatActivity {

    private EditText enterName;
    private EditText enterUsername;
    private EditText enterPassword;
    private Button registrationEnter;
    private RadioButton userAccountType;
    private RadioButton adminAccountType;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        enterName = (EditText) findViewById(R.id.enterName);
        enterUsername = (EditText) findViewById(R.id.enterUsername);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        registrationEnter = (Button) findViewById(R.id.registrationEnter);
        userAccountType = (RadioButton) findViewById(R.id.userAccountType);
        adminAccountType = (RadioButton) findViewById(R.id.adminAccountType);
        cancel = (Button) findViewById(R.id.registrationCancel);

        registrationEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account;
                String newUserName = enterUsername.getText().toString();
                String newPassword = enterPassword.getText().toString();

                if (userAccountType.isChecked()) {
                    account = "User";
                    User newUser = new User(enterName.getText().toString(),
                            newUserName, newPassword, account);
                    WelcomeScreenActivity.myRef.child("Users").child(newUserName).setValue(newUser);
                    WelcomeScreenActivity.personList.getPersonList().put(newUser.getUsername(), newUser);
                    showAlert();
                    finish();
                } else {
                    account = "Admin";
                    Admin newAdmin = new Admin(enterName.getText().toString(),
                            newUserName, newPassword, account);
                    WelcomeScreenActivity.myRef.child("Admins").child(newUserName).setValue(newAdmin);
                    WelcomeScreenActivity.personList.getPersonList().put(newAdmin.getUsername(), newAdmin);
                    showAlert();
                    finish();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void showAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationScreenActivity.this);
        builder1.setMessage("Registration Successful");
        builder1.setCancelable(true);
        AlertDialog alert11 = builder1.create();
        alert11.show();
        finish();
    }

}
