package vista;

import javax.swing.*;
import java.awt.event.*;

import controlador.Controlador;

public class VentanaPrincipal extends JFrame implements ItemListener, ActionListener {

  public static final Controlador controlador = new Controlador();

  private JLabel labelTitulo1, labelParrafo1, labelTitulo2, labelParrafo2;
  private JComboBox<String> cmbRequerimientos;
  private JButton botonInsertar;

  public VentanaPrincipal() {

    // JFrame
    setLayout(null);
    setSize(480, 360);
    setTitle("Proyectos de construcción");
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Título 1
    labelTitulo1 = new JLabel("Requerimientos");
		labelTitulo1.setBounds(20, 20, 380, 30);
		labelTitulo1.setFont(new java.awt.Font("Verdana", 1, 18));
		add(labelTitulo1);

    // Párrafo 1
    labelParrafo1 = new JLabel("Elija el requerimiento que desea visualizar:");
		labelParrafo1.setBounds(20, 60, 380, 20);
		labelParrafo1.setFont(new java.awt.Font("Verdana", 0, 16));
		add(labelParrafo1);

    // Select requerimientos
    cmbRequerimientos = new JComboBox<String>();
    cmbRequerimientos.setBounds(20, 90, 160, 30);
    add(cmbRequerimientos);
    cmbRequerimientos.addItem("Requerimiento 1");
    cmbRequerimientos.addItem("Requerimiento 2");
    cmbRequerimientos.setSelectedIndex(-1);
    cmbRequerimientos.addItemListener(this);

    // INSERTAR

    // Título 2
    labelTitulo2 = new JLabel("Insertar lider");
		labelTitulo2.setBounds(20, 150, 380, 30);
		labelTitulo2.setFont(new java.awt.Font("Verdana", 1, 18));
		add(labelTitulo2);

    // Párrafo 2
    labelParrafo2 = new JLabel("Haga click para insertar un nuevo lider de proyecto");
		labelParrafo2.setBounds(20, 190, 440, 20);
		labelParrafo2.setFont(new java.awt.Font("Verdana", 0, 16));
		add(labelParrafo2);

    // Botón Insertar
    botonInsertar = new JButton("Insertar");
    botonInsertar.setBounds(20, 220, 120, 30);
    add(botonInsertar);
    botonInsertar.addActionListener(this);

  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    
    if (e.getSource() == cmbRequerimientos) { 

      if (e.getStateChange() == 1) {

        String selected = (String) cmbRequerimientos.getSelectedItem();

        switch (selected) {
          case "Requerimiento 1":
            controlador.mostrarRequerimiento1();
            break;
          
          case "Requerimiento 2":
            controlador.mostrarRequerimiento2();
            break;
        
          default:
            break;
        } 
        
      }
      
    }
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == botonInsertar) {

      controlador.mostrarVentanaInsertar();
      
    }
    
  }
  
}
