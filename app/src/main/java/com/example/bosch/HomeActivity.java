package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public static String TAG = HomeActivity.class.getSimpleName();
    TextView conTextView;
    EditText conEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); //inflation -- baloon --layoutinflater
        Log.i(TAG,"im in oncreate");
      //  inflation();
        conTextView = findViewById(R.id.tvContact);  //taking handle on the textview
        conEditText = findViewById(R.id.etContact);

        //get the intent which started this activity
        //from that intent get the extras
        //get the string extra with key makey
      /*  String data =  getIntent().getExtras().getString("makey");

        //put that string onto the textview
        conTextView.setText(data);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"im in onstart-- user interacting");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"im in onpause-- save state of app");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"im in onresume -- restore the state app");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"im in onstop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"im in ondestroy -- release resources");

    }

    private void inflation() {
        EditText conedEditText = new EditText(this);
        conedEditText.setHint("enter contact");
        Button conButton = new Button(this);
        conButton.setText("contact");
        TextView conTextView = new TextView(this);
        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        constraintLayout.addView(conedEditText);
    }

    public void handleContact(View view) {
        //get the data from edittext
        String phno = conEditText.getText().toString();
        //put the data into an intent
        Intent pIntent = new Intent();
        pIntent.putExtra("phnum",phno);
        setResult(RESULT_OK,pIntent);
        //finish this activity
        finish();
    }
}