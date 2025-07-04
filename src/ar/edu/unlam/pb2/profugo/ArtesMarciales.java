package ar.edu.unlam.pb2.profugo;


public class ArtesMarciales extends ProfugoBase {
    
    public ArtesMarciales(Profugo profugo) {
        super(profugo);
    }
    
    
    @Override
    public Integer getNivelHabilidad() {
        int habilidadDuplicada = profugoBase.getNivelHabilidad() * 2;
        return Math.min(100, habilidadDuplicada);
    }
    
    @Override
    public String toString() {
        return profugoBase.toString() + " [Artes Marciales]";
    }
}
