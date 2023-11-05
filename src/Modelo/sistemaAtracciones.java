/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Caicedo
 */
public class sistemaAtracciones implements AtraccionesParque {
    int ID;
    String Nombre;
    String Estado;
    int Valor;
    int Capacidad;
    int EstaturaMax;
    int EstaturaMin;
    int Cola;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        if("Libre".equals(this.Estado)){
            return"L";
        }else{
            return"M";
        }
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public int getEstaturaMax() {
        return EstaturaMax;
    }

    public void setEstaturaMax(int EstaturaMax) {
        this.EstaturaMax = EstaturaMax;
    }

    public int getEstaturaMin() {
        return EstaturaMin;
    }

    public void setEstaturaMin(int EstaturaMin) {
        this.EstaturaMin = EstaturaMin;
    }

    public int getCola() {
        return Cola;
    }

    public void setCola(int Cola) {
        this.Cola = Cola;
    }

    @Override
    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Información:\nNombre: "+this.getNombre()+"\nEstado: "+this.getEstado()+
                "\nValor: "+this.getValor()+" COP\nCapacidad: "+this.getCapacidad()+" personas\nEstatura Maxima: "+this.getEstaturaMax()+
                "cm\nEstatura Min: "+this.getEstaturaMin()+"cm\nPersonas en Fila: "+this.getCola());
    }

    @Override
    public Object AtraccionEnMantenimiento(AtraccionesDTO llenar) {
        this.setEstado("Mantenimiento");
        llenar.ModificarEstado(this);
        return this;
    }

    @Override
    public Object AtraccionLibre(AtraccionesDTO llenar) {
        this.setEstado("Libre");
        llenar.ModificarEstado(this);
        return this;
    }
}
