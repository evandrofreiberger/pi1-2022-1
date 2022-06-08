package ifmt.cba.pi1.persistencia;

import ifmt.cba.pi1.vo.CursoVO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO extends DAO<CursoVO> implements ICursoDAO {

    public CursoDAO(EntityManager entityManager) throws PersistenciaException {
        super(entityManager);
    }


    @Override
    public CursoVO buscarPorCodigo(int codigo) throws PersistenciaException {
        CursoVO cursoVO = null;
        try {
            cursoVO = this.entityManager.find(CursoVO.class, codigo);
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por codigo -- " + ex.getMessage());
        }
        return cursoVO;
    }

    @Override
    public List<CursoVO> buscarPorNomeCurso(String nome) throws PersistenciaException {
        List<CursoVO> listaCurso = new ArrayList<>();
        try {
            Query query = this.entityManager.createQuery(
                    "SELECT c FROM CursoVO c WHERE UPPER(c.nome) LIKE :pNome ORDER BY c.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaCurso = query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por nome  -- " + ex.getMessage());
        }
        return listaCurso;
    }

    public void beginTransaction() {
        this.entityManager.getTransaction().begin();
    }


    public void commitTransaction() {
        this.entityManager.getTransaction().commit();
    }


    public void rollbackTransaction() {
        this.entityManager.getTransaction().rollback();
    }
}