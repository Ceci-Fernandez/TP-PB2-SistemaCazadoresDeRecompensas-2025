package ar.edu.unlam.pb2.agencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.pb2.cazadores.CazadorUrbano;
import ar.edu.unlam.pb2.excepciones.CazadorException;
import ar.edu.unlam.pb2.sistema.Agencia;
import ar.edu.unlam.pb2.sistema.Zona;

public class AgenciaTest {
	 private Agencia agencia;
	 private CazadorUrbano cazador;
	 private Zona zona;

	@Before
	public void sepUp() {
		 agencia = new Agencia();
	     cazador = new CazadorUrbano("Pedro", 50);
	     zona = new Zona("Agreste");
	        
	     agencia.registrarCazador(cazador);
	     agencia.registrarZona(zona);
	
	}
	
	@Test(expected = CazadorException.class)
    public void queNoHayaCazadorDuplicado() {
        CazadorUrbano cazadorDuplicado = new CazadorUrbano("Pedro", 30);
        agencia.registrarCazador(cazadorDuplicado);
    }

}
