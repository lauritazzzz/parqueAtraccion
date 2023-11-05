/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Caicedo
 */
public class AtraccionMedio extends sistemaAtracciones{

    public AtraccionMedio(){
    }
        
    public AtraccionMedio(int ID, String Nombre, String Estado, int Valor, int Capacidad, int Cola) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Valor = Valor;
        this.Capacidad = Capacidad;
        this.EstaturaMax= 210;
        this.EstaturaMin=145;
        this.Cola=Cola;
    }


}
