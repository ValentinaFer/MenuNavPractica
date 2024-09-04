package com.softulp.menunavpractica.traductor;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.databinding.FragmentTraducidaBinding;
import com.softulp.menunavpractica.databinding.FragmentTraductorMainBinding;
import com.softulp.menunavpractica.modelos.Palabra;

public class TraducidaFragment extends Fragment {

    private TraducidaViewModel mViewModel;
    private FragmentTraducidaBinding binding;

    public static TraducidaFragment newInstance() {
        return new TraducidaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(TraducidaViewModel.class);
        binding = FragmentTraducidaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getWordLiveData().observe(getViewLifecycleOwner(), new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.imageEnglish.setImageResource(palabra.getFoto());
                binding.textViewEnglish.setText(palabra.getPalabraEng());
            }
        });

        mViewModel.rescueData(getArguments());

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TraducidaViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //NavController navController = NavHostFragment.findNavController(this);
        //navController.popBackStack(R.id.traducidaFragment, true);
        //navController.
    }

}