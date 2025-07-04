package ar.edu.unlam.pb2.profugo;

public abstract class ProfugoBase extends Profugo {
    protected Profugo profugoBase;
    
   
    public ProfugoBase(Profugo profugo) {
        super(profugo.getNivelInocencia(), profugo.getNivelHabilidad(), profugo.isNervioso());
        this.profugoBase = profugo;
    }

    @Override
    public Integer getNivelInocencia() {
        return profugoBase.getNivelInocencia();
    }
    
    @Override
    public Integer getNivelHabilidad() {
        return profugoBase.getNivelHabilidad();
    }
    
    @Override
    public Boolean isNervioso() {
        return profugoBase.isNervioso();
    }
}
