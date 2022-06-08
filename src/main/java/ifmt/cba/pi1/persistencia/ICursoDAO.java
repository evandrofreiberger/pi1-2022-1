package ifmt.cba.pi1.persistencia;


import ifmt.cba.pi1.vo.CursoVO;

import java.util.List;

public interface ICursoDAO {

    public void incluir(CursoVO cursoVO) throws PersistenciaException;

    public void alterar(CursoVO cursoVO) throws PersistenciaException;

    public void excluir(CursoVO cursoVO) throws PersistenciaException;

    public CursoVO buscarPorCodigo(int matricula) throws PersistenciaException;

    public List<CursoVO> buscarPorNomeCurso(String nome) throws PersistenciaException;

}
