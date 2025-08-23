import java.util.ArrayList;

public class Instrumento {
    //Atributos de la clase Instrumento
    String nombre, tipo, condicion, funcionalidad, cita;
    ArrayList<String> autores;
    int confiabilidad, clave;

    //Constructor de la clase Instrumento
    public Instrumento(String nombre, String tipo, String condicion, String funcionalidad, String cita, ArrayList<String> autores, int confiabilidad, int clave) {
        this.nombre = nombre;
        this.tipo = tipo; //Test, escala o cuestionario
        this.condicion = condicion; //Estres, ansiedad o ambos
        this.funcionalidad = funcionalidad; //Identificar o manejar
        this.cita = cita;
        this.autores = autores;
        this.confiabilidad = confiabilidad;
        this.clave = clave;
    }

    //Getters y setters de algunos atributos
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

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getPrimerAutor(){
        return autores.getFirst();
    }

    //Versión para agregar al archivo de texto
    public String versionArchivo(){
        return nombre + "," + tipo + "," + condicion + "," + funcionalidad + "," + cita + "," + autores +
                "," + confiabilidad + "," + clave;
    }

    //Versión para mostrar en los JOptionPane
    public String toString() {
        String confiabilidadString = "";
        if(this.confiabilidad==1){
            confiabilidadString = "Confiable";
        }else{
            confiabilidadString = "No confiable";
        }
        return "Nombre: "+nombre + "\n" + "Tipo: " + tipo + "\n" + "Condición: " + condicion + "\n" + "Funcionalidad: " + funcionalidad + "\n" + "Lugar de cita: " + cita + "\n"
                + "Autores: " + autores + "\n" + "Confiablidad: " + confiabilidadString + "\n" + "Clave: " + clave;
    }
}
