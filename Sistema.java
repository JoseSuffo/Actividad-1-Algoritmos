import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Sistema{
  public static void main(String[] args) {
    JFrame ventana = new JFrame("Salud de Sistema Integral Guasavito");
    ventana.setSize(600,600);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null);
    ventana.setLayout(null);

    ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Actividad-1-Algoritmos\\saludSistema_main.jpg");
    JLabel picLabel = new JLabel(pic);
    picLabel.setBounds(0,0,600,600);
    ventana.setContentPane(picLabel);

    JPanel panel = new JPanel(null);
    panel.setOpaque(false);
    panel.setBounds(0,0,600,600);

    JButton botonAgregar = new JButton("Agregar");
    JButton botonEliminar = new JButton("Eliminar");
    JButton botonConsultar = new JButton("Consultar");
    JButton botonCargar = new JButton("Cargar");
    JButton botonSalir = new JButton("Salir");

    botonAgregar.setBounds(225,50,150,75);
    botonAgregar.setBackground(new Color(70,130,180));
    botonAgregar.setForeground(Color.WHITE);
    botonAgregar.setFont(new Font("Arial", Font.BOLD,15));
    botonAgregar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    botonEliminar.setBounds(225,135,150,75);
    botonEliminar.setBackground(new Color(70,130,180));
    botonEliminar.setForeground(Color.WHITE);
    botonEliminar.setFont(new Font("Arial", Font.BOLD,15));
    botonEliminar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    botonConsultar.setBounds(225,220,150,75);
    botonConsultar.setBackground(new Color(70,130,180));
    botonConsultar.setForeground(Color.WHITE);
    botonConsultar.setFont(new Font("Arial", Font.BOLD,15));
    botonConsultar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    botonCargar.setBounds(225,305,150,75);
    botonCargar.setBackground(new Color(70,130,180));
    botonCargar.setForeground(Color.WHITE);
    botonCargar.setFont(new Font("Arial", Font.BOLD,15));
    botonCargar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    botonSalir.setBounds(225,390,150,75);
    botonSalir.setBackground(new Color(70,130,180));
    botonSalir.setForeground(Color.WHITE);
    botonSalir.setFont(new Font("Arial", Font.BOLD,15));
    botonSalir.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    botonAgregar.setVisible(true);
    botonEliminar.setVisible(true);
    botonConsultar.setVisible(true);
    botonCargar.setVisible(true);
    botonSalir.setVisible(true);

    botonAgregar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null,"Bienvenido a Sistema de Salud Integral Guasavito");
      }
    });

    botonEliminar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    botonConsultar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    botonCargar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    botonSalir.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    ventana.add(botonAgregar);
    ventana.add(botonEliminar);
    ventana.add(botonConsultar);
    ventana.add(botonCargar);
    ventana.add(botonSalir);
    ventana.add(panel);
    ventana.setVisible(true);
  }
}