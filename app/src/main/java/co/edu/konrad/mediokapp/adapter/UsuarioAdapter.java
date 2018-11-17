package co.edu.konrad.mediokapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.entities.Asistencia;
import co.edu.konrad.mediokapp.entities.Asistente;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.CategoriaViewHolder> {

    private ArrayList<Asistencia> items;

    public UsuarioAdapter(ArrayList<Asistencia> items) {
        this.items = items;
    }

    public ArrayList<Asistencia> getItems() {
        return items;
    }

    public void setItems(ArrayList<Asistencia> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_usuario, parent, false);
        CategoriaViewHolder pvh = new CategoriaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getAsistente().getNombreAsistente());
        holder.apellido.setText(items.get(position).getAsistente().getApellidoAsistente());
        holder.codigo.setText(Integer.toString(items.get(position).getAsistente().getCodigoAsistente()) +" / "+ Integer.toString(items.get(position).getAsistente().getCedulaAsistente()));
        holder.fecha.setText(items.get(position).getFecha());
        holder.uso.setText(items.get(position).getUso());
        //holder.imageView.setImageResource(items.get(position).getImagen());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;
        TextView apellido;
        TextView codigo;
        TextView fecha;
        TextView uso;
        ImageView imageView;

        CategoriaViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imagenCard);
            nombre = (TextView) itemView.findViewById(R.id.nombreCard);
            apellido = (TextView) itemView.findViewById(R.id.apellidoCard);
            codigo = (TextView) itemView.findViewById(R.id.codigoCard);
            fecha = (TextView) itemView.findViewById(R.id.fechaCard);
            uso = (TextView) itemView.findViewById(R.id.usoCard);
            cv = (CardView) itemView.findViewById(R.id.carta);
        }
    }
}
