package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class RecyViewActivity extends AppCompatActivity {

    String[] countries = {"India","usa", "uk","france"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_view);
        RecyclerView countriesRecyclerView = findViewById(R.id.countrylistview);
        CountriesAdapter adapter = new CountriesAdapter(countries);

        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        countriesRecyclerView.setAdapter(adapter);

    }
}