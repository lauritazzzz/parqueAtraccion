/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author accai
 */
public class AtraccionesDTO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public List<sistemaAtracciones> log(){
        List<sistemaAtracciones> aList = new ArrayList();
        sistemaAtracciones a;
        String sql ="SELECT * FROM Atracciones;";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if("Alto".equals(rs.getString("Tipo"))){
                    a = new AtraccionAlto(
                    rs.getInt("ID"),
                    rs.getString("Nombre"),
                    rs.getString("Estado"),
                    rs.getInt("Valor"),
                    rs.getInt("Capacidad"),
                    rs.getInt("Cola")
                    );
                    aList.add(a);
                }
                if("Medio".equals(rs.getString("Tipo"))){
                    a = new AtraccionMedio(
                    rs.getInt("ID"),
                    rs.getString("Nombre"),
                    rs.getString("Estado"),
                    rs.getInt("Valor"),
                    rs.getInt("Capacidad"),
                    rs.getInt("Cola")
                    );
                    aList.add(a);
                }
                if("Bajo".equals(rs.getString("Tipo"))){
                    a = new Atraccionbajo(
                    rs.getInt("ID"),
                    rs.getString("Nombre"),
                    rs.getString("Estado"),
                    rs.getInt("Valor"),
                    rs.getInt("Capacidad"),
                    rs.getInt("Cola")
                    );
                    aList.add(a);
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return aList;
    }
    
    public boolean ModificarEstado(sistemaAtracciones atraccion){
        String estado="Mantenimiento";
        if("L".equals(atraccion.getEstado())){
            estado="Libre";
        }
        String sql = "UPDATE Atracciones SET Estado=? WHERE Nombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setString(2, atraccion.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
