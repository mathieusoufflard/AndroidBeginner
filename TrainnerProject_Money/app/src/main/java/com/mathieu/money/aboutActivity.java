package com.mathieu.money;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // recuperation des info depuis intent source
        Intent srcIntent = getIntent();
        User u= srcIntent.getParcelableExtra("author");
        //String name = srcIntent.getStringExtra("name");
        //String email = srcIntent.getStringExtra("email");
        String versionName = srcIntent.getStringExtra("versionName");
        int versionCode = srcIntent.getIntExtra("versionCode", 1);

        // MAJ de l'UI

        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText(u.name);
        TextView emailTextView = findViewById(R.id.siteTextView);
        emailTextView.setText(u.email);
        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText(versionCode + "" + versionName);


    }
}