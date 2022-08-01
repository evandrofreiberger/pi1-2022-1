package ifmt.cba.pi1.persistencia;

import ifmt.cba.pi1.vo.AlunoVO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAO<AlunoVO> implements IAlunoDAO {


    public AlunoDAO(EntityManager entityManager) throws PersistenciaException {
        super(entityManager);
    }

    @Override
    public AlunoVO buscarPorMatricula(int matricula) throws PersistenciaException {
        AlunoVO alunoVO = null;
        alunoVO = this.entityManager.find(AlunoVO.class, matricula);
        if (alunoVO == null) {
            throw new PersistenciaException("Erro na selecao por matricula " + matricula);
        }
        return alunoVO;
    }

    @Override
    public List<AlunoVO> buscarPorNome(String nome) throws PersistenciaException {
        List<AlunoVO> listaAlunos = new ArrayList<>();
        try {
            Query query = this.entityManager.createQuery("SELECT a FROM AlunoVO a WHERE UPPER(a.nome) LIKE :pNome ORDER BY a.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaAlunos = query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por nome");
        }
        return listaAlunos;
    }

    @Override
    public void beginTransaction() {
        this.entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        this.entityManager.getTransaction().rollback();
    }
}
