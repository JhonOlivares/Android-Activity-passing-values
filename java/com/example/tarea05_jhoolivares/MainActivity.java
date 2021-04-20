package com.example.tarea05_jhoolivares;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity implements MyCustomRowButtonListener {

    private  static  final String TAG = "MainActivity";

    ListView listViewDeClientes;

    //dialog elements
    Button btnDialogAcciones, btnEditar, btnCuenta, btnDeposRetir, btnTransferencia;

    Cliente CurrentClient;

    ArrayList<Cliente> listaClientes;
    ClienteListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");




        listViewDeClientes = findViewById(R.id.lv_clientes);
        //clientes
        Cliente cliente1 = new Cliente("12567852", "Olivares", "Jhon", "Barranca", "7894564", new ArrayList<>());
        Cliente cliente2 = new Cliente("69854125", "Gonzales", "David", "California", "135555", new ArrayList<>());

        //arraylist clientes
        listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        adapter = new ClienteListAdapter(this, R.layout.adapter_view_cliente_layout, listaClientes, this);
        listViewDeClientes.setAdapter(adapter);

        //working with dialog
//        btnDialogAcciones = findViewById(R.id.btn_accion);
//
//        btnDialogAcciones.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDialog();
//            }
//        });




    }

    @Override
    public void onCustomRowButtonClick(Cliente selectedClient, int position, View view) {
        //Toast.makeText(this,"You have selected " + selectedClient.getDNI(),Toast.LENGTH_SHORT).show();
        openDialog(selectedClient, position);
        CurrentClient = selectedClient;
    }

    private  void openDialog(Cliente cli, int orden){
        Dialog dialog = new Dialog(MainActivity.this, R.style.CustomDialogTheme);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.acciones_dialog, null);

        btnEditar = custom_dialog.findViewById(R.id.btn_EditarCliente);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClienteDetalleActivity.class);
//                intent.putExtra("cliente", cli);
//                setResult(ClienteDetalleActivity.RESULT_OK, intent);
//                finish();
//                startActivity(intent);


                Bundle contenedor = new Bundle();
                contenedor.putSerializable("cliente", cli);
                contenedor.putInt("orden", orden);
                intent.putExtras(contenedor);
                startActivityForResult(intent, 1);
                dialog.dismiss();
            }
        });

        //Set the layout
        dialog.setContentView(custom_dialog);
        dialog.show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 1 : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    CurrentClient = (Cliente) data.getSerializableExtra("cliente");
                    listaClientes.set(data.getIntExtra("orden", -1),CurrentClient);
                    adapter.notifyDataSetChanged();
                }
                break;
            }
        }
    }
}