package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelo.dao.LiderDao;
import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.vo.LiderVo;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;

import vista.VentanaPrincipal;
import vista.VentanaRequerimiento;
import vista.VentanaInsertar;

public class Controlador {

    private Requerimiento_1Dao req1;
    private Requerimiento_2Dao req2;
    // private Requerimiento_3Dao req3;

    private LiderDao liderDao;

    public Controlador() {

        req1 = new Requerimiento_1Dao(); 
        req2 = new Requerimiento_2Dao(); 

        liderDao = new LiderDao();

    }

    public static void mostrarVentanaPrincipal() {

        VentanaPrincipal ventanaP = new VentanaPrincipal();
        ventanaP.setVisible(true);

    }

    public void mostrarRequerimiento1() {

        DefaultTableModel dtm = this.buildTableRequerimiento1();
        VentanaRequerimiento ventanaReq = new VentanaRequerimiento(dtm, "Requerimiento 1");
        ventanaReq.setVisible(true);
        
    }

    public void mostrarRequerimiento2() {

        DefaultTableModel dtm = this.buildTableRequerimiento2();
        VentanaRequerimiento ventanaReq = new VentanaRequerimiento(dtm, "Requerimiento 2");
        ventanaReq.setVisible(true);

    }

    public void mostrarVentanaInsertar() {

        VentanaInsertar ventanaI = new VentanaInsertar();
        ventanaI.setVisible(true);

    }

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        
        return req1.requerimiento1();

    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        
        return req2.requerimiento2();
        
    }

    // Insertar lider
    public Boolean insertarLider(LiderVo lider) throws SQLException {

        boolean success = liderDao.insertar(lider);

        return success;

    }

    // Construye la tabla para el requerimiento 1
    public DefaultTableModel buildTableRequerimiento1() {

        DefaultTableModel dtm = null;
        String[] nomCol = {"ID_Lider", "Salario", "Ciudad"};

        try {

        // Consigue los datos
        ArrayList<Requerimiento_1Vo> listaLideres = this.consultarRequerimiento1();

        Object[][] datos = new Object[listaLideres.size()][nomCol.length];

        // Convierte el ArrayList de ObjetosVo en Array de Arrays de objetos
        int i = 0;
        for (Requerimiento_1Vo fila : listaLideres) {

            datos[i][0] = fila.getId();
            datos[i][1] = fila.getSalario();
            datos[i][2] = fila.getCiudad();

            i++;
            
        }

        dtm = new DefaultTableModel(datos, nomCol);
        
        } catch (SQLException e1) {
        e1.printStackTrace();
        }

        return dtm;   

    }

    // Construye la tabla para el requerimiento 2
    public DefaultTableModel buildTableRequerimiento2() {

      DefaultTableModel dtm = null;
      String[] nomCol = {"Id proyecto", "Nombre del material", "Precio por unidad"};

      try {

        // Consigue los datos
        ArrayList<Requerimiento_2Vo> listaMateriales = this.consultarRequerimiento2();

        Object[][] datos = new Object[listaMateriales.size()][nomCol.length];

        // Convierte el ArrayList de ObjetosVo en Array de Arrays de objetos
        int i = 0;
        for (Requerimiento_2Vo fila : listaMateriales) {

          datos[i][0] = fila.getIdProyecto();
          datos[i][1] = fila.getNombreMaterial();
          datos[i][2] = fila.getPrecioUnidad();

          i++;
          
        }

        dtm = new DefaultTableModel(datos, nomCol);
        
      } catch (SQLException e1) {
        e1.printStackTrace();
      }

      return dtm;

    }
}
