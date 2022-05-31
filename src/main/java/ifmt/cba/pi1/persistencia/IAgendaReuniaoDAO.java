package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.AgendaReuniaoVO;

public interface IAgendaReuniaoDAO extends IDAO {

    public void incluir(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException;
	
	public void alterar(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException;

	public void excluir(AgendaReuniaoVO agendaReuniaoVO) throws PersistenciaException;

    public AgendaReuniaoVO buscarPorCodigo(int parteCodigo) throws PersistenciaException;

	public List<AgendaReuniaoVO> buscarPorNome(String nome) throws PersistenciaException;
  
}
