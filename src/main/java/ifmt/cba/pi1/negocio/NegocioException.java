package ifmt.cba.pi1.negocio;

public class NegocioException extends Exception {

    public NegocioException() {
        super("Erro ocorrido na camada de negocio");
    }

    public NegocioException(String msg) {
        super(msg);
    }
}
