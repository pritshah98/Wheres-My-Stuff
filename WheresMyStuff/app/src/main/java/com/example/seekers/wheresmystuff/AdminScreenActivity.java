package com.example.seekers.wheresmystuff;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class that handles admin start-up screen,
 * allows admin to ban or un-ban a User
 */
public class AdminScreenActivity extends AppCompatActivity {

    private EditText banUser;
    private EditText unbanUser;
    private Button banUserButton;
    private Button unbanUserButton;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);

        banUser = (EditText) findViewById(R.id.banUserText);
        unbanUser = (EditText) findViewById(R.id.unbanUserText);
        banUserButton = (Button) findViewById(R.id.banUserButton);
        unbanUserButton = (Button) findViewById(R.id.unbanUserButton);
        logout = (Button) findViewById(R.id.adminLogout);

        banUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String banUsername = banUser.getText().toString();

                if (WelcomeScreenActivity.personList.getPersonList().get(banUsername) == null) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AdminScreenActivity.this);
                    builder1.setMessage("Username not found in database");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else if (!WelcomeScreenActivity.personList.getPersonList().get(banUsername).isBanned()
                        && WelcomeScreenActivity.personList.getPersonList().get(banUsername) != null) {
                    WelcomeScreenActivity.personList.getPersonList().get(banUsername).setBanned(true);
                    User n = (User) WelcomeScreenActivity.personList.getPersonList().get(banUsername);
                    WelcomeScreenActivity.myRef.child("Users").child(n.getUsername()).setValue(n);
                }
            }
        });

        unbanUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String unbanUsername = unbanUser.getText().toString();

                if (WelcomeScreenActivity.personList.getPersonList().get(unbanUsername) == null) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AdminScreenActivity.this);
                    builder1.setMessage("Username not found in database");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else if (WelcomeScreenActivity.personList.getPersonList().get(unbanUsername).isBanned()
                        && WelcomeScreenActivity.personList.getPersonList().get(unbanUsername) != null) {
                    WelcomeScreenActivity.personList.getPersonList().get(unbanUsername).setBanned(false);
                    User n = (User) WelcomeScreenActivity.personList.getPersonList().get(unbanUsername);
                    WelcomeScreenActivity.myRef.child("Users").child(n.getUsername()).setValue(n);
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
