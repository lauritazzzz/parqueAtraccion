/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author accai
 */
public class Persona extends Personal{
    private int ID;
    private int CC;
    private String Nombre;
    private int Estatura;
    private int Edad;
    private String Condicion;
    private int ID_tarjeta;
    private String Pass;
    private String User;
    private Tarjetas tarjeta;

    public Persona(){
    }
    
    public Persona(int ID, int CC, String Nombre, int Estatura, int Edad, String Condicion, int ID_tarjeta, String Pass, String User, Tarjetas tarjeta) {
        this.ID = ID;
        this.CC = CC;
        this.Nombre = Nombre;
        this.Estatura = Estatura;
        this.Edad = Edad;
        this.Condicion = Condicion;
        this.ID_tarjeta = ID_tarjeta;
        this.Pass = Pass;
        this.User=User;
        this.tarjeta=tarjeta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCC() {
        return CC;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEstatura() {
        return Estatura;
    }

    public void setEstatura(int Estatura) {
        this.Estatura = Estatura;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public int getID_tarjeta() {
        return ID_tarjeta;
    }

    public void setID_tarjeta(int ID_tarjeta) {
        this.ID_tarjeta = ID_tarjeta;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public Tarjetas getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjetas tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    @Override
    public Object Entrar(DAO logpersona,String Val,String Pass){       
        Persona temp=new Persona();
        if (!"".equals(Val) && !"".equals(Pass)) {
            temp = (Persona) logpersona.log(Val, Pass);
            if (temp.getNombre()!= null && temp.getPass() != null ) {
                return temp;
            } else{
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                return temp;
                
            }
        } else{
            JOptionPane.showMessageDialog(null, "Digite sus credenciales");
            return temp;
        }
    }
}
