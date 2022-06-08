package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.DepartamentoVO;

public interface IDepartamentoDAO extends IDAO {

	public void incluir(DepartamentoVO departamentoVO) throws PersistenciaException;

	public void alterar(DepartamentoVO departamentoVO) throws PersistenciaException;

	public void excluir(DepartamentoVO departamentoVO) throws PersistenciaException;

	public DepartamentoVO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<DepartamentoVO> buscarPorNome(String nome) throws PersistenciaException;
}
