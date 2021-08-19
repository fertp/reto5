package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {

    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        
        Connection conex = JDBCUtilities.getConnection();

        var listaLideres = new ArrayList<Requerimiento_1Vo>();

        try {

            Statement stm = conex.createStatement();

            String sql = "SELECT ID_Lider, Salario, Ciudad_Residencia FROM Lider l  WHERE l.Salario < (SELECT AVG(l2.Salario) FROM Lider l2) ORDER BY l.Salario";

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                
                Requerimiento_1Vo lider = new Requerimiento_1Vo();

                lider.setId(rs.getInt("ID_Lider"));
                lider.setSalario(rs.getInt("Salario"));
                lider.setCiudad(rs.getString("Ciudad_Residencia"));

                listaLideres.add(lider);

            }

            rs.close();
            conex.close();
            
        } catch (Exception e) {
            System.out.println("Error, no se conecto");
        }
        
        return listaLideres;

    }
}