package com.softulp.menunavpractica.traductor;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.menunavpractica.MainActivity;
import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.databinding.FragmentCiudadesBinding;
import com.softulp.menunavpractica.databinding.FragmentDetallesCiudadesBinding;
import com.softulp.menunavpractica.databinding.FragmentTraductorMainBinding;
import com.softulp.menunavpractica.ui.ciudades.CiudadesViewModel;

public class TraductorMainFragment extends Fragment {

    private TraductorMainViewModel mViewModel;
    private FragmentTraductorMainBinding binding;
    private View view;
    public static TraductorMainFragment newInstance() {
        return new TraductorMainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(TraductorMainViewModel.class);
        binding = FragmentTraductorMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getMutableWord().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("palabra", binding.editTextWord.getText().toString());
                NavController navController = NavHostFragment.findNavController(TraductorMainFragment.this);
                navController.navigate(R.id.traducidaFragment, bundle, new NavOptions.Builder().setPopUpTo(R.id.traductorMainFragment, true).build());
            }
        });

        binding.buttonTraslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = v;
                mViewModel.verificationWord(binding.editTextWord.getText().toString());
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TraductorMainViewModel.class);
        // TODO: Use the ViewModel
    }

}