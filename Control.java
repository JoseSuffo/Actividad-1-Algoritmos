import javax.swing.*;
import java.util.ArrayList;

public class Control {
    ArrayList<Instrumento> instrumentos;

    public Control() {
        instrumentos = new ArrayList<>();
    }

    public void altas(Instrumento instrumento){
        instrumento.setClave(instrumentos.size()+1);
        instrumentos.add(instrumento);
    }

    public Instrumento bajas(Instrumento instrumento){
        instrumentos.remove(instrumento);
        return instrumento;
    }

    public ArrayList<Instrumento> getInstrumentos(){
        return instrumentos;
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

    public String consultarPorOrdenClave(){
        String ordenClave = "";
        for (Instrumento instrumento : instrumentos) {
            ordenClave += instrumento.toString() + "\n";
        }
        if(ordenClave.equals("")){
            return "No hay instrumentos realizados";
        }
        return ordenClave;
    }

    public String consultarTodosLosInstrumentos(){
        String instrumentosMensaje = "";
        for (Instrumento instrumento : instrumentos) {
            instrumentosMensaje += instrumento.toString() + "\n";
        }
        if(instrumentosMensaje.equals("")){
            return "No hay instrumentos realizados";
        }
        return instrumentosMensaje;
    }

    public Instrumento eliminarInstrumento(int clave){
        for (Instrumento instrumento : instrumentos) {
            if(instrumento.getClave() == clave){
                bajas(instrumento);
                return instrumento;
            }
        }
        return null;
    }

    public void crearInstrumento(Instrumento instrumento){
        altas(instrumento);
    }

    public void agregarAArchivo(){

    }
}
