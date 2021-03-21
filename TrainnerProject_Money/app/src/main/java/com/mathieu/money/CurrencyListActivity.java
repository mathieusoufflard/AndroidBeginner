package com.mathieu.money;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListActivity extends AppCompatActivity {

    private List<Currency> currencies;
    private  CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        currencies = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            //currencies.add(new Currency(R.drawable.flag_usa, 1.11f, "$"));
            //currencies.add(new Currency(R.drawable.flag_japan, 120.29f, "Y"));
            currencies.add(new Currency(R.drawable.flag_uk, 0.91f, "£"));
        }
            adapter = new CurrencyAdapter(currencies);

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}