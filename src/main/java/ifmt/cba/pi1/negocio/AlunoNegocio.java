package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.IAlunoDAO;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.AlunoVO;

public class AlunoNegocio {

	private IAlunoDAO alunoDAO;

	public AlunoNegocio() throws NegocioException {
		// aqui sera instanciado um objeto AlunoDAO
	}

	public void inserir(AlunoVO alunoVO) throws NegocioException {

		String mensagemErros = this.validarDados(alunoVO);

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.alunoDAO != null) {
			try {
				alunoDAO.beginTransaction();
				alunoDAO.incluir(alunoVO);
				alunoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				alunoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao incluir o aluno - " + ex.getMessage());
			}
		}
	}

	public void alterar(AlunoVO alunoVO) throws NegocioException {
		String mensagemErros = this.validarDados(alunoVO);
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		if (this.alunoDAO != null) {
			try {
				alunoDAO.beginTransaction();
				alunoDAO.alterar(alunoVO);
				alunoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				alunoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao alterar o aluno - " + ex.getMessage());
			}
		}
	}

	public void excluir(AlunoVO alunoVO) throws NegocioException {
		if (this.alunoDAO != null) {
			try {
				alunoDAO.beginTransaction();
				alunoDAO.excluir(alunoVO);
				alunoDAO.commitTransaction();
			} catch (PersistenciaException ex) {
				alunoDAO.rollbackTransaction();
				throw new NegocioException("Erro ao excluir o aluno - " + ex.getMessage());
			}
		}
	}

	public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException {
		if (this.alunoDAO != null) {
			try {
				return alunoDAO.buscarPorNome(parteNome);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar aluno pelo nome - " + ex.getMessage());
			}
		} 
		return null;
	}

	public AlunoVO pesquisaMatricula(int matricula) throws NegocioException {
		if (this.alunoDAO != null) {
			try {
				return alunoDAO.buscarPorMatricula(matricula);
			} catch (PersistenciaException ex) {
				throw new NegocioException("Erro ao pesquisar aluno pela matricula - " + ex.getMessage());
			}
		}
		return null;
	}

	private String validarDados(AlunoVO alunoVO) {

		String mensagemErros = "";

		if (alunoVO.getNome() == null || alunoVO.getNome().length() == 0) {
			mensagemErros += "Nome do aluno nao pode ser vazio";
		}

		if (alunoVO.getNomeMae() == null || alunoVO.getNomeMae().length() == 0) {
			mensagemErros += "\nNome da mae nao pode ser vazio";
		}

		if (alunoVO.getNomePai() == null || alunoVO.getNomePai().length() == 0) {
			mensagemErros += "\nNome do pai nao pode ser vazio";
		}

		if (alunoVO.getSexo() == null) {
			mensagemErros += "\nSexo nao pode ser nulo";
		}

		if (alunoVO.getEndereco().getLogradouro() == null || alunoVO.getEndereco().getLogradouro().length() == 0) {
			mensagemErros += "\nLogradouro nao pode ser vazio";
		}

		if (alunoVO.getEndereco().getNumero() <= 0) {
			mensagemErros += "\nNumero deve ser maior que zero";
		}

		if (alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().length() == 0) {
			mensagemErros += "\nBairro nao pode ser vazio";
		}

		if (alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade().length() == 0) {
			mensagemErros += "\nCidade nao pode ser vazio";
		}
		if (alunoVO.getEndereco().getUf() == null) {
			mensagemErros += "\nUF nao pode ser vazio";
		}

		return mensagemErros;
	}
}
