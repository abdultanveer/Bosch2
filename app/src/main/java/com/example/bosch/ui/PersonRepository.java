package com.example.bosch.ui;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.bosch.database.Person;
import com.example.bosch.database.PersonDao;
import com.example.bosch.database.PersonDatabase;

import java.util.List;

public class PersonRepository {
    private PersonDao personDao;
    private LiveData<List<Person>> mPeople;




    PersonRepository(Application application) {
        PersonDatabase db = PersonDatabase.getDatabase(application);
        personDao = db.personDao();
        mPeople = personDao.getAllPersons();
    }


    public LiveData<List<Person>> getAllWords() {
        return personDao.getAllPersons();
    }


    public void insert(Person person) {
        personDao.insert(person);

    }

    public void deleteWord(Person word) {
    }
}
