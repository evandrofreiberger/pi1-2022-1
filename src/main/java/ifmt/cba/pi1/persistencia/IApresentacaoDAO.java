package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.ApresentacaoVO;


public interface IApresentacaoDAO extends IDAO{
    public void incluir(ApresentacaoVO apresentacaoVO) throws PersistenciaException;
	
	public void alterar(ApresentacaoVO apresentacaoVO) throws PersistenciaException;

	public void excluir(ApresentacaoVO apresentacaoVO) throws PersistenciaException;

    public ApresentacaoDAO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<ApresentacaoVO> buscarPorNome(String nome) throws PersistenciaException;

}