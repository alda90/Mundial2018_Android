package alda.mundial2018.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.R;
import alda.mundial2018.model.csJugador;

/**
 * Created by aldaMac on 17/05/18.
 */

public class JugadoresAdapter extends RecyclerView.Adapter<JugadoresAdapter.JugadoresRestViewHolder>{
    private List<csJugador> jugadores;
    private int rowLayout;
    private Context context;

    public  class JugadoresRestViewHolder extends RecyclerView.ViewHolder
    {
        //RelativeLayout restLayout;
        ConstraintLayout restLayout;
        CircularImageView imgJugador;
        TextView tvJugador;
        TextView tvPosicion;
        TextView tvNum;


        public JugadoresRestViewHolder(View v) {
            super(v);
            restLayout = (ConstraintLayout) v.findViewById(R.id.const_jugadores);
            imgJugador = (CircularImageView) v.findViewById(R.id.img_player);
            tvJugador = (TextView) v.findViewById(R.id.tvPlayer);
            tvPosicion = (TextView) v.findViewById(R.id.tvPosition);
            tvNum = (TextView) v.findViewById(R.id.tvNum);

            //restLayout.setOnClickListener(this);
        }


    }

    public JugadoresAdapter(List<csJugador> jugadores, int rowLayout, Context context) {
        this.jugadores = jugadores;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public JugadoresAdapter.JugadoresRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new JugadoresRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(JugadoresRestViewHolder holder, final int position) {


        Log.d("Player", jugadores.get(position).getNombre() + ": " +jugadores.get(position).getImg().length());

        String img = jugadores.get(position).getImg();
        try {

            Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/jugadores/"+jugadores.get(position).getImg()).fit().into(holder.imgJugador);
        }catch (NullPointerException e){

            Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/jugadores/"+img).fit().into(holder.imgJugador);
          //  Log.d("Error", jugadores.get(position).getNombre() + ": " +jugadores.get(position).getImg().length());

        }

        holder.tvJugador.setText(jugadores.get(position).getNombre());

        holder.tvPosicion.setText(jugadores.get(position).getPosicion());
        holder.tvNum.setText(jugadores.get(position).getNumero());

    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }




}