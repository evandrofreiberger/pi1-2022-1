package ifmt.cba.pi1.negocio;

public class NegocioException extends Exception {
	private static final long serialVersionUID = 1L;

	public NegocioException() {
        super("Erro ocorrido na camada de negocio");
    }

    public NegocioException(String msg) {
        super(msg);
    }
}
