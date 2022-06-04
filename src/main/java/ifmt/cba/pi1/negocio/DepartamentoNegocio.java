package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.IDepartamentoDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.DepartamentoVO;

public class DepartamentoNegocio {

	private IDepartamentoDAO departamentoDAO;

	public DepartamentoNegocio() throws NegocioException {
		// aqui sera instanciado um objeto DepartamentoDAO
	}

	public void inserir(DepartamentoVO departamentoVO) throws NegocioException {

		String mensagemErros = this.validarDados(departamentoVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.departamentoDAO != null) {
			try {
				departamentoDAO.beginTransaction();
				departamentoDAO.incluir(departamentoVO);
				departamentoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				departamentoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o departamento - " + ex.getMessage());
			}
		}
	}

	public void alterar(DepartamentoVO departamentoVO) throws NegocioException {
		String mensagemErros = this.validarDados(departamentoVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.departamentoDAO != null) {
			try {
				departamentoDAO.beginTransaction();
				departamentoDAO.alterar(departamentoVO);
				departamentoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				departamentoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o departamento - " + ex.getMessage());
			}
		}
	}

	public void excluir(DepartamentoVO departamentoVO) throws NegocioException {
		if (this.departamentoDAO != null) {
			try {
				departamentoDAO.beginTransaction();
				departamentoDAO.excluir(departamentoVO);
				departamentoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				departamentoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o departamento - " + ex.getMessage());
			}
		}
	}

	public List<DepartamentoVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.departamentoDAO != null) {
			try {
				return departamentoDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar o departamento pelo nome - " + ex.getMessage());
			}
		}
		return null;
	}

	public DepartamentoVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.departamentoDAO != null) {
			try {
				return departamentoDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar departamento pelo codigo - " + ex.getMessage());
			}
		}
		return null;
	}

	private String validarDados(DepartamentoVO departamentoVO) {

		String mensagemErros = "";

		if ( departamentoVO.getCodigo() <= 0) {
			mensagemErros += "Codigo deve ser maior que zero";
		}

		if (departamentoVO.getNome() == null || departamentoVO.getNome().length() == 0) {
			mensagemErros += "Nome do departamento nao pode ser vazio";
		}

		return mensagemErros;
	}
}
