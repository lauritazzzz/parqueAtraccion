/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author accai
 */
public class PersonaDAO extends DAO{

    @Override
    public Persona log(String busqueda, String busqueda2){
        String Nombre= busqueda;
        String Pass=busqueda2;
        Persona l = new Persona();
        String sql ="SELECT * FROM Usuarios WHERE Nombre = ? AND Pass = ?";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setID(rs.getInt("ID"));
                l.setCC(rs.getInt("CC"));
                l.setNombre(rs.getString("Nombre"));
                l.setEstatura(rs.getInt("Estatura"));
                l.setEdad(rs.getInt("Edad"));
                l.setCondicion(rs.getString("Condicion"));
                l.setID_tarjeta(rs.getInt("ID_tarjeta"));
                l.setPass(rs.getString("Pass"));
                l.setUser(rs.getString("User"));
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
