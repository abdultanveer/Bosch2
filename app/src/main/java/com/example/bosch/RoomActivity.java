package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bosch.database.Person;
import com.example.bosch.database.PersonDatabase;

public class RoomActivity extends AppCompatActivity {
PersonDatabase personDatabase;
EditText nameEditText;
TextView dataView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        nameEditText = findViewById(R.id.etName);
        dataView = findViewById(R.id.tvData);
        personDatabase = PersonDatabase.getDatabase(this);
    }

    public void putData(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Person person = new Person(nameEditText.getText().toString());
                personDatabase.personDao().insert(person);
            }
        }.start();
    }


    public void getData(View view) {

        new Thread(){
            @Override
            public void run() {
                super.run();
              String  name = personDatabase.personDao().getAllPersons().get(0).firstName;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dataView.setText(name);
                    }
                });
            }
        }.start();


    }
}