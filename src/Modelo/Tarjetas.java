/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author accai
 */
public class Tarjetas {
    private int ID_usuario;
    private int ID;
    private int Saldo;
    private String Preferencia;
    
    public Tarjetas(){
    }
    
    public Tarjetas(int ID_usuario, int ID, int Saldo, String Preferencia) {
        this.ID_usuario = ID_usuario;
        this.ID = ID;
        this.Saldo = Saldo;
        this.Preferencia = Preferencia;
    }

    public int getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getPreferencia() {
        return Preferencia;
    }

    public void setPreferencia(String Preferencia) {
        this.Preferencia = Preferencia;
    }
    
    public void pagar(TarjetasDAO contarjeta, Persona persona, sistemaAtracciones atraccion){
        if ("L".equals(atraccion.getEstado())) {
            if (persona.getTarjeta().getSaldo()>atraccion.getValor()) {
                if (persona.getEstatura()<atraccion.getEstaturaMax() && persona.getEstatura()>atraccion.getEstaturaMin() ) {
                    contarjeta.PagarSaldo(persona.getTarjeta(), atraccion.getValor());
                    persona.setTarjeta(contarjeta.log(Integer.toString(persona.getTarjeta().getID_usuario()),""));
                    System.out.println(persona.getTarjeta().getSaldo());
                    JOptionPane.showMessageDialog(null, "Pago Exitoso, te quedan "+persona.getTarjeta().getSaldo()+"$");
                } else {
                    JOptionPane.showMessageDialog(null, "No cumples con los requisitos");
                }       
            } else{
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
            }
        } else{
            JOptionPane.showMessageDialog(null, "Atracción no disponible en este momento");
        }
    }
    
    public void recargar(Persona persona,int recarga, TarjetasDAO contarjeta){
        if (recarga<0){
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
        }else{
            contarjeta.RecargaSaldo(persona.getTarjeta(), recarga);
            persona.setTarjeta(contarjeta.log(Integer.toString(persona.getTarjeta().getID_usuario()),""));
            
        }
    }
    
}
