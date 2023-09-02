package com.example.bosch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        //location of the  db, inbox = table name
        Uri uriSms = Uri.parse("content://sms/inbox");
        //select * from inbox
        Cursor cursor = getContentResolver().query(uriSms, null,null,null,null);
        ContentRVAdapter adapter = new ContentRVAdapter(cursor);
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}