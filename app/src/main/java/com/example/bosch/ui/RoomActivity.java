package com.example.bosch.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bosch.Aquarium;
import com.example.bosch.R;
import com.example.bosch.database.Person;

public class RoomActivity extends AppCompatActivity {
//PersonDatabase personDatabase;
EditText nameEditText;
TextView dataView;
RoomViewModel roomViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Aquarium mAquarium = new Aquarium(getApplication(),getLifecycle());
        roomViewModel = new RoomViewModel(getApplication());
        nameEditText = findViewById(R.id.etName);
        dataView = findViewById(R.id.tvData);

         roomViewModel.getAllPersons().observe(this,
            listPersons -> dataView.setText(listPersons.get(0).firstName));
      //  personDatabase = PersonDatabase.getDatabase(this);
    }

    public void putData(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Person person = new Person(nameEditText.getText().toString());
                roomViewModel.insert(person);
                //personDatabase.personDao().insert(person);
            }
        }.start();
    }


    public void getData(View view) {

        new Thread(){
            @Override
            public void run() {
                super.run();
             // String  name = personDatabase.personDao().getAllPersons().get(0).firstName;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // dataView.setText(name);
                    }
                });
            }
        }.start();


    }
}