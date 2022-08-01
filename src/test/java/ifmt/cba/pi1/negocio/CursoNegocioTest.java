package ifmt.cba.pi1.negocio;

import ifmt.cba.pi1.persistencia.FabricaEntityManager;
import ifmt.cba.pi1.vo.CursoVO;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.*;

public class CursoNegocioTest {

    private CursoNegocio cursoNegocio;

    @Test
    public void inserir() {

        this.preparaDadosCursoInclusao();

        try {
            cursoNegocio = new CursoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (cursoNegocio != null) {

            // inserção de curso - tudo correto
            try {
                CursoVO cursoVO = new CursoVO();
                cursoVO.setNome("Matematica");
                cursoNegocio.inserir(cursoVO);

                cursoVO = cursoNegocio.buscarPorNomeCurso("Matematica").get(0);
                System.out.println(cursoVO);
                if (cursoVO != null) {
                    if (cursoVO.getCodigo() == 0) {
                        fail("Erro de gravação da matricula");
                    }
                    if (!cursoVO.getNome().equals("Matematica")) {
                        fail("Erro de gravação do nome");
                    }
                } else {
                    fail("Inclusão não foi bem sucedida"); // não localizado
                }

            } catch (NegocioException e) {
                e.printStackTrace();
                fail(e.getMessage()); // não pode gerar exceção
            }

            // inserção de aluno - dados incorretos
            try {
                CursoVO cursoVO = new CursoVO();
                cursoVO.setNome("");
                cursoNegocio.inserir(cursoVO); // inserção de curso - incorreto
                fail("Não poderia chegar nessa linha, deve gerar exceção antes");
            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha no nome
            }

        }
    }


    @Test
    public void alterar() {

        this.preparaDadosCursoAlteracao();

        try {
            cursoNegocio = new CursoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (cursoNegocio != null) {

            //update de curso - tudo correto
            try {
                CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia de controle").get(0);

                cursoVO.setNome("Engenharia eletrica");

                cursoNegocio.alterar(cursoVO);

                cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia eletrica").get(0);

                if (cursoVO != null) {
                    if (!cursoVO.getNome().equals("Engenharia eletrica")) {
                        fail("Erro de alteracao do nome");
                    }
                } else {
                    fail("Inclusão não foi bem sucedida"); // não localizado
                }
            } catch (NegocioException e) {
                e.printStackTrace();
                fail(e.getMessage()); // não pode gerar exceção
            }

            try {
                CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia eletrica").get(0);
                cursoVO.setNome("");
                cursoNegocio.alterar(cursoVO); // inserção de curso - incorreto
                fail("Não poderia chegar nessa linha, deve gerar exceção antes");
            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha na matricula e nome
            }

        }
    }

    @Test
    public void excluir() {

        this.preparaDadosCursoExclusao();

        try {
            cursoNegocio = new CursoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        //delete de curso - tudo correto

        try {

            if (cursoNegocio != null) {

                CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia de controle").get(0);
                cursoNegocio.excluir(cursoVO);
            }

        } catch (NegocioException e) {
            e.printStackTrace();
            fail(e.getMessage()); // não pode gerar exceção
        }

        // delete de curso - dados incorretos
        try {
            CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Matematica").get(0);
            cursoNegocio.excluir(cursoVO); // exclusao de aluno - correto

            cursoNegocio.excluir(cursoVO); // exclusao de aluno - incorreto
            fail("Não poderia chegar nessa linha, deve gerar exceção antes");
        } catch (NegocioException e) {
            System.out.println(e.getMessage()); // deve gerar exceção e mostrar que nao encontrou aluno para exclusao
        }

    }


    @Test
    public void pesquisarPorCodigo() {

        this.preparaDadosCursoExclusao();

        try {
            cursoNegocio = new CursoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        //Pesquisa de aluno por matricula - tudo correto
        try {

            if (cursoNegocio != null) {

                cursoNegocio.pesquisarPorCodigo(1);
                cursoNegocio.pesquisarPorCodigo(2);
            }

        } catch (NegocioException e) {
            e.printStackTrace();
            fail(e.getMessage()); // não pode gerar exceção
        }

        try {
            cursoNegocio.pesquisarPorCodigo(10); //pesquisa por codigo - incorreto
        } catch (NegocioException e) {
            System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha no nome
        }

    }

    private void preparaDadosCursoInclusao() {
        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        em.getTransaction().commit();
    }


    private void preparaDadosCursoAlteracao() {
        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        CursoVO cursoVO = new CursoVO("Engenharia de controle");
        em.persist(cursoVO);
        em.getTransaction().commit();
    }

    private void preparaDadosCursoExclusao() {
        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        CursoVO cursoVO = new CursoVO("Engenharia de controle");
        CursoVO cursoVO1 = new CursoVO("Matematica");
        em.persist(cursoVO);
        em.persist(cursoVO1);
        em.getTransaction().commit();
    }

}