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
public class Trabajadores extends Personal {
    private int ID;
    private String CC;
    private String Nombre;
    private String Funcion;
    private int Pago;
    private String Pass;

    public Trabajadores(){
    
    }
    
    public Trabajadores(int ID, String CC, String Nombre, String Funcion, int Pago, String Pass) {
        this.ID = ID;
        this.CC = CC;
        this.Nombre = Nombre;
        this.Funcion = Funcion;
        this.Pago = Pago;
        this.Pass = Pass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFuncion() {
        return Funcion;
    }

    public void setFuncion(String Funcion) {
        this.Funcion = Funcion;
    }

    public int getPago() {
        return Pago;
    }

    public void setPago(int Pago) {
        this.Pago = Pago;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    public int calcularSalario(int horaE, int horaS){
        if (horaE>=0 && horaE<=24 && horaS>=0 && horaS<=24) {
            int horaT=0;
            if (horaE>horaS) {
                horaT=(horaS-horaE)+24;
            }else{
                horaT=horaE-horaS;
            }
            int pago=horaT*this.getPago()*15;
            return pago;
        } else {
            JOptionPane.showMessageDialog(null, "introduzca una hora valida");
            return 0;
        }
    }
    
    @Override
    public Object Entrar(DAO logpersona,String Val,String Pass){       
        Trabajadores temp=new Trabajadores();
        if (!"".equals(Val) && !"".equals(Pass)) {
            temp = (Trabajadores) logpersona.log(Val, Pass);
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
