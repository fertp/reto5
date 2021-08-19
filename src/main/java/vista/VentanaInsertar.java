package vista;

import javax.swing.*;

import controlador.Controlador;
import modelo.vo.LiderVo;

import java.awt.event.*;
import java.sql.SQLException;

public class VentanaInsertar extends JFrame implements ActionListener {

  public static final Controlador controlador = new Controlador();

  private JLabel labelTitulo, lblNombre, lblPrimerApellido, lblSegundoApellido, lblSalario, lblCiudad, lblCargo, lblClasificacion, lblDocumento, lblFechaNacimiento;
  private JTextField nombre, primerApellido, segundoApellido, salario, ciudad, cargo, clasificacion, documento, fechaNacimiento;
  private JButton botonGuardar, botonLimpiar;

  public VentanaInsertar() {

    // JFrame
    setLayout(null);
    setSize(460, 500);
    setTitle("Insertar nuevo líder");
    setLocationRelativeTo(null);
    setResizable(false);

    // Título
    labelTitulo = new JLabel("Ingrese un nuevo lider:");
		labelTitulo.setBounds(40, 10, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		add(labelTitulo);

    // Campos

    // Nombre:
    lblNombre = new JLabel("Nombre:");
    lblNombre.setBounds(40,50,160,30);
    add(lblNombre);

    nombre = new JTextField();
    nombre.setBounds(180,50,240,30);
    add(nombre);

    // Primer apellido:
    lblPrimerApellido = new JLabel("Primer Apellido:");
    lblPrimerApellido.setBounds(40,90,160,30);
    add(lblPrimerApellido);

    primerApellido = new JTextField();
    primerApellido.setBounds(180,90,240,30);
    add(primerApellido);

    // Segundo apellido:
    lblSegundoApellido = new JLabel("Segundo Apellido:");
    lblSegundoApellido.setBounds(40,130,160,30);
    add(lblSegundoApellido);

    segundoApellido = new JTextField();
    segundoApellido.setBounds(180,130,240,30);
    add(segundoApellido);

    // Salario:
    lblSalario = new JLabel("Salario:");
    lblSalario.setBounds(40,170,160,30);
    add(lblSalario);

    salario = new JTextField();
    salario.setBounds(180,170,240,30);
    add(salario);

    // Ciudad:
    lblCiudad = new JLabel("Ciudad:");
    lblCiudad.setBounds(40,210,160,30);
    add(lblCiudad);

    ciudad = new JTextField();
    ciudad.setBounds(180,210,240,30);
    add(ciudad);

    // Cargo:
    lblCargo = new JLabel("Cargo:");
    lblCargo.setBounds(40,250,160,30);
    add(lblCargo);

    cargo = new JTextField();
    cargo.setBounds(180,250,240,30);
    add(cargo);

    // Clasificacion:
    lblClasificacion = new JLabel("Clasificacion:");
    lblClasificacion.setBounds(40,290,160,30);
    add(lblClasificacion);

    clasificacion = new JTextField();
    clasificacion.setBounds(180,290,240,30);
    add(clasificacion);

    // Documento:
    lblDocumento = new JLabel("Documento:");
    lblDocumento.setBounds(40,330,160,30);
    add(lblDocumento);

    documento = new JTextField();
    documento.setBounds(180,330,240,30);
    add(documento);

    // Fecha de nacimiento:
    lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
    lblFechaNacimiento.setBounds(40,370,160,30);
    add(lblFechaNacimiento);

    fechaNacimiento = new JTextField();
    fechaNacimiento.setBounds(180,370,240,30);
    add(fechaNacimiento);

    // Botones

    // Guardar
    botonGuardar = new JButton("Guardar");
    botonGuardar.setBounds(320,420,100,30);
    add(botonGuardar);
    botonGuardar.addActionListener(this);

    // Descartar
    botonLimpiar = new JButton("Descartar");
    botonLimpiar.setBounds(210,420,100,30);
    add(botonLimpiar);
    botonLimpiar.addActionListener(this);

  }

  // Limpiar campos
  public void limpiar() {

    nombre.setText("");
    primerApellido.setText("");
    segundoApellido.setText("");
    salario.setText("");
    ciudad.setText("");
    cargo.setText("");
    clasificacion.setText("");
    documento.setText("");
    fechaNacimiento.setText("");

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == botonGuardar) {

      LiderVo lider = new LiderVo();

      lider.setNombre(nombre.getText());
      lider.setPrimerApellido(primerApellido.getText());
      lider.setSegundoApellido(segundoApellido.getText());
      lider.setCiudad(ciudad.getText());
      lider.setCargo(cargo.getText());
      lider.setFechaNacimiento(fechaNacimiento.getText());

      try {

        lider.setSalario(Integer.parseInt(salario.getText()));
        lider.setClasificacion(Integer.parseInt(clasificacion.getText()));
        lider.setDocumento(Integer.parseInt(documento.getText()));
        
      } catch (NumberFormatException nfe) {
        System.out.println(nfe);
      }

      try {

        var success = controlador.insertarLider(lider);

        if (success) {

          JOptionPane.showMessageDialog(null, "El registro se guardo corréctamente.", "¡Guardado!", JOptionPane.PLAIN_MESSAGE);

          limpiar();
          
        } 
        
      } catch (SQLException sqle) {
        System.out.println(sqle);
        JOptionPane.showMessageDialog(null, "Ocurrió un error, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE );
      }

      
      
    }

    // Manejador botón limpiar
    if (e.getSource() == botonLimpiar) {

      limpiar();

    }
    
  }
  
}
