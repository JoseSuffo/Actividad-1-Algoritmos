import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Sistema{
  public static void main(String[] args) {
    Control control = new Control();
//    ArrayList<String> autores = new ArrayList<>();
//    autores.add("Prueba");
//    Instrumento instrumento = new Instrumento("SH", "Encuesta", "Estres", "Identificar", "Mexicali", autores, 1, 2);
//    System.out.println(instrumento);

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

        String nombre = JOptionPane.showInputDialog(ventana,"¿Cuál es el nombre del instrumento?'",
                "Nombre del instrumento", JOptionPane.QUESTION_MESSAGE);

        Object [] botonesTipo = {"Test","Escala", "Cuestionario"};
        int tipoOp = JOptionPane.showOptionDialog(ventana,
                "¿Cuál es el tipo del instrumento?'",
                "Tipo del instrumento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,botonesTipo,botonesTipo[0]);
        String tipo = switch (tipoOp){
            case 0 -> "Test";
            case 1 -> "Escala";
            case 2 -> "Cuestionario";
            default -> "";
        };

        Object [] botonesCondicion = {"Estres", "Ansiedad", "Ambos"};
        int condicionOp = JOptionPane.showOptionDialog(ventana,
                "Elige la condición",
                "Condición del instrumento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botonesCondicion, botonesCondicion[0]);
        String condicion = switch (condicionOp) {
            case 0 -> "Estres";
            case 1 -> "Ansiedad";
            case 2 -> "Ambos";
            default -> "";
        };

          Object [] botonesFuncionalidad = {"Identificar", "Manejar"};
        int funcionalidadOp = JOptionPane.showOptionDialog(ventana,
                "Elige la funcionalidad",
                "Funcionalidad del instrumento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botonesFuncionalidad, botonesFuncionalidad[0]);
        String funcionalidad = switch (funcionalidadOp) {
            case 0 -> "Identificar";
            case 1 -> "Manejar";
            default -> "";
        };

          String cita = JOptionPane.showInputDialog(ventana,"¿Dónde es la cita del instrumento?'",
                "Cita del instrumento", JOptionPane.QUESTION_MESSAGE);

        String numAutores = JOptionPane.showInputDialog(ventana, "¿Cuántos autores tiene el instrumento?",
                "Número de autores del instrumento", JOptionPane.QUESTION_MESSAGE);
        int numeroAutores = Integer.parseInt(numAutores);
        ArrayList<String> autores = new ArrayList<>();
        for(int i=0; i<numeroAutores; i++){
          String autor = JOptionPane.showInputDialog(ventana, "¿Cuál es el nombre del autor "+(i+1)+"?",
                  "Nombre del autor "+(i+1), JOptionPane.QUESTION_MESSAGE);
          autores.add(autor);
        }

        Object[] botonesConfiabilidad = {"No confiable", "Confiable"};
        int confiabilidad = JOptionPane.showOptionDialog(ventana,
                "Elige la confiabilidad del instrumento",
                "Confiabialidad del instrumento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botonesConfiabilidad, botonesConfiabilidad[0]);

        Instrumento instrumento = new Instrumento(nombre,tipo,condicion,funcionalidad,cita,autores,confiabilidad,control.getNumeroInstrumentos());
        control.crearInstrumento(instrumento);
      }
    });

    botonEliminar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        int clave = Integer.parseInt(JOptionPane.showInputDialog(ventana,
                "Ingrese la clave del instrumento a eliminar: ",
                "Clave del instrumento a eliminar", JOptionPane.QUESTION_MESSAGE));
        Instrumento eliminado = control.eliminarInstrumento(clave);
        JOptionPane.showMessageDialog(ventana,
                "Instrumento eliminado \n" + eliminado,
                "Instrumento eliminado", JOptionPane.INFORMATION_MESSAGE);
      }
    });

    botonConsultar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        Object [] botonesConsulta = {"Por autor", "Por funcionalidad", "Por tipo", "Por condición", "Por confiabilidad", "Ordenados por clave",
        "Ordenados por primer autor"};
        int consultaOp = JOptionPane.showOptionDialog(ventana,
                "Elige una consulta",
                "Consultar un instrumento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botonesConsulta, botonesConsulta[0]);
        String consulta;
        switch (consultaOp) {
          case 0:
            consulta = JOptionPane.showInputDialog(ventana,
                    "Ingresa el nombre del autor a buscar: ",
                    "Consulta por autor", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventana, control.consultarPorAutor(consulta),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 1:
            consulta = JOptionPane.showInputDialog(ventana,
                    "Ingresa el nombre de la funcionalidad a buscar: ",
                    "Consulta por funcionalidad", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventana, control.consultarPorFuncionalidad(consulta),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 2:
            consulta = JOptionPane.showInputDialog(ventana,
                    "Ingresa el nombre del tipo a buscar: ",
                    "Consulta por tipo", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventana, control.consultarPorTipo(consulta),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 3:
            consulta = JOptionPane.showInputDialog(ventana,
                    "Ingresa el nombre de la condición a buscar: ",
                    "Consulta por funcionalidad", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventana, control.consultarPorFuncionalidad(consulta),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 4:
            Object [] botones = {"No confiable", "Confiable"};
            int confiabilidad = JOptionPane.showOptionDialog(ventana,
                    "Elige la confiabilidad del instrumento",
                    "Confiabialidad del instrumento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, botones, botones[0]);
            JOptionPane.showMessageDialog(ventana, control.consultarPorConfiabilidad(confiabilidad),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 5:
            JOptionPane.showMessageDialog(ventana, control.consultarTodosLosInstrumentos(),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
          case 6:
            JOptionPane.showMessageDialog(ventana, control.consultarOrdenadosPorPrimerAutor(),
                    "Consulta realizada", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
      }
    });

    botonCargar.addActionListener(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        String archivo=JOptionPane.showInputDialog(ventana,
                "Ingrese el nombre del archivo a consultar: ",
                "Carga de archivo", JOptionPane.QUESTION_MESSAGE);
        control.cargarArchivo(archivo);
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
