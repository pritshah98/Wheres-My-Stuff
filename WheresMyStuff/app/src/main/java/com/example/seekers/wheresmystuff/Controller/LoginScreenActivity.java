package com.example.seekers.wheresmystuff.Controller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seekers.wheresmystuff.Model.FoundItem;
import com.example.seekers.wheresmystuff.Model.LostItem;
import com.example.seekers.wheresmystuff.Model.User;
import com.example.seekers.wheresmystuff.Model.Admin;

import com.example.seekers.wheresmystuff.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * This class represents the controller for the Login Screen
 * to handle the scenarios for a successful and unsuccessful login.
 *
 */
public class LoginScreenActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button enter;
    private Button cancel;
    private boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        enter = (Button) findViewById(R.id.enterLogin);
        cancel = (Button) findViewById(R.id.cancelLogin);
        login = false;

        WelcomeScreenActivity.myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WelcomeScreenActivity.personList.getPersonList().clear();
                DataSnapshot admins = dataSnapshot.child("Admins");
                Iterable<DataSnapshot> adminsChildren = admins.getChildren();
                for (DataSnapshot admin: adminsChildren) {
                    Admin a = admin.getValue(Admin.class);
                    if (a != null) {
                        WelcomeScreenActivity.personList.getPersonList().put(a.getUsername(), a);
                    }
                }
                DataSnapshot users = dataSnapshot.child("Users");
                Iterable<DataSnapshot> usersChildren = users.getChildren();
                for (DataSnapshot user: usersChildren) {
                    User u = user.getValue(User.class);
                    if (u != null) {
                        WelcomeScreenActivity.personList.getPersonList().put(u.getUsername(), u);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (WelcomeScreenActivity.personList.getPersonList().get(user) == null) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginScreenActivity.this);
                    builder1.setMessage("Username not found in database");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else if (WelcomeScreenActivity.personList.getPersonList().get(user).isBanned()) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginScreenActivity.this);
                    builder1.setMessage("Account is banned. Email us at wheresmystuff@gatech.edu for help.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else if (WelcomeScreenActivity.personList.getPersonList().get(user).getIncorrect() < 3) {
                    if (!WelcomeScreenActivity.personList.getPersonList().get(user).isBanned() &&
                            WelcomeScreenActivity.personList.getPersonList().get(user).getPassword().equals(pass)) {
                        if (WelcomeScreenActivity.personList.getPersonList().get(user).getAccountType().equals("User")) {
                            Intent intent = new Intent(LoginScreenActivity.this, HomeScreenActivityTab.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                        } else {
                            Intent intent = new Intent(LoginScreenActivity.this, AdminScreenActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                        }
                        WelcomeScreenActivity.personList.getPersonList().get(user).resetIncorrect();
                        if (WelcomeScreenActivity.personList.getPersonList().get(user).getAccountType().equals("User")) {
                            User n = (User) WelcomeScreenActivity.personList.getPersonList().get(user);
                            WelcomeScreenActivity.myRef.child("Users").child(n.getUsername()).setValue(n);
                        } else {
                            Admin a = (Admin) WelcomeScreenActivity.personList.getPersonList().get(user);
                            WelcomeScreenActivity.myRef.child("Admins").child(a.getUsername()).setValue(a);
                        }
                        login = true;
                        finish();
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }
                if (!login && WelcomeScreenActivity.personList.getPersonList().get(user) != null
                        && !WelcomeScreenActivity.personList.getPersonList().get(user).isBanned()) {
                        int value = WelcomeScreenActivity.personList.getPersonList().get(user).getIncorrect();
                        if (value < 3) {
                            WelcomeScreenActivity.personList.getPersonList().get(user).addIncorrect();
                            int newValue = WelcomeScreenActivity.personList.getPersonList().get(user).getIncorrect();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginScreenActivity.this);
                            builder1.setMessage("Incorrect password, number of attempts remaining: " + (3 - newValue));
                            builder1.setCancelable(true);
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                            if (WelcomeScreenActivity.personList.getPersonList().get(user).getAccountType().equals("User")) {
                                User n = (User) WelcomeScreenActivity.personList.getPersonList().get(user);
                                WelcomeScreenActivity.myRef.child("Users").child(n.getUsername()).setValue(n);
                            } else {
                                Admin a = (Admin) WelcomeScreenActivity.personList.getPersonList().get(user);
                                WelcomeScreenActivity.myRef.child("Admins").child(a.getUsername()).setValue(a);
                            }
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginScreenActivity.this);
                            builder1.setMessage("Account is locked.");
                            builder1.setCancelable(true);
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
