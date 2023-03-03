/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe;

/**
 *
 * @author Angel
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorDivisas extends JFrame implements ActionListener {
  private static final long serialVersionUID = 1L;

  // Agregar constante para la tasa de cambio
  private static final double TASA_CAMBIO = 3.80;

  private final JLabel lblSoles;
  private final JTextField txtSoles;
  private final JButton btnSolesADolares;
  private final JLabel lblDolares;
  private final JTextField txtDolares;
  private final JButton btnDolaresASoles;
  // Agregar formato para reducir decimales a dos
  private final DecimalFormat formato = new DecimalFormat("#.##");

  public ConversorDivisas() {
    setTitle("Conversor de Divisas");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Crear componentes
    lblSoles = new JLabel("Soles:");
    txtSoles = new JTextField(10);
    btnSolesADolares = new JButton("Convertir a Dólares");
    btnSolesADolares.addActionListener(this);
    lblDolares = new JLabel("Dólares:");
    txtDolares = new JTextField(10);
    btnDolaresASoles = new JButton("Convertir a Soles");
    btnDolaresASoles.addActionListener(this);

    // Crear paneles
    JPanel pnlSoles = new JPanel();
    pnlSoles.add(lblSoles);
    pnlSoles.add(txtSoles);
    pnlSoles.add(btnSolesADolares);
    pnlSoles.add(lblDolares);
    pnlSoles.add(txtDolares);
    pnlSoles.add(btnDolaresASoles);

    // Agregar componentes a la ventana
    add(pnlSoles, BorderLayout.CENTER);

    pack();
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSolesADolares) {
      // Convertir de soles a dólares
      double soles = Double.parseDouble(txtSoles.getText());
      double dolares = soles / TASA_CAMBIO;
      // Formatear resultado con dos decimales
      txtDolares.setText(formato.format(dolares));
    } else if (e.getSource() == btnDolaresASoles) {
      // Convertir de dólares a soles
      double dolares = Double.parseDouble(txtDolares.getText());
      double soles = dolares * TASA_CAMBIO;
      // Formatear resultado con dos decimales
      txtSoles.setText(formato.format(soles));
    }
  }
}

