package br.ce.wcaquino.daos;

import br.ce.wcaquino.entidades.Locacao;

import java.util.List;

public class LocacaoDAOFake implements LocacaoDAO{
    public void salvar(Locacao locaco){

    }

    @Override
    public List<Locacao> obterLocacoesPendentes() {
        return null;
    }
}
