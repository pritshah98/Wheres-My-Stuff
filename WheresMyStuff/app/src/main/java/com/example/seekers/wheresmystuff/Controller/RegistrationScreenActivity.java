package com.example.seekers.wheresmystuff.Controller;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.seekers.wheresmystuff.Model.Admin;
import com.example.seekers.wheresmystuff.Model.User;
import com.example.seekers.wheresmystuff.R;

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
    private EditText enterCode;

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
        enterCode = (EditText) findViewById(R.id.adminCodeInput);

        registrationEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account;
                String newUserName = enterUsername.getText().toString();
                String newPassword = enterPassword.getText().toString();
                String code = enterCode.getText().toString();

                if (WelcomeScreenActivity.personList.getPersonList().containsKey(newUserName)) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationScreenActivity.this);
                    builder1.setMessage("Username already taken.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }  else if (newUserName.length() == 0) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationScreenActivity.this);
                    builder1.setMessage("Username not entered in.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else if (newPassword.length() < 5) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationScreenActivity.this);
                    builder1.setMessage("Password length must be greater than 4.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    if (userAccountType.isChecked()) {
                        account = "User";
                        User newUser = new User(enterName.getText().toString(),
                                newUserName, newPassword, account);
                        WelcomeScreenActivity.myRef.child("Users").child(newUserName).setValue(newUser);
                        WelcomeScreenActivity.personList.getPersonList().put(newUser.getUsername(), newUser);
                        showAlert();
                        finish();
                        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                    } else {
                        if (code.equals("cs2340")) {
                            account = "Admin";
                            Admin newAdmin = new Admin(enterName.getText().toString(),
                                    newUserName, newPassword, account);
                            WelcomeScreenActivity.myRef.child("Admins").child(newUserName).setValue(newAdmin);
                            WelcomeScreenActivity.personList.getPersonList().put(newAdmin.getUsername(), newAdmin);
                            showAlert();
                            finish();
                            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationScreenActivity.this);
                            builder1.setMessage("Incorrect code entered.");
                            builder1.setCancelable(true);
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
