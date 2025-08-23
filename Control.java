import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Control {
    ArrayList<Instrumento> instrumentos;
    String archivo;

    public Control() {
        instrumentos = new ArrayList<>();
    }

    public void altas(Instrumento instrumento){
        instrumento.setClave(instrumentos.size()+1);
        instrumentos.add(instrumento);
        agregarAArchivo(instrumento);
    }

    public Instrumento bajas(int clave){
        for (int i = 0; i < instrumentos.size(); i++) {
            if (instrumentos.get(i).getClave() == clave) {
                return instrumentos.remove(i);
            }
        }
        return null;
    }

    public String consultarPorAutor(String autor){
        ArrayList<String> autores = new ArrayList<>();
        for (Instrumento instrumento : instrumentos) {
            autores=instrumento.getAutores();
            if(autores.contains(autor)){
                return instrumento.toString();
            }
        }
        return "Autor no encontrado o el autor no tiene instrumentos realizados";
    }

    public String consultarPorTipo(String tipo){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getTipo().equals(tipo)){
                return instrumento.toString();
            }
        }
        return "Tipo no encontrado o el tipo no tiene instrumentos realizados";
    }

    public String consultarPorFuncionalidad(String funcionalidad){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getFuncionalidad().equals(funcionalidad)){
                return instrumento.toString();
            }
        }
        return "Funcionalidad no encontrada o la funcionalidad no tiene instrumentos realizados";
    }

    public String consultarPorCondicion(String condicion){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getCondicion().equals(condicion)){
                return instrumento.toString();
            }
        }
        return "Condición no encontrada o la condición no tiene instrumentos realizados";
    }

    public String consultarPorConfiabilidad(int confiabilidad){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getConfiabilidad() == confiabilidad){
                return instrumento.toString();
            }
        }
        return "Confiabilidad no encontrada o la confiabilidad no tiene instrumentos realizados";
    }

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

    public String consultarOrdenadosPorPrimerAutor(){
        instrumentos.sort((o1, o2) ->
                o1.getPrimerAutor().compareToIgnoreCase(o2.getPrimerAutor()));
        String instrumentosOrdenadosPrimerA = "";
        for (Instrumento instrumento : instrumentos) {
            instrumentosOrdenadosPrimerA += instrumento.toString() + "\n";
        }
        return instrumentosOrdenadosPrimerA;
    }

    public void crearInstrumento(Instrumento instrumento){
        altas(instrumento);
    }

    public void agregarAArchivo(Instrumento instrumento) {
        try (FileWriter fw = new FileWriter("registro.txt", true)){
            fw.write(instrumento.versionArchivo() + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar instrumento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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

    public int getNumeroInstrumentos(){
        return instrumentos.size();
    }
}
