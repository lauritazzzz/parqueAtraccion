/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author accai
 */
public class TrabajadoresDAO extends DAO{

    @Override
    public Trabajadores log(String busqueda, String busqueda2){
        String CC=busqueda;
        String Pass=busqueda2;
        Trabajadores t = new Trabajadores();
        String sql ="SELECT * FROM Trabajadores WHERE CC = ? AND Pass = ?";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, CC);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                t.setID(rs.getInt("ID"));
                t.setCC(rs.getString("CC"));
                t.setNombre(rs.getString("Nombre"));
                t.setFuncion(rs.getString("Funcion"));
                t.setPago(rs.getInt("Pago"));
                t.setPass(rs.getString("Pass"));
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return t;
    }
}
