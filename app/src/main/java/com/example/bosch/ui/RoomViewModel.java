package com.example.bosch.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bosch.database.Person;

import java.util.List;

//livedata makes the data observable - observer design pattern

public class RoomViewModel extends AndroidViewModel {
    private PersonRepository mRepository;
    private LiveData<List<Person>> mPeople;

    // Initialize the repository and the list of words
    public RoomViewModel (Application application) {
        super(application);
        mRepository = new PersonRepository(application);

        mPeople = mRepository.getAllWords();
    }

    LiveData<List<Person>> getAllPersons() {
        return mPeople;
    }
    public void insert(Person word) {
        mRepository.insert(word);
    }
    public void deleteWord(Person word) {
        mRepository.deleteWord(word);
    }



}
