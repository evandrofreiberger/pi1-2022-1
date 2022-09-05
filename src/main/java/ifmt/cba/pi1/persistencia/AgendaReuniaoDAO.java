package ifmt.cba.pi1.persistencia;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Query;

import ifmt.cba.pi1.vo.AgendaReuniaoVO;

import javax.persistence.EntityManager;

public class AgendaReuniaoDAO extends DAO<AgendaReuniaoVO> implements IAgendaReuniaoDAO{

	public AgendaReuniaoDAO(EntityManager entityManager) throws PersistenciaException{
		super(entityManager);
	}

	@Override
    public void incluir(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException{ 
		try{
			this.entityManager.persist(agendaReuniaoVO);
		} catch (Exception e){
			throw new PersistenciaException("Erro ao incluir " + agendaReuniaoVO.getClass() + "- " + e.getMessage());
		}
	}
	
	@Override
	public void alterar(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException{
		try{
			this.entityManager.merge(agendaReuniaoVO);
		} catch (Exception e){
			throw new PersistenciaException("Erro ao alterar " + agendaReuniaoVO.getClass() + "- " + e.getMessage());
		}
	}

	@Override
	public void excluir(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException{
		try{
			this.entityManager.remove(agendaReuniaoVO);
		} catch (Exception e){
			throw new PersistenciaException("Erro ao excluir " + agendaReuniaoVO + "- " + e.getMessage());
		}
	}

	@Override
    public AgendaReuniaoVO buscarPorCodigo(int parteCodigo) throws PersistenciaException{ 
		
		AgendaReuniaoVO age = null;

		try{
			age = this.entityManager.find(AgendaReuniaoVO.class, parteCodigo);
		} catch(Exception e){
			throw new PersistenciaException("Erro na seleção por codigo -" + e.getMessage());
		}
		return age; 	
	}

	@Override
	public List<AgendaReuniaoVO> buscarPorNome(String nome) throws PersistenciaException{
		List<AgendaReuniaoVO> listaAgenda = new ArrayList<AgendaReuniaoVO>();

		try{
			Query query = this.entityManager.createQuery("SELECT a FROM agendaReuniaoVO a WHERE UPPER(a.nome) LIKE :pNome ORDER BY a.nome");
			query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
			listaAgenda = query.getResultList();
		} catch(Exception e){
			throw new PersistenciaException("Erro na busca por nome");
		}
		return listaAgenda;
	}
  
}
