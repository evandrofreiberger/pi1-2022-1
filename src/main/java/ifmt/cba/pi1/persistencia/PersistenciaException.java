package ifmt.cba.pi1.persistencia;

public class PersistenciaException extends Exception{
    
	public PersistenciaException() {
		super("Erro ocorrido na manipulacao do banco de dados");
	}

	public PersistenciaException(String msg) {
		super(msg);
	}
}
