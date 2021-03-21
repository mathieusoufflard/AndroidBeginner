package com.mathieu.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    //private float rate;
    //private String synbol;
    private Currency currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: ");

        Intent srcIntent = getIntent();
        currency = srcIntent.getParcelableExtra("currency");
        //int flagId = srcIntent.getIntExtra("flagId", R.drawable.usflag);

        ImageView flagImageView = findViewById(R.id.flagimageView);
        flagImageView.setImageResource(currency.getFlagId());

        //rate = srcIntent.getFloatExtra("rate", 0.0f);
        //synbol = srcIntent.getStringExtra("symbol");

        //Log.i("MainActivity", "Hello Android");
        //Log.i("MainActivity", "Hello again Android");

        Button convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "convert click");
                EditText amountEditText = findViewById(R.id.amountEditText);
                String amountStr = amountEditText.getText().toString();
                Log.d("MainActivity", "amountStr =" + amountStr);

                if (amountStr.isEmpty()){
                    Toast.makeText(MainActivity.this, "Montant obligatoire", Toast.LENGTH_SHORT).show();
                    return;
                }

                float result = Float.parseFloat(amountStr) * currency.getRate();
                TextView resultText = findViewById(R.id.resultTextView);
                resultText.setText(result + " " + currency.getSymbol());
            }
        });

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            User user = new User("Bob", "bob@email.com");

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, aboutActivity.class);
                intent.putExtra("author", user);
                //intent.putExtra("name", "Mathieu");
                //intent.putExtra("email", "site.com");
                intent.putExtra("versionName", "v1.0.0");
                intent.putExtra("versionCode", 2);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }
}