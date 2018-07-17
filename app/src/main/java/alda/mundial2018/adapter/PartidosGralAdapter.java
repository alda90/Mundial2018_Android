package alda.mundial2018.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.ActivityMatch;
import alda.mundial2018.R;
import alda.mundial2018.model.csPartido;

/**
 * Created by aldaMac on 18/05/18.
 */

public class PartidosGralAdapter extends RecyclerView.Adapter<PartidosGralAdapter.PartidosGralRestViewHolder>{
    private List<csPartido> partidos;
    private int rowLayout;
    private Context context;

    public  class PartidosGralRestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //RelativeLayout restLayout;
        CardView restLayout;
        ImageView imgLocal;
        ImageView imgVisitante;
        TextView tvInfo;
        TextView tvLocal;
        TextView tvVisitante;
        TextView tvLocalg;
        TextView tvVisitanteg;


        public PartidosGralRestViewHolder(View v) {
            super(v);
            restLayout = (CardView) v.findViewById(R.id.card_matches);
            imgLocal = (ImageView) v.findViewById(R.id.img_Local);
            imgVisitante = (ImageView) v.findViewById(R.id.img_Visitante);
            tvInfo = (TextView) v.findViewById(R.id.tvInfo);
            tvLocal = (TextView) v.findViewById(R.id.tvLocal);
            tvVisitante = (TextView) v.findViewById(R.id.tvVisitante);
            tvLocalg = (TextView) v.findViewById(R.id.tvLocalg);
            tvVisitanteg = (TextView) v.findViewById(R.id.tvVisitanteg);

            restLayout.setOnClickListener(this);
        }

        public void onClick(View v) {

            Log.e("N: ", "DDDD");

            String banderal = "";
            String banderav = "";
            String local = "";
            String visitante = "";
            String idlocal = "";
            String idvisitante = "";


            String cadl = partidos.get(getAdapterPosition()).getLocal().toString().replace("=",":");
            cadl = cadl.replace("{","");
            cadl = cadl.replace("}","");
            String[] localValues = cadl.split(",");

            for(int i=0; i< localValues.length; i++){
                if(localValues[i].contains("bandera")){
                    banderal = localValues[i].substring(9);
                }

                if(localValues[i].contains("pais")){
                    local = localValues[i].substring(6);
                }

                if(localValues[i].contains("_id")){
                    idlocal = localValues[i].substring(4);
                }
            }

            String cadv = partidos.get(getAdapterPosition()).getVisitante().toString().replace("=",":");
            cadv = cadv.replace("{","");
            cadv = cadv.replace("}","");
            String[] visValues = cadv.split(",");

            for(int i=0; i< visValues.length; i++){
                if(visValues[i].contains("bandera")){
                    banderav = visValues[i].substring(9);
                }

                if(visValues[i].contains("pais")){
                    visitante = visValues[i].substring(6);
                }

                if(visValues[i].contains("_id")){
                    idvisitante = visValues[i].substring(4);
                }
            }



            String idPartido = partidos.get(getAdapterPosition()).getIdpartido();


            Intent i = new Intent(v.getContext(), ActivityMatch.class);
            i.putExtra("idpartido", partidos.get(getAdapterPosition()).getIdpartido());
            i.putExtra("banderal", banderal);
            i.putExtra("banderav", banderav);
            i.putExtra("local", local);
            i.putExtra("visitante", visitante);
            i.putExtra("idlocal", idlocal);
            i.putExtra("idvisitante", idvisitante);
            i.putExtra("glocal", partidos.get(getAdapterPosition()).getGoleslocal());
            i.putExtra("gvisitante", partidos.get(getAdapterPosition()).getGolesvisitante());
            i.putExtra("glocalp", partidos.get(getAdapterPosition()).getGoleslocalp());
            i.putExtra("gvisitantep", partidos.get(getAdapterPosition()).getGolesvisitantep());
            i.putExtra("estatus", partidos.get(getAdapterPosition()).getEstatus());
            i.putExtra("conclusion", partidos.get(getAdapterPosition()).getConclusion());
            i.putExtra("fecha", partidos.get(getAdapterPosition()).getFecha());
            i.putExtra("hora", partidos.get(getAdapterPosition()).getHora());
            i.putExtra("partido", partidos.get(getAdapterPosition()).getPartido());
            i.putExtra("fase", partidos.get(getAdapterPosition()).getFase());
            v.getContext().startActivity(i);
        }



    }

    public PartidosGralAdapter(List<csPartido> partidos, int rowLayout, Context context) {
        this.partidos = partidos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PartidosGralAdapter.PartidosGralRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new PartidosGralRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PartidosGralRestViewHolder holder, final int position) {

        String banderal = "";
        String banderav = "";
        String local = "";
        String visitante = "";

        String cadl = partidos.get(position).getLocal().toString().replace("=",":");
        cadl = cadl.replace("{","");
        cadl = cadl.replace("}","");
        String[] localValues = cadl.split(",");

        for(int i=0; i< localValues.length; i++){
            if(localValues[i].contains("bandera")){
                banderal = localValues[i].substring(9);
            }

            if(localValues[i].contains("pais")){
                local = localValues[i].substring(6);
            }
        }

        String cadv = partidos.get(position).getVisitante().toString().replace("=",":");
        cadv = cadv.replace("{","");
        cadv = cadv.replace("}","");
        String[] visValues = cadv.split(",");

        for(int i=0; i< visValues.length; i++){
            if(visValues[i].contains("bandera")){
                banderav = visValues[i].substring(9);
            }

            if(visValues[i].contains("pais")){
                visitante = visValues[i].substring(6);
            }
        }

        Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/banderas/"+banderal)
                .into(holder.imgLocal);
        Picasso.with(context.getApplicationContext()).load("https://mundial-backend.herokuapp.com/img/banderas/"+banderav)
                .into(holder.imgVisitante);




        if(partidos.get(position).getEstatus().equals("PROGRAMADO") || partidos.get(position).getEstatus().equals("POR EMPEZAR")){
            holder.tvInfo.setText(partidos.get(position).getHora());
        }else {
            holder.tvInfo.setText(partidos.get(position).getEstatus());
        }

        holder.tvLocal.setText(local);
        holder.tvVisitante.setText(visitante);

        if(partidos.get(position).getConclusion().equals("Penales")){

            holder.tvLocalg.setText(  partidos.get(position).getGoleslocal() + "(" + partidos.get(position).getGoleslocalp() + ")");
            holder.tvVisitanteg.setText( partidos.get(position).getGolesvisitante() + "(" + partidos.get(position).getGolesvisitantep() + ")");
        } else {
            holder.tvLocalg.setText(  partidos.get(position).getGoleslocal());
            holder.tvVisitanteg.setText( partidos.get(position).getGolesvisitante());
        }
    }

    @Override
    public int getItemCount() {
        return partidos.size();
    }




}

