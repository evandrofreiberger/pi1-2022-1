package ifmt.cba.pi1.negocio;

import ifmt.cba.pi1.persistencia.CursoDAO;
import ifmt.cba.pi1.persistencia.FabricaEntityManager;
import ifmt.cba.pi1.persistencia.PersistenciaException;
import ifmt.cba.pi1.vo.CursoVO;

import java.util.List;

public class CursoNegocio {
    private CursoDAO cursoDAO;

    public CursoNegocio() throws NegocioException {
        try {
            this.cursoDAO = new CursoDAO(FabricaEntityManager.getEntityManager());
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar a persistencia -- " + e.getMessage());
        }
    }

    public void inserir(CursoVO cursoVO) throws NegocioException {
        String mensagemErros = this.validarDados(cursoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            cursoDAO.beginTransaction();
            cursoDAO.incluir(cursoVO);
            cursoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir o curso -- " + ex.getMessage());
        }
    }

    public void alterar(CursoVO cursoVO) throws NegocioException {
        String mensagemErros = this.validarDados(cursoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
            cursoDAO.beginTransaction();
            cursoDAO.alterar(cursoVO);
            cursoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            cursoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao alterar o curso -- " + ex.getMessage());
        }
    }

    public void excluir(CursoVO cursoVO) throws NegocioException {
        String mensagemErros = this.validarDados(cursoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
            cursoDAO.beginTransaction();
            cursoDAO.excluir(cursoVO);
            cursoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o curso -- " + ex.getMessage());
        }
    }

    public List<CursoVO> buscarPorNomeCurso(String parteNome) throws NegocioException {
        try {
            return cursoDAO.buscarPorNomeCurso(parteNome);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar curso pelo nome -- " + ex.getMessage());
        }
    }

    public CursoVO pesquisarPorCodigo(int codigo) throws NegocioException {
        try {
            return cursoDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao buscar por codigo do curso -- " + ex.getMessage());
        }
    }

    private String validarDados(CursoVO cursoVO) {

        String mensagemErros = "";

        if (cursoVO.getCodigo() < 0) {
            mensagemErros += "codigo do curso deve ser maior que zero";
        }

        if (cursoVO.getNome() == null || cursoVO.getNome().length() == 0) {
            mensagemErros += "Nome do curso nao pode ser vazio";
        }

        return mensagemErros;
    }
}
