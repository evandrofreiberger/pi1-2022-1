package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.ProfessorOrientadorVO;

public interface IProfessorOrientadorDAO extends IDAO{
    public void incluir(ProfessorOrientadorVO professorOrientadorVO) throws PersistenciaException;
	
	public void alterar(ProfessorOrientadorVO professorOrientadorVO) throws PersistenciaException;

	public void excluir(ProfessorOrientadorVO professorOrientadorVO) throws PersistenciaException;

    public ProfessorOrientadorVO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<ProfessorOrientadorVO> buscarPorNome(String nome) throws PersistenciaException;

	public ProfessorOrientadorVO buscarPorCodigo(Object codigo);
}
