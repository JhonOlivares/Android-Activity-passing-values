package com.example.tarea05_jhoolivares;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String DNI;
    private String Apellidos;
    private String Nombres;
    private String Direccion;
    private String Telefono;
    private ArrayList<Cuenta> CuentasList;

    public Cliente(String DNI, String apellidos, String nombres, String direccion, String telefono, ArrayList<Cuenta> cuentasList) {
        this.DNI = DNI;
        Apellidos = apellidos;
        Nombres = nombres;
        Direccion = direccion;
        Telefono = telefono;
        CuentasList = cuentasList;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public ArrayList<Cuenta> getCuentasList() {
        return CuentasList;
    }

    public void setCuentasList(ArrayList<Cuenta> cuentasList) {
        CuentasList = cuentasList;
    }
}
