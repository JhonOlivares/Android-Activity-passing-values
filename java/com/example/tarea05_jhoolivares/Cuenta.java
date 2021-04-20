package com.example.tarea05_jhoolivares;

import java.util.ArrayList;

public class Cuenta {

    private  int Numero;
    private double Saldo;
    private ArrayList<Operacion> OperacionesList;
    private String Estado;

    public Cuenta(int numero, double saldo, ArrayList<Operacion> operacionesList, String estado) {
        Numero = numero;
        Saldo = saldo;
        OperacionesList = operacionesList;
        Estado = estado;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public ArrayList<Operacion> getOperacionesList() {
        return OperacionesList;
    }

    public void setOperacionesList(ArrayList<Operacion> operacionesList) {
        OperacionesList = operacionesList;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
