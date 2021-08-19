package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        
        Connection conex = JDBCUtilities.getConnection();

        var listaMateriales = new ArrayList<Requerimiento_2Vo>();

        try {

            Statement stm = conex.createStatement();

            String sql = "SELECT c.id_Proyecto, mc.Nombre_Material, mc.Precio_Unidad FROM Compra c JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion) WHERE c.ID_Proyecto IN (23, 38, 50) ORDER BY c.ID_Proyecto";

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                Requerimiento_2Vo material = new Requerimiento_2Vo();

                material.setIdProyecto(rs.getInt("ID_Proyecto"));
                material.setNombreMaterial(rs.getString("Nombre_Material"));
                material.setPrecioUnidad(rs.getInt("Precio_Unidad"));

                listaMateriales.add(material);
                
            }

            rs.close();
            conex.close();
            
        } catch (Exception e) {
            System.out.println("Error, no se conecto");
        }

        return listaMateriales;

    }
}