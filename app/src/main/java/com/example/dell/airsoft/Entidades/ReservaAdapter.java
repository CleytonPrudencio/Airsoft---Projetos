package com.example.dell.airsoft.Entidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dell.airsoft.R;

import java.util.ArrayList;

public class ReservaAdapter extends ArrayAdapter<Usuarios> {

    private ArrayList<Usuarios> equipamentos;
    private Context context;


    public ReservaAdapter( Context c, ArrayList<Usuarios> objects) {
        super(c,0,objects);
        this.context = c;
        this.equipamentos = objects;




    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View view = null;

        if (equipamentos != null){
            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.content_lista_reserva, parent, false);

            TextView txtViewNome = (TextView) view.findViewById(R.id.textViewNome);
            TextView txtViewValor = (TextView) view.findViewById(R.id.textViewValor);

            Usuarios equipamentos2 = equipamentos.get(position);
            txtViewNome.setText(equipamentos2.getOpcionais());
            txtViewValor.setText(equipamentos2.getQuantidadeBolinhas().toString());


        }


        return view;
    }
}
