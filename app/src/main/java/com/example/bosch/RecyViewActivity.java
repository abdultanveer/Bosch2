package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class RecyViewActivity extends AppCompatActivity {
ListView countriesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_view);
        countriesListView = findViewById(R.id.countrylistview);
    }
}