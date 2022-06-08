package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.ProfessorDisciplinaVO;;

public interface IProfessorDiciplinaDAO extends IDAO {
    public void incluir(ProfessorDisciplinaVO professorDisciplinaVO) throws PersistenciaException;
	
	public void alterar(ProfessorDisciplinaVO professorDisciplinaVO) throws PersistenciaException;

	public void excluir(ProfessorDisciplinaVO professorDisciplinaVO) throws PersistenciaException;

    public ProfessorDisciplinaVO buscarPorCodigo(int codigo) throws PersistenciaException;

	public List<ProfessorDisciplinaVO> buscarPorNome(String nome) throws PersistenciaException;

	public ProfessorDisciplinaVO buscarPorCodigo(Object codigo);
}
