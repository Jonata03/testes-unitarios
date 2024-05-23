package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocacaoServiceTest {
    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void teste() throws Exception {
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 2, 5.0);

        //acao
        Locacao locacao = service.alugarFilme(usuario, filme);
        error.checkThat(locacao.getValor(), is(equalTo(5.0)));
        error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        error.checkThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

        //verificacao
    }

    @Test(expected = FilmeSemEstoqueException.class)
    public void testeLocacao_filmeSemEstoque() throws Exception {
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("usuario 2");
        Filme filme = new Filme("filme 2", 0, 5.0);

        //acao
        service.alugarFilme(usuario, filme);

    }

    @Test
    public void testeLocacao_usuarioVazio() throws FilmeSemEstoqueException {
        //cenario
        LocacaoService service = new LocacaoService();
        Filme filme = new Filme("filme 2", 1, 5.0);

        //acao
        try {
            service.alugarFilme(null, filme);
            Assert.fail();
        } catch (LocadoraException e) {
            assertThat(e.getMessage(), is("Usuario vazio"));
        }
    }

    @Test
    public void testLocacao_filme() throws FilmeSemEstoqueException, LocadoraException {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("usuario 2");

        exception.expect(LocadoraException.class);
        exception.expectMessage("Filme vazio");
        //acao
        service.alugarFilme(usuario, null);


    }
}
