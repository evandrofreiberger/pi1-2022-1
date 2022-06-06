package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.TCCVO;


public interface ITCCDAO extends IDAO{
    public void incluir(TCCVO tccVO) throws PersistenciaException;
	
	public void alterar(TCCVO tccVO) throws PersistenciaException;

	public void excluir(TCCVO tccVO) throws PersistenciaException;

    public TCCVO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<AlunoVO> buscarPorNome(String nome) throws PersistenciaException;

}