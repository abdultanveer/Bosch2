package com.example.bosch.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert  //insert into Person(uid,firstName) values ("abdul")
    void insert(Person person);

    @Query("SELECT * from Person ORDER BY first_name ASC")
    LiveData<List<Person>> getAllPersons();

}





//    //    @Query("SELECT * from person_table ORDER BY first_name ASC")