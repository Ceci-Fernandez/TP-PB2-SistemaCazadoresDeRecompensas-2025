package ar.edu.unlam.pb2.excepciones;

public class ProfugoException  extends RuntimeException  {

	public ProfugoException(String mensaje) {
		super(mensaje);
	}

	public ProfugoException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}


