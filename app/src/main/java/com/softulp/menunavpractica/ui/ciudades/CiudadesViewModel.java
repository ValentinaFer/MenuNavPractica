package com.softulp.menunavpractica.ui.ciudades;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.modelos.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class CiudadesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Ciudad>> mCiudades;

    public CiudadesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Ciudad>> getMCiudades(){
        if (mCiudades == null){
            mCiudades = new MutableLiveData<>();
        }
        return mCiudades;
    }

    public void cargarCiudades(){
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("La Carolina", R.drawable.carolina ,60, 500));
        ciudades.add(new Ciudad("El Trapiche", R.drawable.trap, 25, 800));
        ciudades.add(new Ciudad("Potrero de los Funes", R.drawable.potre, 20, 900));
        mCiudades.setValue(ciudades);
    }

}