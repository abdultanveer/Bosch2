package com.example.bosch.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @Ignore
    public Person(int uid, String firstName) {
        this.uid = uid;
        this.firstName = firstName;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }
}