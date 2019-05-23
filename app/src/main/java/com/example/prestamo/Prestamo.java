package com.example.prestamo;

import android.print.PageRange;

public class Prestamo {
    public String Nombre;
    public String Apellido;
    public String fechafin;
    public String fechainicio;
    public String plazo;
    public String monto;
    public String paga;
    public String cuota;
    public String interes;

    public  Prestamo(){}

    public Prestamo(String Nombre,String Apelllido,String fechainicio,String fechafin,String plazo,String monto,String paga,String cuota,String interes)
    {
        this.Nombre = Nombre;
        this.Apellido = Apelllido;
        this.fechainicio = fechainicio;
        this.fechafin=fechafin;
        this.plazo= plazo;
        this.monto = monto;
        this.plazo = paga;
        this.cuota = cuota;
        this.interes = interes;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getPaga() {
        return paga;
    }

    public void setPaga(String paga) {
        this.paga = paga;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }


    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

}