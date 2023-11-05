/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Caicedo
 */
public class Atraccionbajo extends sistemaAtracciones{

    public Atraccionbajo(){
    }
        
    public Atraccionbajo(int ID, String Nombre, String Estado, int Valor, int Capacidad, int Cola) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Valor = Valor;
        this.Capacidad = Capacidad;
        this.EstaturaMax= 160;
        this.EstaturaMin=110;
        this.Cola=Cola;
    }


}