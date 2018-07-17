package alda.mundial2018.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.R;
import alda.mundial2018.model.csEstadio;

/**
 * Created by aldaMac on 20/05/18.
 */

public class EstadioAdapter extends RecyclerView.Adapter<EstadioAdapter.EstadioRestViewHolder>{
    private List<csEstadio> estadios;
    private int rowLayout;
    private Context context;

    public  class EstadioRestViewHolder extends RecyclerView.ViewHolder
    {
        CardView restLayout;
        ImageView imgEstadio;
        TextView tvEstadio;
        TextView tvCapacidad;
        TextView tvSede;


        public EstadioRestViewHolder(View v) {
            super(v);
            restLayout = (CardView) v.findViewById(R.id.card_estadio);
            imgEstadio = (ImageView) v.findViewById(R.id.img_Estadio);
            tvEstadio = (TextView) v.findViewById(R.id.tvEstadio);
            tvCapacidad = (TextView) v.findViewById(R.id.tvCapacidad);
            tvSede = (TextView) v.findViewById(R.id.tvSede);

        }


    }

    public EstadioAdapter(List<csEstadio> estadios, int rowLayout, Context context) {
        this.estadios = estadios;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public EstadioAdapter.EstadioRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new EstadioRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EstadioRestViewHolder holder, final int position) {

        String sede = "";


        String cads = estadios.get(position).getSede().toString().replace("=",":");
        cads = cads.replace("{","");
        cads = cads.replace("}","");
        String[] sedeValues = cads.split(",");

        for(int i=0; i< sedeValues.length; i++){
            if(sedeValues[i].contains("sede")){
                sede = sedeValues[i].substring(6);
            }

        }




        Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/estadios/"+estadios.get(position).getImg())
                .into(holder.imgEstadio);
        holder.tvEstadio.setText(estadios.get(position).getEstadio());
        holder.tvCapacidad.setText(estadios.get(position).getCapacidad());

        holder.tvSede.setText(sede);


    }

    @Override
    public int getItemCount() {
        return estadios.size();
    }




}