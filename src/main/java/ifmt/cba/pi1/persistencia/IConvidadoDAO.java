package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.ConvidadoVO;

public interface IConvidadoDAO extends IDAO {

    public void incluir(ConvidadoVO convidadoVO) throws PersistenciaException;
	
	public void alterar(ConvidadoVO convidadoVO) throws PersistenciaException;

	public void excluir(ConvidadoVO convidadoVO) throws PersistenciaException;

    public ConvidadoVO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<ConvidadoVO> buscarPorNome(String nome) throws PersistenciaException;

	public ConvidadoVO buscarPorCodigo(Object codigo);
  
}