package ar.edu.unlam.pb2.excepciones;


public class CazadorException extends RuntimeException {

	public CazadorException(String mensaje) {
		super(mensaje);
	}

	public CazadorException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}

