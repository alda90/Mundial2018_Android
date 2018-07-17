package alda.mundial2018.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alda.mundial2018.R;
import alda.mundial2018.model.csIncidencia;

/**
 * Created by aldaMac on 16/05/18.
 */

public class IncidenciasAdapter extends RecyclerView.Adapter<IncidenciasAdapter.IncidenciasRestViewHolder>{
    private List<csIncidencia> incidencias;
    private int rowLayout;
    private Context context;

    public  class IncidenciasRestViewHolder extends RecyclerView.ViewHolder
    {
        //RelativeLayout restLayout;
        ConstraintLayout restLayout;
        ImageView imgIncidencia;
        ImageView imgIn, imgOut;
        TextView tvMin;
        TextView tvPlayer;
        TextView tvSubs;


        public IncidenciasRestViewHolder(View v) {
            super(v);
            restLayout = (ConstraintLayout) v.findViewById(R.id.const_incidencias);
            imgIncidencia = (ImageView) v.findViewById(R.id.imgInc);
            imgIn = (ImageView) v.findViewById(R.id.imgIn);
            imgOut = (ImageView) v.findViewById(R.id.imgOut);
            tvMin = (TextView) v.findViewById(R.id.tvMin);
            tvPlayer = (TextView) v.findViewById(R.id.tvPerson);
            tvSubs = (TextView) v.findViewById(R.id.tvSubs);


        }

    }

    public IncidenciasAdapter(List<csIncidencia> incidencias, int rowLayout, Context context) {
        this.incidencias = incidencias;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public IncidenciasAdapter.IncidenciasRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new IncidenciasRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(IncidenciasRestViewHolder holder, final int position) {

        String jugador = "";
        String sustituto = "";
        String tecnico = "";

        String cadj = incidencias.get(position).getJugador().toString().replace("=",":");
        cadj = cadj.replace("{","");
        cadj = cadj.replace("}","");
        String[] jugadorValues = cadj.split(",");

        for(int i=0; i< jugadorValues.length; i++){
            if(jugadorValues[i].contains("nombre")){
                jugador = jugadorValues[i].substring(8);
            }

        }

        String cads = incidencias.get(position).getSustituto().toString().replace("=",":");
        cads = cads.replace("{","");
        cads = cads.replace("}","");
        String[]susValues = cads.split(",");

        for(int i=0; i< susValues.length; i++){
            if(susValues[i].contains("nombre")){
                sustituto = susValues[i].substring(8);
            }

        }

        String cadt = incidencias.get(position).getTecnico().toString().replace("=",":");
        cadt = cadt.replace("{","");
        cadt = cadt.replace("}","");
        String[] tecValues = cadt.split(",");

        for(int i=0; i< tecValues.length; i++){
            if(tecValues[i].contains("nombre")){
                tecnico = tecValues[i].substring(8);
            }

        }


        holder.tvPlayer.setText(jugador);
        holder.tvSubs.setText(sustituto);
        holder.tvMin.setText(incidencias.get(position).getMinuto());

        holder.imgIn.setVisibility(View.GONE);
        holder.imgOut.setVisibility(View.GONE);
        holder.tvSubs.setVisibility(View.GONE);

        if(incidencias.get(position).getIncidencia().equals("Sustitucion")){
            holder.imgIn.setVisibility(View.VISIBLE);
            holder.imgOut.setVisibility(View.VISIBLE);
            holder.tvSubs.setVisibility(View.VISIBLE);
        }

        if(incidencias.get(position).getIncidencia().equals("Expulsion T") || incidencias.get(position).getIncidencia().equals("Amonestacion T")){
            holder.tvPlayer.setText(tecnico);
        }

        if(incidencias.get(position).getIncidencia().equals("Inicio")){
            holder.tvPlayer.setText("Inicio");
            holder.imgIncidencia.setImageResource(R.drawable.inicio);
        } else if (incidencias.get(position).getIncidencia().equals("Amonestacion J") || incidencias.get(position).getIncidencia().equals("Amonestacion T")){
            holder.imgIncidencia.setImageResource(R.drawable.yellow);
        } else if (incidencias.get(position).getIncidencia().equals("Expulsion J") || incidencias.get(position).getIncidencia().equals("Expulsion T")){
            holder.imgIncidencia.setImageResource(R.drawable.red);
        } else if(incidencias.get(position).getIncidencia().equals("Gol")){
            holder.imgIncidencia.setImageResource(R.drawable.soccer);
        } else if(incidencias.get(position).getIncidencia().equals("Penal")){
            holder.imgIncidencia.setImageResource(R.drawable.penal);
        } else if(incidencias.get(position).getIncidencia().equals("Autogol")){
            holder.imgIncidencia.setImageResource(R.drawable.soccer);
            holder.tvPlayer.setText(jugador + " (a)");
        }else if(incidencias.get(position).getIncidencia().equals("Sustitucion")){
            holder.imgIncidencia.setImageResource(R.drawable.inout);
            holder.tvPlayer.setText(sustituto);
            holder.tvSubs.setText(jugador);
        } else {
            holder.tvPlayer.setText("Final");
            holder.imgIncidencia.setImageResource(R.drawable.inicio);
        }


    }

    @Override
    public int getItemCount() {
        return incidencias.size();
    }




}