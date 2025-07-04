package ar.edu.unlam.pb2.profugo;

public class EntrenamientoElite extends ProfugoBase {
    
    public EntrenamientoElite(Profugo profugo) {
        super(profugo);
    }
 
    @Override
    public Boolean isNervioso() {
        return false;
    }
    
 
    @Override
    public void setNervioso(Boolean nervioso) {
        
    }
    
    @Override
    public String toString() {
        return profugoBase.toString() + " [Entrenamiento Elite]";
    }

}
