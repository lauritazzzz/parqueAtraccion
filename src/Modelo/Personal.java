/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Caicedo
 */
public abstract class Personal {
    public abstract Object Entrar(DAO logpersona,String Val,String Pass);
    public Object Salir (){
        return this;
    }
}
