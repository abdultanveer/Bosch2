package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class RecyViewActivity extends AppCompatActivity {
    RecyclerView countriesRecyclerView;
    String[] countries = {"India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",
            "India","usa", "uk","france","India","usa", "uk","france","India","usa", "uk","france",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_view);
        countriesRecyclerView = findViewById(R.id.countrylistview);

    }

    @Override
    protected void onStart() {
        super.onStart();
        CountriesAdapter adapter = new CountriesAdapter(countries);

        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        countriesRecyclerView.setAdapter(adapter);
    }
}