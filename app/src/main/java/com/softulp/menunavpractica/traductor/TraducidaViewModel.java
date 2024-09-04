package com.softulp.menunavpractica.traductor;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.modelos.Palabra;

import java.io.Serializable;
import java.util.ArrayList;

public class TraducidaViewModel extends AndroidViewModel {
    private MutableLiveData<Palabra> wordMutableLiveData;
    private final ArrayList<Palabra> listWord = new ArrayList<>();


    public TraducidaViewModel(@NonNull Application application) {
        super(application);
        listWord.add(new Palabra(R.drawable.house, "house","casa" ));
        listWord.add(new Palabra(R.drawable.dog, "dog","perro"));
        listWord.add(new Palabra(R.drawable.cat, "cat","gato"));
        listWord.add(new Palabra(R.drawable.ball,"ball","pelota"));
    }

    public LiveData<Palabra> getWordLiveData() {

        if (this.wordMutableLiveData == null){
            wordMutableLiveData = new MutableLiveData<>();
        }
        return wordMutableLiveData;
    }

    public void rescueData(Bundle bundle){
        String palabra = (String) bundle.getSerializable("palabra");
        if (palabra != null){
            for (Palabra w : listWord){
                if (w.getPalabraEsp().equals(palabra)){
                    wordMutableLiveData.setValue(w);
                    return;
                }
            }
            wordMutableLiveData.setValue(new Palabra(R.drawable.error,"Palabra no encontrada", ""));
        }
    }
}