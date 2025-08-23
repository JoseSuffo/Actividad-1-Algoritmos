import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Control {
    //Atributo de la clase Control
    ArrayList<Instrumento> instrumentos;

    //Constructor de la clase Control
    public Control() {
        instrumentos = new ArrayList<>();
    }

    //Alta de un instrumento en el ArrayList y el archivo
    public void altas(Instrumento instrumento){
        instrumento.setClave(instrumentos.size()+1);
        instrumentos.add(instrumento);
        agregarAArchivo(instrumento);
    }

    //Baja de un instrumento mediante una clave que se recibe como parámetro, si se encuentra se elimina
    public Instrumento bajas(int clave){
        for (int i = 0; i < instrumentos.size(); i++) {
            if (instrumentos.get(i).getClave() == clave) {
                return instrumentos.remove(i);
            }
        }
        return null;
    }

    //Consulta de instrumentos por autor, que se recibe como parámetro. Si se encuentra se muestran
    //si no, se muestra un mensaje.
    public String consultarPorAutor(String autor){
        ArrayList<String> autores;
        for (Instrumento instrumento : instrumentos) {
            autores=instrumento.getAutores();
            if(autores.contains(autor)){
                return instrumento.toString();
            }
        }
        return "Autor no encontrado o el autor no tiene instrumentos realizados";
    }

    //Consulta de instrumentos por tipo, que se recibe como parámetro. Si se encuentra se muestran
    //si no, se muestra un mensaje.
    public String consultarPorTipo(String tipo){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getTipo().equals(tipo)){
                return instrumento.toString();
            }
        }
        return "Tipo no encontrado o el tipo no tiene instrumentos realizados";
    }

    //Consulta de instrumentos por funcionalidad, que se recibe como parámetro. Si se encuentra se muestran
    //si no, se muestra un mensaje.
    public String consultarPorFuncionalidad(String funcionalidad){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getFuncionalidad().equals(funcionalidad)){
                return instrumento.toString();
            }
        }
        return "Funcionalidad no encontrada o la funcionalidad no tiene instrumentos realizados";
    }

    //Consulta de instrumentos por condición, que se recibe como parámetro. Si se encuentra se muestran
    //si no, se muestra un mensaje.
    public String consultarPorCondicion(String condicion){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getCondicion().equals(condicion)){
                return instrumento.toString();
            }
        }
        return "Condición no encontrada o la condición no tiene instrumentos realizados";
    }

    //Consulta de instrumentos por confiabilidad, que se recibe como parámetro. Si se encuentra se muestran
    //si no, se muestra un mensaje.
    public String consultarPorConfiabilidad(int confiabilidad){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getConfiabilidad() == confiabilidad){
                return instrumento.toString();
            }
        }
        return "Confiabilidad no encontrada o la confiabilidad no tiene instrumentos realizados";
    }

    //Consulta de todos los instrumentos ordenados por clave (debido a que se crean claves en orden
    //numérico y ya estan ordenadas).
    public String consultarTodosLosInstrumentos(){
        String instrumentosMensaje = "";
        for (Instrumento instrumento : instrumentos) {
            instrumentosMensaje += instrumento.toString() + "\n";
        }
        if(instrumentosMensaje.isEmpty()){
            return "No hay instrumentos realizados";
        }
        return instrumentosMensaje;
    }


    //Consulta de todos los instrumentos ordenados por primer autor. Todos los primeros autores de cada instrumento
    //se comparan y se ordenan dependiendo de cuál tiene una letra inicial más baja.
    public String consultarOrdenadosPorPrimerAutor(){
        instrumentos.sort((o1, o2) ->
                o1.getPrimerAutor().compareToIgnoreCase(o2.getPrimerAutor()));
        String instrumentosOrdenadosPrimerA = "";
        for (Instrumento instrumento : instrumentos) {
            instrumentosOrdenadosPrimerA += instrumento.toString() + "\n";
        }
        return instrumentosOrdenadosPrimerA;
    }

    //Metodo que crea un instrumento
    public void crearInstrumento(Instrumento instrumento){
        altas(instrumento);
    }

    //Se agrega un instrumento recibido como parámetro a un archivo de texto predefinido previamente.
    //Esto se logra con la clase FileWriter.
    public void agregarAArchivo(Instrumento instrumento) {
        try (FileWriter fw = new FileWriter("registro.txt", true)){
            fw.write(instrumento.versionArchivo() + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar instrumento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Se cargan los instrumentos de un archivo que se recibe como parámetro a nuestro ArrayList de instrumentos.
    //Cada linea de texto se lee y se separa para poder agregarla al arraylist correspondiente.
    public void cargarArchivo(String nombreArchivo){
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while((linea = br.readLine()) != null){
                String [] valores = linea.split(",");
                String nombre = valores[0];
                String tipo = valores[1];
                String condicion = valores[2];
                String funcionalidad = valores[3];
                String cita = valores[4];
                String [] autoresAux = valores[5].split(",");
                ArrayList<String> autores = new ArrayList<>(Arrays.asList(autoresAux));
                int confiablidad = Integer.parseInt(valores[6]);
                int clave = Integer.parseInt(valores[7]);
                instrumentos.add(new Instrumento(nombre, tipo, condicion, funcionalidad, cita, autores, confiablidad, clave));
                JOptionPane.showMessageDialog(null, "Instrumentos cargados", "Informacion cargada", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar instrumento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Getter del número de instrumentos añadidos al ArrayList
    public int getNumeroInstrumentos(){
        return instrumentos.size();
    }
}
