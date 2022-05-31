package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.IProfessorOrientadorDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.ProfessorOrientadorVO;

public class ProfessorOrientadorNegocio {
    
	private IProfessorOrientadorDAO professorOrientadorDAO;

	public ProfessorOrientadorNegocio() throws NegocioException {
		// aqui sera instanciado um objeto professorOrientadorDAO
	}

	public void inserir(ProfessorOrientadorVO ProfessorOrientadorVO) throws NegocioException {

		String mensagemErros = this.validarDados(ProfessorOrientadorVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.professorOrientadorDAO != null) {
			try {
				professorOrientadorDAO.beginTransaction();
				professorOrientadorDAO.incluir(ProfessorOrientadorVO);
				professorOrientadorDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorOrientadorDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o aluno - " + ex.getMessage());
			}
		}
	}

	public void alterar(ProfessorOrientadorVO ProfessorOrientadorVO) throws NegocioException {
		String mensagemErros = this.validarDados(ProfessorOrientadorVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.professorOrientadorDAO != null) {
			try {
				professorOrientadorDAO.beginTransaction();
				professorOrientadorDAO.alterar(ProfessorOrientadorVO);
				professorOrientadorDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorOrientadorDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o aluno - " + ex.getMessage());
			}
		}
	}

	public void excluir(ProfessorOrientadorVO ProfessorOrientadorVO) throws NegocioException {
		if (this.professorOrientadorDAO != null) {
			try {
				professorOrientadorDAO.beginTransaction();
				professorOrientadorDAO.excluir(ProfessorOrientadorVO);
				professorOrientadorDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				professorOrientadorDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o aluno - " + ex.getMessage());
			}
		}
	}

	public List<ProfessorOrientadorVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.professorOrientadorDAO != null) {
			try {
				return professorOrientadorDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar aluno pelo nome - " + ex.getMessage());
			}
		} 
		return null;
	}

	public ProfessorOrientadorVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.professorOrientadorDAO != null) {
			try {
				return professorOrientadorDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Convidado pelo Codigo - " + ex.getMessage());
			}
		}
		return null;
    }

	private String validarDados(ProfessorOrientadorVO ProfessorOrientadorVO) {

		String mensagemErros = "";

		if (ProfessorOrientadorVO.getMatricula() == null || ProfessorOrientadorVO.getMatricula().length() == 0) {
			mensagemErros += "Matricula não pode ser nula";
		}

		if (ProfessorOrientadorVO.getNome() == null || ProfessorOrientadorVO.getNome().length() == 0) {
			mensagemErros += "Nome do aluno nao pode ser vazio";
		}

		return mensagemErros;
	}
}
