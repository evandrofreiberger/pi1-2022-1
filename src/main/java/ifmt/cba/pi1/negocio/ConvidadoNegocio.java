package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.IConvidadoDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.ConvidadoVO;

public class ConvidadoNegocio {

	private IConvidadoDAO convidadoDAO;

	public ConvidadoNegocio() throws NegocioException {
		// aqui sera instanciado um objeto ConvidadoDAO
	}
	
	public void inserir(ConvidadoVO convidadoVO) throws NegocioException {

		String mensagemErros = this.validarDados(convidadoVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}
		if (this.convidadoDAO != null) {
			try {
				convidadoDAO.beginTransaction();
				convidadoDAO.incluir(convidadoVO);
				convidadoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				convidadoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o convidado - " + ex.getMessage());
			}
		}
	}
	public void alterar(ConvidadoVO convidadoVO) throws NegocioException {
		String mensagemErros = this.validarDados(convidadoVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}
		if (this.convidadoDAO != null) {
			try {
				convidadoDAO.beginTransaction();
				convidadoDAO.alterar(convidadoVO);
				convidadoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				convidadoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o Convidado - " + ex.getMessage());
			}
		}
	}
	public void excluir(ConvidadoVO convidadoVO) throws NegocioException {
		if (this.convidadoDAO != null) {
			try {
				convidadoDAO.beginTransaction();
				convidadoDAO.excluir(convidadoVO);
				convidadoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				convidadoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o Convidado - " + ex.getMessage());
			}
		}
	}
	public List<ConvidadoVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.convidadoDAO != null) {
			try {
				return convidadoDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Convidado pelo nome - " + ex.getMessage());
			}
		} 
		return null;
	}
	public ConvidadoVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.convidadoDAO != null) {
			try {
				return convidadoDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Convidado pelo Codigo - " + ex.getMessage());
			}
		}
		return null;
	}
	private String validarDados(ConvidadoVO convidadoVO) {

		String mensagemErros = "";

		if (convidadoVO.getCodigo() <= 0) {
			mensagemErros += "Codigo deve ser maior que zero";
		}

		if (convidadoVO.getNome() == null || convidadoVO.getNome().length() == 0) {
			mensagemErros += "Nome do Convidado nao pode ser vazio";
		}

		return mensagemErros;
	}
}

