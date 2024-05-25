package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {
    private LocacaoService service;

    @Parameterized.Parameter
    private List<Filme> filmes;

    @Parameterized.Parameter
    private Double valorLocacao;

    @Before
    public void setup() {
        service = new LocacaoService();
    }

    private static Filme filme1 = new Filme("filmes 1", 0, 5.0);
    private static Filme filme2 = new Filme("filmes 2", 0, 5.0);
    private static Filme filme3 = new Filme("filmes 3", 0, 5.0);
    private static Filme filme4 = new Filme("filmes 4", 0, 5.0);
    private static Filme filme5 = new Filme("filmes 5", 0, 5.0);
    private static Filme filme6 = new Filme("filmes 6", 0, 5.0);

    @Parameterized.Parameters
    public static Collection<Object[]> getParametros() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(filme1, filme2, filme3),11.0},
                {Arrays.asList(filme1, filme2, filme3,filme4),13.0},
                {Arrays.asList(filme1, filme2, filme3,filme4, filme5),14.0},
                {Arrays.asList(filme1, filme2, filme3,filme4, filme5,filme6),14.0}

        });
    }

@Test
public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {

    Usuario usuario = new Usuario("usuario");

    Locacao resultado = service.alugarFilme(usuario, filmes);

    assertThat(resultado.getValor(), is(valorLocacao));
}

}
