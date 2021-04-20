package com.example.tarea05_jhoolivares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;



public class ClienteListAdapter extends ArrayAdapter<Cliente> {

    private  static final String TAG = "ItemListAdapter";
    private Context mContext;
    int mResourse;

    private MyCustomRowButtonListener mRowButtonListener;

    public ClienteListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cliente> objects, MyCustomRowButtonListener listener) {
        super(context, resource, objects);
        mContext = context;
        mResourse = resource;
        mRowButtonListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        //get item information
        String DNI = getItem(position).getDNI();
        String Nombres = getItem(position).getNombres();
        String Apellidos = getItem(position).getApellidos();
        String Direccion = getItem(position).getDireccion();

        //create the item object  with the information
//        Cliente item = new Cliente(,);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResourse, parent, false);

        TextView tvDNI = convertView.findViewById(R.id.tv_DNI);
        TextView tvNombres = convertView.findViewById(R.id.tv_NombreApellido);

        tvDNI.setText(DNI);
        tvNombres.setText(Nombres + " " +Apellidos);

        Button b = (Button)convertView.findViewById(R.id.btn_accion);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mRowButtonListener.onCustomRowButtonClick(getItem(position),position,b);
            }
        });

        return convertView;
    }
}

