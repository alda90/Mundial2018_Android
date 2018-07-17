package alda.mundial2018.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.R;
import alda.mundial2018.model.csAlineacion;

/**
 * Created by aldaMac on 17/05/18.
 */

public class AlineacionAdapter extends RecyclerView.Adapter<AlineacionAdapter.AlineacionRestViewHolder>{
    private List<csAlineacion> jugadores;
    private int rowLayout;
    private Context context;

    public  class AlineacionRestViewHolder extends RecyclerView.ViewHolder
    {
        //RelativeLayout restLayout;
        ConstraintLayout restLayout;
        ImageView imgJugador;
        TextView tvJugador;
        TextView tvPosicion;
        TextView tvNum;


        public AlineacionRestViewHolder(View v) {
            super(v);
            restLayout = (ConstraintLayout) v.findViewById(R.id.const_jugadores);
            imgJugador = (ImageView) v.findViewById(R.id.img_player);
            tvJugador = (TextView) v.findViewById(R.id.tvPlayer);
            tvPosicion = (TextView) v.findViewById(R.id.tvPosition);
            tvNum = (TextView) v.findViewById(R.id.tvNum);

            //restLayout.setOnClickListener(this);
        }


    }

    public AlineacionAdapter(List<csAlineacion> jugadores, int rowLayout, Context context) {
        this.jugadores = jugadores;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AlineacionAdapter.AlineacionRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new AlineacionRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(AlineacionRestViewHolder holder, final int position) {

        String jugador = "";
        String posicion = "";
        String img = "";
        String num = "";

        String cadj = jugadores.get(position).getJugador().toString().replace("=",":");
        cadj = cadj.replace("{","");
        cadj = cadj.replace("}","");
        String[] jugadorValues = cadj.split(",");

        for(int i=0; i< jugadorValues.length; i++){
            if(jugadorValues[i].contains("nombre")){
                jugador = jugadorValues[i].substring(8);
            }

            if(jugadorValues[i].contains("posicion")){
                posicion = jugadorValues[i].substring(10);
            }

            if(jugadorValues[i].contains("img")){
                img = jugadorValues[i].substring(5);
            }

            if(jugadorValues[i].contains("numero")){
                num = jugadorValues[i].substring(8);
            }
        }

        Log.e("img ", img);


        Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/jugadores/"+img)
                .into(holder.imgJugador);


        if(jugadores.get(position).getCapitan().equals("S")){
            holder.tvJugador.setText(jugador + " (c)");
        }else {
            holder.tvJugador.setText(jugador);

        }

        holder.tvPosicion.setText(posicion);
        holder.tvNum.setText(num);

    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }




}