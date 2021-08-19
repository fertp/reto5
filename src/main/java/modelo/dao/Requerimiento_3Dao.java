package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        
        Connection conex = JDBCUtilities.getConnection();

        var listaGrupos = new ArrayList<Requerimiento_3Vo>();

        try {

            Statement stm = conex.createStatement();

            String sql = "SELECT l.Clasificacion, AVG(l.Salario) Promedio FROM Lider l GROUP BY l.Clasificacion HAVING Promedio > 400000 ORDER BY Promedio DESC";

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                
                Requerimiento_3Vo grupo = new Requerimiento_3Vo();

                grupo.setClasificacion(rs.getInt("Clasificacion"));
                grupo.setPromedio(rs.getDouble("Promedio"));

                listaGrupos.add(grupo);
                
            }

            rs.close();
            conex.close();
            
        } catch (Exception e) {
            System.out.println("Error, no se conecto");
        }

        return listaGrupos;

    }
}