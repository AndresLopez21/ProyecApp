package com.example.proyectofinal.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.util.ErrorDialogFragments;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import com.example.proyectofinal.MainActivity;
import com.example.proyectofinal.R;
import com.example.proyectofinal.ActivityMainBinding;
import com.example.proyectofinal.entidades.Usuarios;
import com.example.proyectofinal.interfaces.Comunicacion;
import com.example.proyectofinal.ui.agregarusuario.AgregarUsuarioFragment;
import com.example.proyectofinal.ui.informacionusuario.MostrarInformacionFragment;

public class ListaUsuariosAdaptador extends RecyclerView.Adapter<ListaUsuariosAdaptador.UsuariosViewHolder>{

    ArrayList<Usuarios> listaUsuarios;
    Comunicacion comunicacion;


    public ListaUsuariosAdaptador(ArrayList<Usuarios> listaUsuarios, Comunicacion comunicacion){
        this.listaUsuarios = listaUsuarios;
        this.comunicacion = comunicacion;
    }

    @NonNull
    @NotNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario,null,false);
        return new UsuariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UsuariosViewHolder holder, int position) {
        holder.view.setText(listaUsuarios.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }
    

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {

        TextView view;

        public UsuariosViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.viewNombre);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comunicacion.setotro(listaUsuarios.get(getAdapterPosition()).getId(), view);
                }
            });
        }
    }

}
