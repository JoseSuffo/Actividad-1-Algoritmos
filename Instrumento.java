import java.util.ArrayList;

public class Instrumento {
    String nombre, tipo, condicion, funcionalidad, cita;
    ArrayList<String> autores;
    int confiabilidad, clave;

    public Instrumento(String nombre, String tipo, String condicion, String funcionalidad, String cita, ArrayList<String> autores, int confiabilidad, int clave) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.condicion = condicion;
        this.funcionalidad = funcionalidad;
        this.cita = cita;
        this.autores = autores;
        this.confiabilidad = confiabilidad;
        this.clave = clave;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getTipo(){
        return tipo;
    }

    public String getFuncionalidad(){
        return funcionalidad;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public int getConfiabilidad() {
        return confiabilidad;
    }

    public String toString(){
        return nombre + "\n" + tipo + "\n" + condicion + "\n" + funcionalidad + "\n" + cita + "\n" + autores +
                "\n" + confiabilidad + "\n" + clave + "\n";
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
}
