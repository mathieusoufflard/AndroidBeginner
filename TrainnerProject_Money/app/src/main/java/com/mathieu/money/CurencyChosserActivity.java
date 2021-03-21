package com.mathieu.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CurencyChosserActivity extends AppCompatActivity {

    public static final String TAG = "currencyChoserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curency_chosser);

        Log.i(TAG, "onCreate: ");

        findViewById(R.id.dollarsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Currency c= new Currency(R.drawable.flag_usa, 1.11f, "$");
                navigateToMainActivity(c);



                //Intent intent = new Intent(CurencyChosserActivity.this, MainActivity.class);
                //intent.putExtra("flagId", R.drawable.usflag);
                //intent.putExtra("rate", 1.11f);
                //intent.putExtra("symbol", "$");

                //startActivity(intent);
            }
        });

        findViewById(R.id.YenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Currency c= new Currency(R.drawable.flag_japan, 120.29f, "Y");
                navigateToMainActivity(c);

                //Intent intent = new Intent(CurencyChosserActivity.this, MainActivity.class);
                //intent.putExtra("flagId", R.drawable.flag_japan);
                //intent.putExtra("rate", 120.29f);
                //intent.putExtra("symbol", "Y");

                //startActivity(intent);
            }
        });

        findViewById(R.id.poundsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Currency c= new Currency(R.drawable.flag_uk, 0.91f, "£");
                navigateToMainActivity(c);

                //Intent intent = new Intent(CurencyChosserActivity.this, MainActivity.class);
                //intent.putExtra("flagId", R.drawable.flag_uk);
                //intent.putExtra("rate", 0.91f);
                //intent.putExtra("symbol", "£");

                //startActivity(intent);
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

    private void navigateToMainActivity(Currency c) {
        Intent intent = new Intent(CurencyChosserActivity.this, MainActivity.class);
        intent.putExtra("currency", c);

        //intent.putExtra("flagId", c.getFlagId());
        //intent.putExtra("rate", c.getRate());
        //intent.putExtra("symbol", c.getSymbol());
        startActivity(intent);
    }
}