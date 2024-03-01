package com.example.advertfire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btnBack , buttonSend;
    EditText editTextTextEmailAddress , editTextTextMultiLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                openfirstpage();
            }
        });

        buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    public void openfirstpage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void sendEmail() {
        //String[] recipient = {};
        ArrayList<String> recipients = new ArrayList<>();

        String recipient1 = editTextTextEmailAddress.getText().toString();
        recipients.add(recipient1);
        String subject = "Put your subject here";
        String content = editTextTextMultiLine.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);

        intent.setType("message/rfc822");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Email Client:"));
        } else {
            Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }

}