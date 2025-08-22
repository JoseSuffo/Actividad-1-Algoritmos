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
}
