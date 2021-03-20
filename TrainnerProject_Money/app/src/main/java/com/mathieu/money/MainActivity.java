package com.mathieu.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i("MainActivity", "Hello Android");
        //Log.i("MainActivity", "Hello again Android");

        Button convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "convert click");
                EditText amountEditText = findViewById(R.id.amountEditText);
                String amountStr = amountEditText.getText().toString();
                Log.d("MainActivity", "amountStr =" + amountStr);

                if (amountStr.isEmpty()){
                    Toast.makeText(MainActivity.this, "Montant obligatoire", Toast.LENGTH_SHORT).show();
                    return;
                }

                float result = Float.parseFloat(amountStr) * 0.84f;
                TextView resultText = findViewById(R.id.resultTextView);
                resultText.setText(result + " $");
            }
        });

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, aboutActivity.class);
                startActivity(intent);
            }
        });
    }
}