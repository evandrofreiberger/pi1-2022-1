package ifmt.cba.pi1.negocio;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import ifmt.cba.pi1.persistencia.FabricaEntityManager;
import ifmt.cba.pi1.vo.AlunoVO;
import ifmt.cba.pi1.vo.CursoVO;

public class AlunoNegocioTest {

    private AlunoNegocio alunoNegocio;
    private CursoNegocio cursoNegocio;

    @Test
    public void testAlterar() {
 
    }

    @Test
    public void testExcluir() {

    }

    @Test
    public void testInserir() {

        this.preparaDadosAlunoInclusao();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
            cursoNegocio = new CursoNegocio();
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (alunoNegocio != null && cursoNegocio != null) {

            // inserção de aluno - tudo correto
            try {
                AlunoVO alunoVO = new AlunoVO();
                alunoVO.setNome("Fulano das Quantas");

                CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia da Computação").get(0);
                alunoVO.setCursoVO(cursoVO);

                alunoNegocio.inserir(alunoVO);
 
                alunoVO = alunoNegocio.pesquisaPorNome("Fulano das Quantas").get(0);
                if (alunoVO != null) {
                    if (alunoVO.getMatricula() == 0) {
                        fail("Erro de gravação da matricula");
                    }
                } else {
                    fail("Inclusão não foi bem sucedida"); // não localizado
                }

            } catch (NegocioException e) {
                fail(e.getMessage()); // não pode gerar exceção
            }

            // inserção de aluno - dados incorretos
            try {
                AlunoVO alunoVO = new AlunoVO();
                alunoVO.setNome("");
                alunoNegocio.inserir(alunoVO); // inserção de aluno - incorreto
                fail("Não poderia chegar nessa linha, deve gerar exceção antes");
            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha na matricula e nome
            }

        }
    }

    @Test
    public void testPesquisaMatricula() {

    }

    private void preparaDadosAlunoInclusao(){

        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        CursoVO cursoVO = new CursoVO("Engenharia da Computação");
        em.persist(cursoVO);
        em.getTransaction().commit();

    }
}
