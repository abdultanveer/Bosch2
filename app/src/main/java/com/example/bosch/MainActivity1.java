package com.example.bosch;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {
        startHome();
        /*switch (view.getId()){
            case R.id.btnSubmit:
                startHome();

                break;
            case R.id.btnDial:*/
               /* Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));
                startActivity(dialIntent);*/

       // createAlarm("demo alarm",22,43);
      /*  Intent myIntent = new Intent("ineed.water"); //implicit intent
        startActivity(myIntent);*/



    }

    private  void startHome() {
       // Toast.makeText(this, "welcome to android", Toast.LENGTH_SHORT).show();
        //explicit intent
        Intent homeIntent = new Intent(this, HomeActivity.class);  //my intention is to launch homeactivity
      // homeIntent.putExtra("makey","android bosch automotive");  //data
        startActivityForResult(homeIntent,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String phno = data.getStringExtra("phnum");
        TextView resView = findViewById(R.id.tvResult);
        resView.setText(phno);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
