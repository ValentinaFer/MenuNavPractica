package com.softulp.menunavpractica.ui.ciudades;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.menunavpractica.modelos.Ciudad;

public class DetallesCiudadesViewModel extends AndroidViewModel {

    private MutableLiveData<Ciudad> mCiudad;

    public DetallesCiudadesViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Ciudad> getMCiudad() {
        if (mCiudad == null){
            mCiudad = new MutableLiveData<>();
        }
        return mCiudad;
    }

    public void fetchBundle(Bundle bundle){
        Ciudad ciudad = (Ciudad) bundle.getSerializable("ciudadClicked");
        if (ciudad != null){
            mCiudad.setValue(ciudad);
        }
    }

}