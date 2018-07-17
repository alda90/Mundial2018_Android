package alda.mundial2018.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.ActivityPlayers;
import alda.mundial2018.R;
import alda.mundial2018.model.csEstadistica;

/**
 * Created by aldaMac on 19/05/18.
 */

public class EstadisticasAdapter extends RecyclerView.Adapter<EstadisticasAdapter.EstadisticasRestViewHolder>{
    private List<csEstadistica> estadisticas;
    private int rowLayout;
    private Context context;

    public  class EstadisticasRestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        RelativeLayout restLayout;
        ImageView imgPais;
        TextView tvPais;
        TextView tvP;
        TextView tvPartidos;
        TextView tvDif;
        TextView tvPuntos;


        public EstadisticasRestViewHolder(View v) {
            super(v);
            restLayout = (RelativeLayout) v.findViewById(R.id.rl_groups);
            imgPais = (ImageView) v.findViewById(R.id.img_Pais);
            tvPais = (TextView) v.findViewById(R.id.tvPais);
            tvPartidos = (TextView) v.findViewById(R.id.tvPartidos);
            tvP = (TextView) v.findViewById(R.id.tvP);
            tvDif = (TextView) v.findViewById(R.id.tvDif);
            tvPuntos = (TextView) v.findViewById(R.id.tvPuntos);

            restLayout.setOnClickListener(this);
        }

        public void onClick(View v) {


            String bandera = "";
            String pais = "";
            String idpais = "";
            String grupo = "";


            String cadp = estadisticas.get(getAdapterPosition()).getPais().toString().replace("=",":");
            cadp = cadp.replace("{","");
            cadp = cadp.replace("}","");
            String[] paisValues = cadp.split(",");

            for(int i=0; i< paisValues.length; i++){
                if(paisValues[i].contains("bandera")){
                    bandera = paisValues[i].substring(9);
                }

                if(paisValues[i].contains("pais")){
                    pais = paisValues[i].substring(6);
                }

                if(paisValues[i].contains("_id")){
                    idpais = paisValues[i].substring(4);
                }
            }

            String cadg = estadisticas.get(getAdapterPosition()).getGrupo().toString().replace("=",":");
            cadg = cadg.replace("{","");
            cadg = cadg.replace("}","");
            String[] gValues = cadg.split(",");

            for(int i=0; i< gValues.length; i++){
                if(gValues[i].contains("grupo")){
                    grupo = gValues[i].substring(9);
                }
            }



            Intent i = new Intent(v.getContext(), ActivityPlayers.class);
            i.putExtra("idpais", idpais);
            i.putExtra("bandera", bandera);
            i.putExtra("pais", pais);
            v.getContext().startActivity(i);
        }



    }

    public EstadisticasAdapter(List<csEstadistica> estadisticas, int rowLayout, Context context) {
        this.estadisticas = estadisticas;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public EstadisticasAdapter.EstadisticasRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new EstadisticasRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EstadisticasRestViewHolder holder, final int position) {

        String bandera = "";
        String pais = "";
        String idpais = "";
        String grupo = "";


        String cadp = estadisticas.get(position).getPais().toString().replace("=",":");
        cadp = cadp.replace("{","");
        cadp = cadp.replace("}","");
        String[] paisValues = cadp.split(",");

        for(int i=0; i< paisValues.length; i++){
            if(paisValues[i].contains("bandera")){
                bandera = paisValues[i].substring(9);
            }

            if(paisValues[i].contains("pais")){
                pais = paisValues[i].substring(6);
            }

            if(paisValues[i].contains("_id")){
                idpais = paisValues[i].substring(4);
            }
        }

        String cadg = estadisticas.get(position).getGrupo().toString().replace("=",":");
        cadg = cadg.replace("{","");
        cadg = cadg.replace("}","");
        String[] gValues = cadg.split(",");

        for(int i=0; i< gValues.length; i++){
            if(gValues[i].contains("grupo")){
                grupo = gValues[i].substring(9);
            }
        }



        Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/banderas/"+bandera)
                .into(holder.imgPais);
        holder.tvP.setText(estadisticas.get(position).getPartidos());
        holder.tvPartidos.setText(estadisticas.get(position).getGanados() + "-" + estadisticas.get(position).getEmpatados() + "-" + estadisticas.get(position).getPerdidos());
        holder.tvDif.setText(estadisticas.get(position).getDiferencia());
        holder.tvPuntos.setText(estadisticas.get(position).getPuntos());


        holder.tvPais.setText(pais);


    }

    @Override
    public int getItemCount() {
        return estadisticas.size();
    }




}

