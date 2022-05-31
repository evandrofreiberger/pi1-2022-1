package ifmt.cba.pi1.negocio;


import java.util.List;

import ifmt.cba.pi1.persistencia.IProfessorDiciplinaDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.ProfessorDisciplinaVO;

public class ProfessorDiciplinaNegocio {
    private IProfessorDiciplinaDAO professorDiciplinaDAO;

	public ProfessorDiciplinaNegocio() throws NegocioException {
		// aqui sera instanciado um objeto ProfessorDiciplinaDAO
	}
	
	public void inserir(ProfessorDisciplinaVO professorDisciplinaVO) throws NegocioException {

		String mensagemErros = this.validarDados(professorDisciplinaVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}
		if (this.professorDiciplinaDAO != null) {
			try {
				professorDiciplinaDAO.beginTransaction();
				professorDiciplinaDAO.incluir(professorDisciplinaVO);
				professorDiciplinaDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorDiciplinaDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o convidado - " + ex.getMessage());
			}
		}
	}
	public void alterar(ProfessorDisciplinaVO professorDisciplinaVO) throws NegocioException {
		String mensagemErros = this.validarDados(professorDisciplinaVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}
		if (this.professorDiciplinaDAO != null) {
			try {
				professorDiciplinaDAO.beginTransaction();
				professorDiciplinaDAO.alterar(professorDisciplinaVO);
				professorDiciplinaDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorDiciplinaDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o Convidado - " + ex.getMessage());
			}
		}
	}
	public void excluir(ProfessorDisciplinaVO professorDisciplinaVO) throws NegocioException {
		if (this.professorDiciplinaDAO != null) {
			try {
				professorDiciplinaDAO.beginTransaction();
				professorDiciplinaDAO.excluir(professorDisciplinaVO);
				professorDiciplinaDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorDiciplinaDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o Convidado - " + ex.getMessage());
			}
		}
	}
	public List<ProfessorDisciplinaVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.professorDiciplinaDAO != null) {
			try {
				return professorDiciplinaDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Convidado pelo nome - " + ex.getMessage());
			}
		} 
		return null;
	}
	public ProfessorDisciplinaVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.professorDiciplinaDAO != null) {
			try {
				return professorDiciplinaDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Convidado pelo Codigo - " + ex.getMessage());
			}
		}
		return null;
	}
	private String validarDados(ProfessorDisciplinaVO professorDisciplinaVO) {

		String mensagemErros = "";

		if (professorDisciplinaVO.getMatricula() == null || professorDisciplinaVO.getMatricula().length() == 0) {
			mensagemErros += "Matricula não pode ser nula";
		}

		if (professorDisciplinaVO.getNome() == null || professorDisciplinaVO.getNome().length() == 0) {
			mensagemErros += "Nome do Convidado nao pode ser vazio";
		}

		return mensagemErros;
	}
}
