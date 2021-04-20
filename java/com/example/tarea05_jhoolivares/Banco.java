package com.example.tarea05_jhoolivares;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Cliente> ClientesLista;


    public Banco(ArrayList<Cliente> clientesLista) {
        ClientesLista = clientesLista;
    }

    public ArrayList<Cliente> getClientesLista() {
        return ClientesLista;
    }

    public void setClientesLista(ArrayList<Cliente> clientesLista) {
        ClientesLista = clientesLista;
    }
}
