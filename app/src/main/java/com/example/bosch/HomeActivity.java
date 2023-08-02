package com.example.bosch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    public static String TAG = HomeActivity.class.getSimpleName();
    BroadcastReceiver smsReceiver;
    TextView conTextView;
    EditText conEditText;

    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); //inflation -- baloon --layoutinflater
        Log.i(TAG, "im in oncreate");
        //  inflation();
        conTextView = findViewById(R.id.tvContact);  //taking handle on the textview
        conEditText = findViewById(R.id.etContact);
        conEditText.setOnFocusChangeListener(this);
        Button conButton = findViewById(R.id.btnContact);

        conButton.setOnClickListener(this);

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
        Log.e(TAG, "im in onstart-- user interacting");
        int c = add(10, 20);
        smsReceiver = new SmsReceiver();
        registerReceiver(smsReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }


    private int add(int i, int i1) {
        for (int k = 0; k < 10; k++) {
            int d = i * 20;
            int j = i1 * 33;
        }

        return i + i1;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "im in onpause-- save state of app");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "im in onresume -- restore the state app");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "im in onstop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "im in ondestroy -- release resources");
        unregisterReceiver(smsReceiver);

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
        pIntent.putExtra("phnum", phno);
        setResult(RESULT_OK, pIntent);
        //finish this activity
        add(10, 20);
        // finish();
        throw new NullPointerException("crash demo");

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("phno", "234567");
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "button was clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if (isFocussed) {
            Log.i(TAG, "is focussed");
            Toast.makeText(this, "view is focussed", Toast.LENGTH_SHORT).show();
        } else {
            Log.i(TAG, "lost focussed");

            Toast.makeText(this, "view lost focussed", Toast.LENGTH_SHORT).show();

        }

    }

    public void handleServices(View view) {
        Intent serviceIntent = new Intent(this, MyService.class);
        serviceIntent.putExtra("b2key", "http://imageurl.com");
        startService(serviceIntent);
    }

    public void stopService(View view) {
        Intent serviceIntent = new Intent(this, MyService.class);
        stopService(serviceIntent);

    }

    public void bindServis(View view) {
        Intent serviceIntent = new Intent(this, MyService.class);
        bindService(serviceIntent, serviceConnection, BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder localBinder) {
            MyService.LocalBinder  binder = (MyService.LocalBinder)localBinder;
            //im not instantiating MyService class instead im gettting that already existing object thro localBinder
            myService = binder.getService();
           int result = myService.add(10,20);
           Log.i(TAG, "sum = "+result);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}