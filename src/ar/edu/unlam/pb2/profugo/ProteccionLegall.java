package ar.edu.unlam.pb2.profugo;

public class ProteccionLegall extends ProfugoBase {

	 private static final int INOCENCIA_MINIMA = 40;
	    
	    public ProteccionLegall(Profugo profugo) {
	        super(profugo);
	    }
	    
	    
	    @Override
	    public Integer getNivelInocencia() {
	        return Math.max(INOCENCIA_MINIMA, profugoBase.getNivelInocencia());
	    }
	  
	    @Override
	    public void reducirInocencia(Integer cantidad) {
	        profugoBase.reducirInocencia(cantidad);
	       
	    }
	    
	    @Override
	    public String toString() {
	        return profugoBase.toString() + " [Protección Legal]";
	    }
}
