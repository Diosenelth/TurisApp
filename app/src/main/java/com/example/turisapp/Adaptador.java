package com.example.turisapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter<Adaptador.HotelHolder> {
    private ArrayList<HotelInfo>hotel;
    private Context context;
    private OnitemClickListener onitemClickListener;

    Adaptador(Context context, ArrayList<HotelInfo> hotel) {
        this.context=context;
        this.hotel=hotel;
    }

    public interface OnitemClickListener{
        void onItemClick(LinearLayout b, View v, HotelInfo obj, int position);
    }
    void setOnItemClickListener(OnitemClickListener onitemClickListener){
        this.onitemClickListener=onitemClickListener;
    }

    @NonNull
    @Override
    public HotelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(context).inflate(R.layout.modelo,parent,false);
        return new HotelHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull final HotelHolder holder, final int position) {
        final HotelInfo a=hotel.get(position);
        holder.imageView.setImageResource(a.getImagen());
        holder.nombre.setText(a.getNombre());
        holder.descripcion.setText(a.getDescripcion());
        holder.ubicacion.setText(a.getUbicacion());

        holder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onitemClickListener!=null){
                    onitemClickListener.onItemClick(holder.btnAction,v,a,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotel.size();
    }

    static class HotelHolder extends RecyclerView.ViewHolder {
        LinearLayout btnAction;
        ImageView imageView;
        TextView nombre, descripcion, ubicacion;
        HotelHolder(@NonNull View itemView) {
            super(itemView);
            btnAction=itemView.findViewById(R.id.click);
            imageView=itemView.findViewById(R.id.iv);
            nombre=itemView.findViewById(R.id.Nombre);
            descripcion=itemView.findViewById(R.id.Descripcion);
            ubicacion=itemView.findViewById(R.id.Ubicacion);

        }
    }
}
