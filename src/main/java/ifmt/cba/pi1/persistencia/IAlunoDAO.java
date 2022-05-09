package ifmt.cba.pi1.persistencia;

import java.util.List;

import ifmt.cba.pi1.vo.AlunoVO;

public interface IAlunoDAO extends IDAO {

    public void incluir(AlunoVO alunoVO) throws PersistenciaException;
	
	public void alterar(AlunoVO alunoVO) throws PersistenciaException;

	public void excluir(AlunoVO alunoVO) throws PersistenciaException;

    public AlunoVO buscarPorMatricula(int matricula) throws PersistenciaException;

	public List<AlunoVO> buscarPorNome(String nome) throws PersistenciaException;
  
}
