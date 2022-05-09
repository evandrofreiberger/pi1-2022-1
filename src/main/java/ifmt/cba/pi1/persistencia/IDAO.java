package ifmt.cba.pi1.persistencia;

public interface IDAO {
    
    public void beginTransaction();
	
	public void commitTransaction();
	
	public void rollbackTransaction();
}
