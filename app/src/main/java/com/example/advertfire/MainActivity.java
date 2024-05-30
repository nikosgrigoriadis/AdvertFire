package com.example.advertfire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] recipients = {"kastnet8@gmail.com","nikos678k@gmail.com"};
        LinearLayout linearLayout = findViewById(R.id.linearLayout);


        for (String emails : recipients) {
            /*TextView textView = new TextView(this);
            textView.setTextColor(getResources().getColor(R.color.black));
            textView.setTextSize(40);

            Log.d("TextViewCreation", "TextView created with text: " + emails); */

            View view = getLayoutInflater().inflate(R.layout.activity_main, null);
            //na to kano na douleuei dynamic
            linearLayout.addView(view);

        }

        emaileditor = (Button) findViewById(R.id.emaileditor);

        // email button listener
        emaileditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemaileditor();

            }
        });
    }



    // a method to open the email editor when is clicked
    public void openemaileditor() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }




}