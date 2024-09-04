package com.softulp.menunavpractica.ui.ciudades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.menunavpractica.R;
import com.softulp.menunavpractica.modelos.Ciudad;

import java.util.List;

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ViewHolderCiudad> {

    private List<Ciudad> ciudades;
    private LayoutInflater li;

    public CiudadAdapter(List<Ciudad> ciudades, LayoutInflater li){
        this.ciudades = ciudades;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderCiudad onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = li.inflate(R.layout.item, parent, false); con el item anterior
        View view = li.inflate(R.layout.card, parent, false);
        return new ViewHolderCiudad(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCiudad holder, int position) {
        Ciudad ciudad = ciudades.get(position);
        holder.tvNombre.setText(ciudad.getNombre());
        holder.tvDistancia.setText(ciudad.getDistancia()+"");
        holder.tvHab.setText(ciudad.getHabitantes()+"");
        holder.ivImg.setImageResource(ciudad.getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ciudad ciudadClicked = ciudad;
                Bundle bundle = new Bundle();
                bundle.putSerializable("ciudadClicked",ciudadClicked);
                Navigation.findNavController(v).navigate(R.id.detallesCiudadesFragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }

    public class ViewHolderCiudad extends RecyclerView.ViewHolder {

        TextView tvNombre, tvHab, tvDistancia;
        ImageView ivImg;

        public ViewHolderCiudad(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvHab = itemView.findViewById(R.id.tvCantHab);
            tvDistancia = itemView.findViewById(R.id.tvDistanciaKm);
            ivImg = itemView.findViewById(R.id.ivImg);

        }
    }

}
