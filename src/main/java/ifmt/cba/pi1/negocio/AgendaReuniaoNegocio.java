package ifmt.cba.pi1.negocio;

import ifmt.cba.pi1.persistencia.IAgendaReuniaoDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.AgendaReuniaoVO;

public class AgendaReuniaoNegocio {

	private IAgendaReuniaoDAO agendaReuniaoDAO;

	public AgendaReuniaoNegocio() throws NegocioException {
		// aqui sera instanciado um objeto AgendaReuniaoDAO
	}
	public void inserir(AgendaReuniaoVO agendaReuniaoVO) throws NegocioException {

		String mensagemErros = this.validarDados(agendaReuniaoVO);
		
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.agendaReuniaoDAO != null) {
			try {
				agendaReuniaoDAO.beginTransaction();
				agendaReuniaoDAO.incluir(agendaReuniaoVO);
				agendaReuniaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				agendaReuniaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o AgendaReuniao - " + ex.getMessage());
			}
		}
	}
	public void alterar(AgendaReuniaoVO agendaReuniaoVO) throws NegocioException {
		String mensagemErros = this.validarDados(agendaReuniaoVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.agendaReuniaoDAO != null) {
			try {
				agendaReuniaoDAO.beginTransaction();
				agendaReuniaoDAO.alterar(agendaReuniaoVO);
				agendaReuniaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				agendaReuniaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o Agenda Reuniao - " + ex.getMessage());
			}
		}
	}
	public void excluir(AgendaReuniaoVO agendaReuniaoVO) throws NegocioException {
		if (this.agendaReuniaoDAO != null) {
			try {
				agendaReuniaoDAO.beginTransaction();
				agendaReuniaoDAO.excluir(agendaReuniaoVO);
				agendaReuniaoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				agendaReuniaoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o Agenda Reuniao - " + ex.getMessage());
			}
		}
	}

	public AgendaReuniaoVO pesquisaParteCodigo(int parteCodigo) throws NegocioException {
		if (this.agendaReuniaoDAO != null) {
			try {
				return agendaReuniaoDAO.buscarPorCodigo(parteCodigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Agenda Reuniao pelo Codigo - " + ex.getMessage());
			}
		} 
		return null;
	}
	public AgendaReuniaoVO pesquisaCodigo(int codigo) throws NegocioException {
		if (this.agendaReuniaoDAO != null) {
			try {
				return agendaReuniaoDAO.buscarPorCodigo(codigo);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar Agenda Reuniao pelo Codigo - " + ex.getMessage());
			}
		}
		return null;
	}

	private String validarDados(AgendaReuniaoVO agendaReuniaoVO) {

		String mensagemErros = "";

		if (agendaReuniaoVO.getCodigo() <= 0) {
			mensagemErros += "Codigo deve ser maior que zero";
		}

		if (agendaReuniaoVO.getAssunto() == null || agendaReuniaoVO.getAssunto().length() == 0) {
			mensagemErros += "Assunto da Agenda Reuniao nao pode ser vazio";
		}

		return mensagemErros;
	}
}

