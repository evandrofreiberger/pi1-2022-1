package ifmt.cba.pi1.negocio;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import ifmt.cba.pi1.persistencia.FabricaEntityManager;
import ifmt.cba.pi1.vo.AlunoVO;
import ifmt.cba.pi1.vo.CursoVO;

public class AlunoNegocioTest {

    public static final String NOME = "Gabriel Jose";
    private AlunoNegocio alunoNegocio;
    private CursoNegocio cursoNegocio;

    @Test
    public void testAlterar() {

        this.preparaDadosAlunoAlteracao();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
            cursoNegocio = new CursoNegocio();
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (alunoNegocio != null) {

            //update de aluno - tudo correto
            try {
                AlunoVO alunoVO = alunoNegocio.pesquisaPorNome("Ricardo").get(0);

                alunoVO.setNome("Rui");
                alunoNegocio.alterar(alunoVO);

                alunoVO = alunoNegocio.pesquisaPorNome("Rui").get(0);

                if (alunoVO != null) {
                    if (!alunoVO.getNome().equals("Rui")) {
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
                AlunoVO alunoVO = alunoNegocio.pesquisaPorNome("Rui").get(0);
                alunoVO.setNome("");
                alunoNegocio.alterar(alunoVO); // inserção de aluno - incorreto
                fail("Não poderia chegar nessa linha, deve gerar exceção antes");
            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha na matricula e nome
            }
        }

    }

    @Test
    public void testExcluir() {

        this.preparaDadosAlunoExclusao();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
            cursoNegocio = new CursoNegocio();
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        //delete de aluno - tudo correto

        try {

            if (alunoNegocio != null) {

                AlunoVO alunoVO = alunoNegocio.pesquisaPorNome("Ricardo").get(0);
                alunoNegocio.excluir(alunoVO);
            }

        } catch (NegocioException e) {
            e.printStackTrace();
            fail(e.getMessage()); // não pode gerar exceção
        }

        // delete de aluno - dados incorretos
        try {
            AlunoVO alunoVO = alunoNegocio.pesquisaPorNome("Rui").get(0);
            alunoNegocio.excluir(alunoVO); // exclusao de aluno - correto

            alunoNegocio.excluir(alunoVO); // exclusao de aluno - incorreto
            fail("Não poderia chegar nessa linha, deve gerar exceção antes");
        } catch (NegocioException e) {
            System.out.println(e.getMessage()); // deve gerar exceção e mostrar que nao encontrou aluno para exclusao
        }
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

        if (alunoNegocio != null) {

            // inserção de aluno - tudo correto
            try {
                AlunoVO alunoVO = new AlunoVO();
                alunoVO.setNome(NOME);

                CursoVO cursoVO = cursoNegocio.buscarPorNomeCurso("Engenharia de controle").get(0);
                alunoVO.setCursoVO(cursoVO);
                alunoNegocio.inserir(alunoVO);
                alunoVO = alunoNegocio.pesquisaPorNome(NOME).get(0);
                if (alunoVO != null) {
                    if (alunoVO.getMatricula() == 0) {
                        fail("Erro de gravação da matricula");
                    }
                    if (!alunoVO.getNome().equals(NOME)) {
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
                AlunoVO alunoVO = new AlunoVO();
                alunoVO.setNome("");
                alunoNegocio.inserir(alunoVO); // inserção de aluno - incorreto
                fail("Não poderia chegar nessa linha, deve gerar exceção antes");
            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha no nome
            }

        }
    }

    @Test
    public void testPesquisaMatricula() {

        this.preparaDadosAlunoExclusao();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
            cursoNegocio = new CursoNegocio();
        } catch (NegocioException e) {
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        //Pesquisa de aluno por matricula - tudo correto
        try {

            if (alunoNegocio != null) {
                alunoNegocio.pesquisaMatricula(2);
            }

        } catch (NegocioException e) {
            e.printStackTrace();
            fail(e.getMessage()); // não pode gerar exceção
        }

        try {
            alunoNegocio.pesquisaMatricula(10); //pesquisa por matricula - incorreto
        } catch (NegocioException e) {
            System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha no nome
        }
    }

    private void preparaDadosAlunoInclusao() {

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

    private void preparaDadosAlunoAlteracao() {

        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        CursoVO cursoVO = new CursoVO("Engenharia de controle");
        AlunoVO alunoVO = new AlunoVO("Ricardo");
        alunoVO.setCursoVO(cursoVO);
        em.persist(cursoVO);
        em.persist(alunoVO);
        em.getTransaction().commit();
    }

    private void preparaDadosAlunoExclusao() {
        EntityManager em = FabricaEntityManager.getEntityManager();
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("DELETE FROM aluno");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("DELETE FROM curso");
        query2.executeUpdate();
        CursoVO cursoVO = new CursoVO("Engenharia de controle");
        AlunoVO alunoVO = new AlunoVO("Eduardo");
        alunoVO.setCursoVO(cursoVO);
        em.persist(cursoVO);
        em.persist(alunoVO);
        em.getTransaction().commit();
    }

}
