/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe;

//import java.awt.Dimension;
/**
 *
 * @author Angel
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConvertidorMonedas extends JFrame {

  public ConvertidorMonedas() {
    super("Conversor");

    // Crear opciones para JComboBox
    String[] opciones = { "Conversor de Monedas", "Conversor de Temperatura" };

    // Crear JComboBox
    JComboBox<String> cboOpciones = new JComboBox<>(opciones);

    // Agregar ActionListener al JComboBox
    cboOpciones.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Obtener opción seleccionada
        String opcionSeleccionada = (String) cboOpciones.getSelectedItem();

        // Verificar si se seleccionó "Conversor de Monedas"
        if (opcionSeleccionada.equals("Conversor de Monedas")) {
          // Crear JPanel para conversor de monedas
          JPanel pnlConversion = new JPanel();

          // pnlConversion.setPreferredSize(new Dimension(500, 300));

          // Crear JLabel y JTextField para ingresar cantidad
          JLabel lblCantidad = new JLabel("Ingrese la cantidad:");
          JTextField txtCantidad = new JTextField(10);

          // Agregar JLabel y JTextField al JPanel
          pnlConversion.add(lblCantidad);
          pnlConversion.add(txtCantidad);

          // Crear botón para realizar conversión
          JButton btnOK = new JButton("OK");

          // Agregar ActionListener al botón
          btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // Obtener cantidad ingresada
              double cantidad = Double.parseDouble(txtCantidad.getText());

              // Crear JComboBox para seleccionar conversión
              JComboBox<String> cboConversion = new JComboBox<>(new String[] {
                  "Soles a Dólares", "Soles a Euros", "Dólares a Soles" });

              // Agregar ActionListener al JComboBox
              cboConversion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  // Obtener conversión seleccionada
                  String conversion = (String) cboConversion.getSelectedItem();

                  // Realizar conversión
                  double resultado = 0;
                  String mensajeResultado = "";
                  if (conversion.equals("Soles a Dólares")) {
                    resultado = cantidad / 3.80;
                    mensajeResultado = String.format("%.2f soles son %.2f dólares", cantidad, resultado);
                  } else if (conversion.equals("Soles a Euros")) {
                    resultado = cantidad * 4.20;
                    mensajeResultado = String.format("%.2f Soles son %.2f Euros", cantidad, resultado);
                  } else if (conversion.equals("Dólares a Soles")) {
                    resultado = cantidad * 3.80;
                    mensajeResultado = String.format("%.2f dólares son %.2f soles", cantidad, resultado);
                  }

                  // Mostrar resultado en JOptionPane
                  JOptionPane.showMessageDialog(null, mensajeResultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                  // Ocultar ventana actual
                  setVisible(false);
                }
              });

              // Agregar JComboBox al JPanel
              pnlConversion.add(cboConversion);

              // Actualizar contenido del JPanel
              pnlConversion.revalidate();
              pnlConversion.repaint();
            }
          });

          // Agregar botón al JPanel
          pnlConversion.add(btnOK);

          // Agregar JPanel a la ventana principal
          setContentPane(pnlConversion);
          pack();
          // Establecer tamaño del JFrame
          // setSize(500, 300);

        } else if (opcionSeleccionada.equals("Conversor de Temperatura")) {
          JPanel pnlCoversionTemperatura = new JPanel();
          JLabel lblCantidadTemperatura = new JLabel("Ingrese la cantidad");
          JTextField txtCantidadTemperatura = new JTextField(10);
          pnlCoversionTemperatura.add(lblCantidadTemperatura);
          pnlCoversionTemperatura.add(txtCantidadTemperatura);
          JButton btnOKtemperatura = new JButton("OK");
          btnOKtemperatura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
              double cantidadTemperatura = Double.parseDouble(txtCantidadTemperatura.getText());
              
              JComboBox<String> cboConversionTemperatura = new JComboBox<>(new String []{"Celcios a Fahrenheit","Celcios a Kelvin"});
              cboConversionTemperatura.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  String conversionTemperatura = (String) cboConversionTemperatura.getSelectedItem();

                  double resultadoTemperatura = 0;
                  String mensajeResultadoTemperatura = "";
                  if (conversionTemperatura.equals("Celcios a Fahrenheit")) {
                    resultadoTemperatura = cantidadTemperatura * 1.8 + 32;
                    mensajeResultadoTemperatura = String.format("%.2f Celcios son %.2f Fahrenheit", cantidadTemperatura, resultadoTemperatura);
                  }

                  JOptionPane.showMessageDialog(null, mensajeResultadoTemperatura, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                  setVisible(false);
                }
              });

              pnlCoversionTemperatura.add(cboConversionTemperatura);
              
              pnlCoversionTemperatura.revalidate();
              
              pnlCoversionTemperatura.repaint();
            }
          });

          pnlCoversionTemperatura.add(btnOKtemperatura);

          setContentPane(pnlCoversionTemperatura);
          pack();
        }
      }
    });

    // Agregar JComboBox a la ventana principal
    JPanel pnlPrincipal = new JPanel();
    pnlPrincipal.add(cboOpciones);
    setContentPane(pnlPrincipal);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    new ConvertidorMonedas();
  }
}
