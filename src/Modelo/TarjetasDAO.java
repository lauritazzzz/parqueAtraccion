/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.SQLException;
/**
 *
 * @author accai
 */
public class TarjetasDAO extends DAO{
    
    @Override
    public Tarjetas log(String busqueda, String busqueda2){
        int ID_Usuario = Integer.parseInt(busqueda);
        Tarjetas tarjeta = new Tarjetas();
        String sql ="SELECT * FROM Tarjetas WHERE ID_Usuario = ?";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1, ID_Usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                tarjeta.setID(rs.getInt("ID"));
                tarjeta.setID_usuario(rs.getInt("ID_Usuario"));
                tarjeta.setPreferencia(rs.getString("Preferencia"));
                tarjeta.setSaldo(rs.getInt("Saldo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return tarjeta;
    }
    
    public boolean RecargaSaldo(Tarjetas tarjeta, int recarga){
        String sql = "UPDATE Tarjetas SET Saldo=? WHERE ID=?";
        try {
            ps = con.prepareStatement(sql);
            int saldo= tarjeta.getSaldo()+recarga;
            ps.setInt(1, saldo);
            ps.setInt(2, tarjeta.getID());
            ps.execute();
            tarjeta.setSaldo(rs.getInt("Saldo"));
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean PagarSaldo(Tarjetas tarjeta, int pago){
        String sql = "UPDATE Tarjetas SET Saldo=? WHERE ID=?";
        try {
            ps = con.prepareStatement(sql);
            int saldo= tarjeta.getSaldo()-pago;
            ps.setInt(1, saldo);
            ps.setInt(2, tarjeta.getID());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    
}
