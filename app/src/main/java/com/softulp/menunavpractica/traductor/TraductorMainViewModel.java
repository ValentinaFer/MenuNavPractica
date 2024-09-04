package com.softulp.menunavpractica.traductor;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.softulp.menunavpractica.R;

public class TraductorMainViewModel extends AndroidViewModel {

    //private final MutableLiveData<Intent> navigateToActivity = new MutableLiveData<>();
    private MutableLiveData<String> mutableWord;

    public TraductorMainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableWord() {

        if (mutableWord == null){
            mutableWord = new MutableLiveData<>();
        }
        return mutableWord;
    }

    public void verificationWord(String word){
        if (word.isEmpty()){
            Toast.makeText(getApplication(), "Ingrese una Palabra", Toast.LENGTH_SHORT).show();
        } else {
            mutableWord.setValue("okis!");
        }
    }
}