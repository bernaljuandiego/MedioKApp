package co.edu.konrad.mediokapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.entities.Categoria;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder> {

    private ArrayList<Categoria> items;

    public AdapterCategoria(ArrayList<Categoria> items) {
        this.items = items;
    }

    public ArrayList<Categoria> getItems() {
        return items;
    }

    public void setItems(ArrayList<Categoria> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_categoria, parent, false);
        CategoriaViewHolder pvh = new CategoriaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.descripcion.setText(items.get(position).getNombre());
        holder.imageView.setImageResource(items.get(position).getImagen());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView descripcion;
        ImageView imageView;

        CategoriaViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView2);
            descripcion = (TextView) itemView.findViewById(R.id.textView2);
            cv = (CardView) itemView.findViewById(R.id.carta);
        }
    }
}
