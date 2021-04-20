package com.example.tarea05_jhoolivares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ClienteDetalleActivity extends AppCompatActivity {

    EditText etDNI, etNombres, etApellidos, etDireccion, etTelefono;
    Button btnGuardarCambios;
    Cliente tempClient;
    int orden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalle);

        etDNI = findViewById(R.id.et_DNI);
        etNombres = findViewById(R.id.et_Nombres);
        etApellidos = findViewById(R.id.et_Apellidos);
        etDireccion = findViewById(R.id.et_Direccion);
        etTelefono = findViewById(R.id.et_Telefono);

        tempClient = (Cliente) getIntent().getSerializableExtra("cliente");
        orden = getIntent().getIntExtra("orden", -1);

        etDNI.setText(tempClient.getDNI());
        etNombres.setText(tempClient.getNombres());
        etApellidos.setText(tempClient.getApellidos());
        etDireccion.setText(tempClient.getDireccion());
        etTelefono.setText(tempClient.getTelefono());

        btnGuardarCambios = findViewById(R.id.btn_GuardarCambios);

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Dar valor a las propiedades
                tempClient.setDNI(etDNI.getText().toString());
                tempClient.setNombres(etNombres.getText().toString());
                tempClient.setApellidos(etApellidos.getText().toString());
                tempClient.setDireccion(etDireccion.getText().toString());
                tempClient.setTelefono(etTelefono.getText().toString());


                Intent data = new Intent();
                data.putExtra("cliente", tempClient);
                data.putExtra("orden", orden);
                setResult(RESULT_OK,data);
                finish();
            }
        });

    }
}