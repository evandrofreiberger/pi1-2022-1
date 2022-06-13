package ifmt.cba.pi1.negocio;

import ifmt.cba.pi1.persistencia.IApresentacaoDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.ApresentacaoVO;

public class ApresentacaoNegocio {

	private IApresentacaoDAO apresentacaoDAO;

	public ApresentacaoNegocio() throws NegocioException {
		
	}
	public void inserir(ApresentacaoVO apresentacaoVO) throws NegocioException {

		String mensagemErros = this.validarDados(apresentacaoVO);
		
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.apresentacaoDAO != null) {
			try {
				apresentacaoDAO.beginTransaction();
				apresentacaoDAO.incluir(apresentacaoVO);
				apresentacaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				apresentacaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir a Apresentacao - " + ex.getMessage());
			}
		}
	}
	public void alterar(ApresentacaoVO apresentacaoVO) throws NegocioException {
		String mensagemErros = this.validarDados(apresentacaoVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.apresentacaoDAO != null) {
			try {
				apresentacaoDAO.beginTransaction();
				apresentacaoDAO.alterar(apresentacaoVO);
				apresentacaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				apresentacaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar a Apresentacao - " + ex.getMessage());
			}
		}
	}
	public void excluir(ApresentacaoVO apresentacaoVO) throws NegocioException {
		if (this.apresentacaoDAO != null) {
			try {
				apresentacaoDAO.beginTransaction();
				apresentacaoDAO.excluir(apresentacaoVO);
				apresentacaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				apresentacaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir a Apresentacao - " + ex.getMessage());
			}
		}
	}


	public ApresentacaoVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.apresentacaoDAO != null) {
			try {
				return apresentacaoDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar a Apresentacao pelo Codigo - " + ex.getMessage());
			}
		}
		return null;
	}

	private String validarDados(ApresentacaoVO apresentacaoVO) {

		String mensagemErros = "";

		if (apresentacaoVO.getCodigo() <= 0) {
			mensagemErros += "Codigo deve ser maior que zero";
		}

		return mensagemErros;
	}
}

