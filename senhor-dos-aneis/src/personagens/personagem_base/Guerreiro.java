package personagens.personagem_base;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import test.Mapa;

public abstract class Guerreiro extends Personagem{
    public Guerreiro(Mapa mapa) {
        super(mapa);
    }
    @Override
    public void atacar() throws PersonagemNaoEncontradoNoMapaException {
        int count = 1;
        if(!this.fazParteDaSociedade()){
            count = -1;
        }
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + count);
        if(p1 != null){
            if((this.fazParteDaSociedade() && !p1.fazParteDaSociedade()) || !this.fazParteDaSociedade() && p1.fazParteDaSociedade())
                p1.setConstituicao(p1.getConstituicao() - (this.forca*2));
        }
    }
    @Override
    public void avancar() throws PersonagemNaoEncontradoNoMapaException {
        int count = 1;
        if(!this.fazParteDaSociedade()){
            count = -1;
        }
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().getPersonagens()[posicaoInicial + count];
        if(p1 == null){
            this.getMapa().getPersonagens()[posicaoInicial] = null;
            this.getMapa().getPersonagens()[posicaoInicial + count] = this;
        }
    }
}
