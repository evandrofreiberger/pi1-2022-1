package ifmt.cba.pi1.persistencia;

import javax.persistence.EntityManager;

public abstract class DAO<VO> {

    protected EntityManager entityManager;

    public DAO(EntityManager entityManager) throws PersistenciaException {
        this.entityManager = entityManager;
    }

    public void incluir(VO vo) throws PersistenciaException {
        try {
            this.entityManager.persist(vo);
        } catch (Exception e) {
            throw new PersistenciaException("Erro ao incluir " + vo.getClass() + " - " + e.getMessage());
        }
    }

    public void alterar(VO vo) throws PersistenciaException {
        try {
            this.entityManager.merge(vo);
        } catch (Exception e) {
            throw new PersistenciaException("Erro ao alterar " + vo.getClass() + " - " + e.getMessage());
        }
    }

    public void excluir(VO vo) throws PersistenciaException {
        try {
            this.entityManager.remove(vo);
        } catch (Exception e) {
            throw new PersistenciaException("Erro ao excluir " + vo.getClass() + " - " + e.getMessage());
        }
    }
}
