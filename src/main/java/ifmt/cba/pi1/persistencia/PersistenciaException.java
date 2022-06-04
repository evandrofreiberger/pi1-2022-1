package ifmt.cba.pi1.persistencia;

public class PersistenciaException extends Exception{
	private static final long serialVersionUID = 1L;

	public PersistenciaException() {
		super("Erro ocorrido na manipulacao do banco de dados");
	}

	public PersistenciaException(String msg) {
		super(msg);
	}
}
