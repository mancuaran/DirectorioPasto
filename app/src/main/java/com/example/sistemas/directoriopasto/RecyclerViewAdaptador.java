package com.example.sistemas.directoriopasto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sistemas.directoriopasto.models.Directorio;

import java.util.List;

/**
 * Created by sistemas on 13/10/17.
 */

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>
{


    public static class ViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView nombre , lugar, direccion;



        public ViewHolder(View itemView) {
            super(itemView);

            nombre =(TextView)itemView.findViewById(R.id.nombre);
            lugar =(TextView)itemView.findViewById(R.id.lugar);
            direccion =(TextView)itemView.findViewById(R.id.direccion);

        }
    }

    public List<Directorio> lista;

    public RecyclerViewAdaptador(List<Directorio> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_directorio,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.nombre.setText(lista.get(position).getResponsable());
        holder.lugar.setText(lista.get(position).getNombreDelEstablecimiento());
        holder.direccion.setText(lista.get(position).getDireccion());

    }

    @Override
    public int getItemCount()
    {
        return lista.size();
    }
}

