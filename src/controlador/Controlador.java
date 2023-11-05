/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Vista.Login;
import Vista.SistemaTrabajadores;
import Vista.Usuarios;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Caicedo
 */
public class Controlador {
    Persona persona= new Persona();
    DAO logpersona = new PersonaDAO();
    Trabajadores trabajador=new Trabajadores();
    DAO logtrabajador=new TrabajadoresDAO();
    Login login = new Login();
    
    //LOGIN

    public void iniciarlogin(){
        
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        login.jButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String Nombre= login.txtCorreo.getText();
                String Pass= String.valueOf(login.txtPass.getPassword());
                
                persona= (Persona) persona.Entrar(logpersona, Nombre, Pass);
                if (persona.getNombre()!= null && persona.getPass() != null ) {
                    mostrarSistemaUsuarios();
                    login.dispose();
                }
            }
        });
        
        login.jButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String CC= login.txtCorreo.getText();
                String Pass= String.valueOf(login.txtPass.getPassword());
                trabajador= (Trabajadores) trabajador.Entrar(logtrabajador, CC, Pass);
                if (trabajador.getNombre()!= null && trabajador.getPass() != null ) {
                    mostrarsistemaTrabajadores();
                    login.dispose();
                }
            }
        });
        
        
        login.show();
    }
    
    //SET TARJETA Y ATRACCIONES
    
    DAO contarjeta =new TarjetasDAO();
    AtraccionesDTO llenar = new AtraccionesDTO();
    List<sistemaAtracciones> atraccionesParque=llenar.log();
    
    //VISTA USUARIOS
    Usuarios sistemaUsuarios = new Usuarios();
    
    public void mostrarSistemaUsuarios(){
        sistemaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sistemaUsuarios.labelNombreUsuario.setText(persona.getUser());
        sistemaUsuarios.superEstado.setText(atraccionesParque.get(0).getEstado());
        sistemaUsuarios.montanaEstado.setText(atraccionesParque.get(1).getEstado());
        sistemaUsuarios.trencitoEstado.setText(atraccionesParque.get(2).getEstado());
        sistemaUsuarios.motoEstado.setText(atraccionesParque.get(3).getEstado());
        sistemaUsuarios.aranaEstado.setText(atraccionesParque.get(4).getEstado());
        sistemaUsuarios.globosEstado.setText(atraccionesParque.get(5).getEstado());
        
        persona.setTarjeta((Tarjetas) contarjeta.log(Integer.toString(persona.getID_tarjeta()),""));
        
        
        //recarga y saldo
        
        
        sistemaUsuarios.jButton30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer recarga;
                recarga = Integer.parseInt(sistemaUsuarios.txtRecarga.getText());
                persona.getTarjeta().recargar(persona, recarga, (TarjetasDAO) contarjeta);
                sistemaUsuarios.txtSaldo.setText(Integer.toString(persona.getTarjeta().getSaldo()));
            }
        });
        
        sistemaUsuarios.jButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                sistemaUsuarios.txtSaldo.setText(Integer.toString(persona.getTarjeta().getSaldo()));
            }
        });
        
        //pagos
        
        sistemaUsuarios.jButton6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(0));
                
            }
        });
        
        sistemaUsuarios.jButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(1));
                
            }
        });
        
        sistemaUsuarios.jButton27.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(2));
                
            }
        });
        
        sistemaUsuarios.jButton9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(3));
                
            }
        });
        
        sistemaUsuarios.jButton21.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(4));
                
            }
        });
        
        sistemaUsuarios.jButton24.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                persona.getTarjeta().pagar((TarjetasDAO) contarjeta, persona, atraccionesParque.get(5));
                
            }
        });
        
        //informacion
        sistemaUsuarios.jButton7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(0).mostrarInfo();
                
            }
        });
        sistemaUsuarios.jButton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(1).mostrarInfo();
                
            }
        });
        sistemaUsuarios.jButton29.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(2).mostrarInfo();
                
            }
        });
        sistemaUsuarios.jButton10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(3).mostrarInfo();
                
            }
        });
        sistemaUsuarios.jButton23.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(4).mostrarInfo();
                
            }
        });
        sistemaUsuarios.jButton26.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(5).mostrarInfo();
                
            }
        });
        sistemaUsuarios.show();
    }
    
    //VISTA TRABAJADORES
    SistemaTrabajadores sistemaTrabajadores = new SistemaTrabajadores();
    
    public void mostrarsistemaTrabajadores(){
        sistemaTrabajadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sistemaTrabajadores.LabelNombre.setText(trabajador.getNombre());
        sistemaTrabajadores.LabelFuncion.setText(trabajador.getFuncion());
        
        sistemaTrabajadores.jButton17.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Integer horaE = Integer.parseInt(sistemaTrabajadores.txtHoraE.getText());
                Integer horaS = Integer.parseInt(sistemaTrabajadores.txtHoraS.getText());
                sistemaTrabajadores.txtSaldo.setText(Integer.toString(trabajador.calcularSalario(horaE, horaS)));
                
            }
        });
        
        
        sistemaTrabajadores.superEstado.setText(atraccionesParque.get(0).getEstado());
        sistemaTrabajadores.montanaEstado.setText(atraccionesParque.get(1).getEstado());
        sistemaTrabajadores.trencitoEstado.setText(atraccionesParque.get(2).getEstado());
        sistemaTrabajadores.motoEstado.setText(atraccionesParque.get(3).getEstado());
        sistemaTrabajadores.aranaEstado.setText(atraccionesParque.get(4).getEstado());
        sistemaTrabajadores.globosEstado.setText(atraccionesParque.get(5).getEstado());
        
        sistemaTrabajadores.jButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(0).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.superEstado.setText(atraccionesParque.get(0).getEstado());
                
            }
        });
        sistemaTrabajadores.jButton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(1).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.montanaEstado.setText(atraccionesParque.get(1).getEstado());
            }
        });
        sistemaTrabajadores.jButton13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(2).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.trencitoEstado.setText(atraccionesParque.get(2).getEstado());
            }
        });
        sistemaTrabajadores.jButton7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(3).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.motoEstado.setText(atraccionesParque.get(3).getEstado());
            }
        });
        sistemaTrabajadores.jButton9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(4).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.aranaEstado.setText(atraccionesParque.get(4).getEstado());
            }
        });
        sistemaTrabajadores.jButton11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(5).AtraccionEnMantenimiento(llenar);
                sistemaTrabajadores.globosEstado.setText(atraccionesParque.get(5).getEstado());
            }
        });
        
        sistemaTrabajadores.jButton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(0).AtraccionLibre(llenar);
                sistemaTrabajadores.superEstado.setText(atraccionesParque.get(0).getEstado());
            }
        });
        sistemaTrabajadores.jButton6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(1).AtraccionLibre(llenar);
                sistemaTrabajadores.montanaEstado.setText(atraccionesParque.get(1).getEstado());
            }
        });
        sistemaTrabajadores.jButton14.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(2).AtraccionLibre(llenar);
                sistemaTrabajadores.trencitoEstado.setText(atraccionesParque.get(2).getEstado());
            }
        });
        sistemaTrabajadores.jButton8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(3).AtraccionLibre(llenar);
                sistemaTrabajadores.motoEstado.setText(atraccionesParque.get(3).getEstado());
            }
        });
        sistemaTrabajadores.jButton10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(4).AtraccionLibre(llenar);
                sistemaTrabajadores.aranaEstado.setText(atraccionesParque.get(4).getEstado());
            }
        });
        sistemaTrabajadores.jButton12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atraccionesParque.get(5).AtraccionLibre(llenar);
                sistemaTrabajadores.globosEstado.setText(atraccionesParque.get(5).getEstado());
            }
        });
        sistemaTrabajadores.show();
    }
    
}
