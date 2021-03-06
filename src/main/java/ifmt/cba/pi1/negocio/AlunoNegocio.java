package ifmt.cba.pi1.negocio;

import java.util.List;

import ifmt.cba.pi1.persistencia.AlunoDAO;
import ifmt.cba.pi1.persistencia.FabricaEntityManager;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.AlunoVO;

public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException {
        try {
            this.alunoDAO = new AlunoDAO(FabricaEntityManager.getEntityManager());
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar a persistencia -- " + e.getMessage());
        }
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
            try {
                alunoDAO.beginTransaction();
                alunoDAO.excluir(alunoVO);
                alunoDAO.commitTransaction();
            } catch (PersistenciaException ex) {
                alunoDAO.rollbackTransaction();
                throw new NegocioException("Erro ao excluir o aluno - " + ex.getMessage());
            }
        }


    public List<AlunoVO> pesquisaPorNome(String parteNome) throws NegocioException {
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
            try {
                return alunoDAO.buscarPorMatricula(matricula);
            } catch (PersistenciaException ex) {
                throw new NegocioException("Erro ao pesquisar aluno pela matricula - " + ex.getMessage());
            }
        }

    private String validarDados(AlunoVO alunoVO) {

        String mensagemErros = "";

        if (alunoVO.getMatricula() < 0) {
            mensagemErros += "Matricula deve ser maior que zero";
        }

		if (alunoVO.getNome() == null || alunoVO.getNome().length() == 0) {
			mensagemErros += "\nNome do aluno nao pode ser vazio";
		}

        return mensagemErros;
    }
}