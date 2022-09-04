package personagens.personagem_base;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import test.Mapa;

public abstract class Mago extends Personagem{
    public Mago(Mapa mapa) {
        super(mapa);
    }
    @Override
    public void atacar() throws PersonagemNaoEncontradoNoMapaException {

        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null && !p.fazParteDaSociedade())
                p.setConstituicao((p.getConstituicao()) - (this.inteligencia));

        }
    }
    @Override
    public void avancar() throws PersonagemNaoEncontradoNoMapaException {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null)
                return;
        }
        if(this.fazParteDaSociedade()){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial + 1]  = this;
        }
    }
}
