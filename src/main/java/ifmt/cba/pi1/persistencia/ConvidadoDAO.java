package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.ConvidadoVO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ConvidadoDAO extends DAO<ConvidadoVO> implements IConvidadoDAO {

    public ConvidadoDAO(EntityManager entityManager) throws PersistenciaException{
        super(entityManager);
    }

    @Override
    public void incluir(ConvidadoVO convidadoVO) throws PersistenciaException{
        try{
            this.entityManager.persist(convidadoVO);
        } catch (Exception e){
            throw new PersistenciaException ("Erro ao incluir " + convidadoVO.getClass() + " - " + e.getMessage());
        }
    }
	
    @Override
	public void alterar(ConvidadoVO convidadoVO) throws PersistenciaException{
        try{
            this.entityManager.merge(convidadoVO);
        } catch(Exception e){
            throw new PersistenciaException("Erro ao alterar " + convidadoVO.getClass() + " - " + e.getMessage());
        }
    }

    @Override
	public void excluir(ConvidadoVO convidadoVO) throws PersistenciaException{
        try{
            this.entityManager.remove(convidadoVO);
        } catch (Exception e){
            throw new PersistenciaException("Erro ao remover " + convidadoVO.getClass() + " - " + e.getMessage());
        }
    }

    @Override
    public ConvidadoVO buscarPorCodigo(int codigo) throws PersistenciaException{
        ConvidadoVO convidadoVO = null;
        convidadoVO = this.entityManager.find(ConvidadoVO.class, codigo);
        if(convidadoVO == null){
            throw new PersistenciaException("Erro na busca pelo codigo " + codigo);
        }
        return convidadoVO;
    }

    @Override
    public List<ConvidadoVO> buscarPorNome(String nome) throws PersistenciaException{
        List<ConvidadoVO> listaConvidado = new ArrayList<>();
        try{
            Query query = this.entityManager.createQuery("SELECT a FROM ConvidadoVO a WHERE UPPER(a.nome) LIKE :pNome ORDER BY a.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaConvidado = query.getResultList();
        } catch (Exception e){
            throw new PersistenciaException("Erro na selecao por nome - " + e.getMessage());
        }
        return listaConvidado;
    }
}