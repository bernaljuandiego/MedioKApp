package co.edu.konrad.mediokapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.entities.Asistente;

public class UsuarioVistaAdapter extends RecyclerView.Adapter<UsuarioVistaAdapter.UsuarioViewHolder> {

    private ArrayList<Asistente> items;

    public UsuarioVistaAdapter(ArrayList<Asistente> items) {
        this.items = items;
    }


    public ArrayList<Asistente> getItems() {
        return items;
    }

    public void setItems(ArrayList<Asistente> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_usuario, parent, false);
        UsuarioViewHolder pvh = new UsuarioViewHolder(v);
        return pvh;
    }

 

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getNombreAsistente()+" "+items.get(position).getApellidoAsistente());
        holder.codigo.setText(items.get(position).getCodigoAsistente() +" / "+ Integer.toString(items.get(position).getCedulaAsistente()));
        holder.contenedorAdapter.removeView(holder.fecha);
        holder.contenedorAdapter.removeView(holder.txtfecha);
        holder.contenedorAdapter.removeView(holder.uso);
        holder.contenedorAdapter.removeView(holder.txtuso);
        //holder.imageView.setImageResource(items.get(position).getImagen());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView codigo;
        ImageView imageView;
        TextView fecha;
        TextView uso;
        TextView txtfecha;
        TextView txtuso;
        LinearLayout contenedorAdapter;

        UsuarioViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imagenCard);
            nombre = (TextView) itemView.findViewById(R.id.nombreCard);
            codigo = (TextView) itemView.findViewById(R.id.codigoCard);
            fecha = (TextView) itemView.findViewById(R.id.fechaCard);
            txtfecha = (TextView) itemView.findViewById(R.id.fechaAdapter);
            uso = (TextView) itemView.findViewById(R.id.usoCard);
            txtuso = (TextView) itemView.findViewById(R.id.usoAdapter);
            contenedorAdapter = (LinearLayout) itemView.findViewById(R.id.contenedorAdapter);
        }
    }
}

