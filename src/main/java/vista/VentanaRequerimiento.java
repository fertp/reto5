package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.Controlador;

public class VentanaRequerimiento extends JFrame {

  private JTable table;
  private JTableHeader tHeader;

  public static final Controlador controlador = new Controlador();

  public VentanaRequerimiento(DefaultTableModel dtm, String title) {

    // JFrame
    setTitle(title);
    setSize(420, 380);
    setLocationRelativeTo(null);
    setResizable(true);

    table = new JTable(dtm);
    table.setBounds(0, 20, 480, 340);

    tHeader = table.getTableHeader();
    tHeader.setBounds(0, 0, 480, 20);
            
    add(tHeader);
    add(table);

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane);
      
  }

}