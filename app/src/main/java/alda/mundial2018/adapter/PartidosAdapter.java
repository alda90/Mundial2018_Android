package alda.mundial2018.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import alda.mundial2018.ActivityMatch;
import alda.mundial2018.R;
import alda.mundial2018.model.csPartido;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldaMac on 13/05/18.
 */

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.PartidosRestViewHolder>{
    private List<csPartido> partidos;
    private int rowLayout;
    private Context context;

    public  class PartidosRestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
          {
        //RelativeLayout restLayout;
        CardView restLayout;
        ImageView imgLocal;
        ImageView imgVisitante;
        TextView gLocal;
        TextView gVisitante;
        TextView tvInfo;
        TextView tvLocal;
        TextView tvVisitante;
        TextView tvLocalp;
        TextView tvVisitantep;
        String prefname = "";


        public PartidosRestViewHolder(View v) {
            super(v);
            restLayout = (CardView) v.findViewById(R.id.card_rowmainmatches);
            imgLocal = (ImageView) v.findViewById(R.id.img_Local);
            imgVisitante = (ImageView) v.findViewById(R.id.img_Visitante);
            gLocal = (TextView) v.findViewById(R.id.glocal);
            gVisitante = (TextView) v.findViewById(R.id.gvisitante);
            tvInfo = (TextView) v.findViewById(R.id.tvInfo);
            tvLocal = (TextView) v.findViewById(R.id.tvLocal);
            tvVisitante = (TextView) v.findViewById(R.id.tvVisitante);
            tvLocalp = (TextView) v.findViewById(R.id.tvLocalp);
            tvVisitantep = (TextView) v.findViewById(R.id.tvVisitantep);

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

    public PartidosAdapter(List<csPartido> partidos, int rowLayout, Context context) {
        this.partidos = partidos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PartidosAdapter.PartidosRestViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);


        return new PartidosRestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PartidosRestViewHolder holder, final int position) {

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
        holder.gLocal.setText(partidos.get(position).getGoleslocal());
        holder.gVisitante.setText(partidos.get(position).getGolesvisitante());
        holder.tvLocalp.setText("p. (" + partidos.get(position).getGoleslocalp() + ")");
        holder.tvVisitantep.setText("(" + partidos.get(position).getGolesvisitantep() + ")");

        if(partidos.get(position).getEstatus().equals("PROGRAMADO")){
            holder.tvInfo.setText(partidos.get(position).getHora());
        }else {
            holder.tvInfo.setText(partidos.get(position).getEstatus());
        }

        holder.tvLocal.setText(local);
        holder.tvVisitante.setText(visitante);

        if(!partidos.get(position).getConclusion().equals("Penales")){
            holder.tvLocalp.setVisibility(View.GONE);
            holder.tvVisitantep.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return partidos.size();
    }


    public Boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }


}

