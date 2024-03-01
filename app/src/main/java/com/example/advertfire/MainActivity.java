package com.example.advertfire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    private  Button emaileditor , testbutton ;

    private int save_state = 0;
    TextView youremailis , email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emaileditor = (Button) findViewById(R.id.emaileditor);
        testbutton = (Button) findViewById(R.id.testbutton);


        // email button listener
        emaileditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemaileditor();

            }
        });
        // test button listener
        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reverseImageText ();
            }
        });
    }


    // a method to open the email editor when is clicked
    public void openemaileditor() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void loginsuccesfully() {
        reverseImageText();
    }


    //a method to disappear the google photo when login successfully and show the email
    public void reverseImageText() {

        youremailis = findViewById(R.id.youremailis);
        email = findViewById(R.id.email);

        if (save_state == 0) {

            youremailis.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            save_state = 1;
        }
        else {

            youremailis.setVisibility(View.GONE);
            email.setVisibility(View.GONE);
            save_state = 0;
        }

    }



}