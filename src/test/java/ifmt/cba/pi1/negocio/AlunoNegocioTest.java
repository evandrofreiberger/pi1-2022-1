package ifmt.cba.pi1.negocio;

import static org.junit.Assert.fail;

import org.junit.Test;

import ifmt.cba.pi1.vo.AlunoVO;

public class AlunoNegocioTest {

    private AlunoNegocio alunoNegocio;

    @Test
    public void testAlterar() {
        AlunoVO alunoVO = new AlunoVO();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (alunoNegocio != null) {

            // alteração de aluno - tudo correto
            try {
                alunoVO.setMatricula(123);
                alunoVO.setNome("Fulano das Quantas");
                alunoNegocio.inserir(alunoVO);

            } catch (NegocioException e) {
                fail(e.getMessage()); // não pode gerar exceção
            }

            // inserção de aluno - dados incorretos
            try {
                alunoVO.setMatricula(0);
                alunoVO.setNome("");
                alunoNegocio.inserir(alunoVO); // inserção de aluno - incorreto

            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha na matricula e nome
            }

        }
    }

    @Test
    public void testExcluir() {

    }

    @Test
    public void testInserir() {

        AlunoVO alunoVO = new AlunoVO();

        try {
            alunoNegocio = new AlunoNegocio(); // iniciando o objeto de negócio
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
            fail(e.getMessage()); // se não iniciar o objeto de negócio
        }

        if (alunoNegocio != null) {

            // inserção de aluno - tudo correto
            try {
                alunoVO.setMatricula(123);
                alunoVO.setNome("Fulano das Quantas");
                alunoNegocio.inserir(alunoVO);

                alunoVO = alunoNegocio.pesquisaMatricula(123);
                if (alunoVO != null) {
                    if (alunoVO.getMatricula() != 123) {
                        fail("Erro de gravação da matricula");
                    }
                    if (!alunoVO.getNome().equals("Fulano das Quantas")) {
                        fail("Erro de gravação do nome");
                    }
                } else {
                    fail("Inclusão não foi bem sucedida"); // não localizado
                }

            } catch (NegocioException e) {
                fail(e.getMessage()); // não pode gerar exceção
            }

            // inserção de aluno - dados incorretos
            try {
                alunoVO.setMatricula(0);
                alunoVO.setNome("");
                alunoNegocio.inserir(alunoVO); // inserção de aluno - incorreto

            } catch (NegocioException e) {
                System.out.println(e.getMessage()); // deve gerar exceção e mostrar falha na matricula e nome
            }

        }
    }

    @Test
    public void testPesquisaMatricula() {

    }

    @Test
    public void testPesquisaParteNome() {

    }
}
