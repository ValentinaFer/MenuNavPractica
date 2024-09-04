package com.softulp.menunavpractica.ui.ciudades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.databinding.FragmentCiudadesBinding;
import com.softulp.menunavpractica.databinding.FragmentDetallesCiudadesBinding;
import com.softulp.menunavpractica.modelos.Ciudad;

public class DetallesCiudadesFragment extends Fragment {

    private DetallesCiudadesViewModel mViewModel;
    private FragmentDetallesCiudadesBinding binding;

    public static DetallesCiudadesFragment newInstance() {
        return new DetallesCiudadesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DetallesCiudadesViewModel.class);
        binding = FragmentDetallesCiudadesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getMCiudad().observe(getViewLifecycleOwner(), new Observer<Ciudad>() {
            @Override
            public void onChanged(Ciudad ciudad) {
                binding.tvTitulo.setText(ciudad.getNombre());
                binding.img.setImageResource(ciudad.getImg());
            }
        });
        mViewModel.fetchBundle(getArguments());
        return root;
        //return inflater.inflate(R.layout.fragment_detalles_ciudades, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetallesCiudadesViewModel.class);
        // TODO: Use the ViewModel
    }

}