package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.vo.LiderVo;
import util.JDBCUtilities;

public class LiderDao {

  public Boolean insertar(LiderVo lider) throws SQLException {

    Boolean success = false;
    
    Connection conex = JDBCUtilities.getConnection();

    String sql = "insert into Lider (Nombre, Primer_Apellido, Segundo_Apellido, Salario, Ciudad_Residencia, Cargo, Clasificacion, Documento_Identidad, Fecha_Nacimiento) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
    
      PreparedStatement pstmt = conex.prepareStatement(sql);

      pstmt.setString(1, lider.getNombre());
      pstmt.setString(2, lider.getPrimerApellido());
      pstmt.setString(3, lider.getSegundoApellido());
      pstmt.setInt(4, lider.getSalario());
      pstmt.setString(5, lider.getCiudad());
      pstmt.setString(6, lider.getCargo());
      pstmt.setInt(7, lider.getClasificacion());
      pstmt.setInt(8, lider.getDocumento());
      pstmt.setString(9, lider.getFechaNacimiento());

      int rows = pstmt.executeUpdate();

      if (rows > 0) {
        
        success = true;

      }

      pstmt.close();
      conex.close();
      
    } catch (Exception e) {
      //TODO: handle exception
    }

    return success;

  }
  
}
