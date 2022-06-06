package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.ITCCDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.TCCVO;

public class TCCNegocio {

	private ITCCDAO tccDAO;

	public TCCNegocio() throws NegocioException {
		
	}

	public void inserir(TCCVO tccVO) throws NegocioException {

		String mensagemErros = this.validarDados(tccVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.tccDAO != null) {
			try {
				tccDAO.beginTransaction();
				tccDAO.incluir(tccVO);
				tccDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				tccDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o TCC - " + ex.getMessage());
			}
		}
	}

	public void alterar(TCCVO tccVO) throws NegocioException {
		String mensagemErros = this.validarDados(tccVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.tccDAO != null) {
			try {
				tccDAO.beginTransaction();
				tccDAO.alterar(tccVO);
				tccDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				tccDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o TCC - " + ex.getMessage());
			}
		}
	}

	public void excluir(TCCVO tccVO) throws NegocioException {
		if (this.tccDAO != null) {
			try {
				tccDAO.beginTransaction();
				tccDAO.excluir(tccVO);
				tccDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				tccDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o TCC - " + ex.getMessage());
			}
		}
	}

	public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.tccDAO != null) {
			try {
				return tccDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar TCC pelo nome de aluno - " + ex.getMessage());
			}
		} 
		return null;
	}

	public TCCVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.tccDAO != null) {
			try {
				return tccDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar TCC pelo codigo" + ex.getMessage());
			}
		}
		return null;
	}

	private String validarDados(TCCVO tccVO) {

		String mensagemErros = "";

		if (tccVO.getCodigo() <= 0) {
			mensagemErros += "Codigo deve ser maior que zero";
		}

		if (tccVO.getTema() == null || tccVO.getTema().length() == 0) {
			mensagemErros += "O tema nao pode ser vazio";
		}

		return mensagemErros;
	}
}
