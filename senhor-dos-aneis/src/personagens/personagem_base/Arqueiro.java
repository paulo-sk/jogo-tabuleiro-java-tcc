package personagens.personagem_base;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import test.Mapa;

public abstract class Arqueiro extends Personagem{

    public Arqueiro(Mapa mapa) {
        super(mapa);
    }

    @Override
    public void atacar() throws PersonagemNaoEncontradoNoMapaException {
        int penultimaPosicao = 8;
        int antiPenultimaPosicao = 7;
        int ataque3 = 3;
        int ataque2 = 2;
        int ataque1 = 1;

        if(!this.fazParteDaSociedade()){
            penultimaPosicao = 1;
            antiPenultimaPosicao = 2;
            ataque3 = -3;
            ataque2 = -2;
            ataque1 = -1;
        }

        int posicaoInicial = this.getMapa().buscarPosicao(this);

        if(posicaoInicial == penultimaPosicao){
            Personagem p1 = this.getMapa().buscarCasa(posicaoInicial + ataque1);

            if(p1 != null && ((this.fazParteDaSociedade() && !p1.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) && p1.fazParteDaSociedade())){
                p1.setConstituicao(p1.getConstituicao() - (this.agilidade));
            }

        } else if (posicaoInicial == antiPenultimaPosicao) {
            Personagem p1 = this.getMapa().buscarCasa(posicaoInicial + ataque2);
            Personagem p2 = this.getMapa().buscarCasa(posicaoInicial + ataque1);

            if(p1 != null && ((this.fazParteDaSociedade() && !p1.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) && p1.fazParteDaSociedade())){
                p1.setConstituicao(p1.getConstituicao() - (this.agilidade*2));
            }
           else if(p2 != null && ((this.fazParteDaSociedade() && !p2.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) && p2.fazParteDaSociedade())){
                p2.setConstituicao(p2.getConstituicao() - (this.agilidade));
            }
        }
        else {
            Personagem p1 = this.getMapa().buscarCasa(posicaoInicial + ataque3);
            Personagem p2 = this.getMapa().buscarCasa(posicaoInicial + ataque2);
            Personagem p3 = this.getMapa().buscarCasa(posicaoInicial + ataque1);

            if(p1 != null && ((this.fazParteDaSociedade() && !p1.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) &&
                            p1.fazParteDaSociedade())){
                p1.setConstituicao(p1.getConstituicao() - (this.agilidade*3));
            }
            else if(p2 != null && ((this.fazParteDaSociedade() && !p2.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) && p2.fazParteDaSociedade())){
                p2.setConstituicao(p2.getConstituicao() - (this.agilidade*2));
            }
            else if(p3 != null && ((this.fazParteDaSociedade() && !p3.fazParteDaSociedade()) || (!this.fazParteDaSociedade()) && p3.fazParteDaSociedade())){
                p3.setConstituicao(p3.getConstituicao() - (this.agilidade));
            }
        }
    }

    @Override
    public void avancar() throws PersonagemNaoEncontradoNoMapaException {

        int penultimaPosicao = 8;
        int avanco2 = 2;
        int avanco1 = 1;

        if(!this.fazParteDaSociedade()){
            penultimaPosicao = 1;
            avanco2 = -2;
            avanco1 = -1;
        }

        int posicaoInicial = this.getMapa().buscarPosicao(this);

        if(posicaoInicial == penultimaPosicao){
            Personagem p1 = this.getMapa().getPersonagens()[posicaoInicial + avanco1];
            if(p1 == null){
                this.getMapa().getPersonagens()[posicaoInicial] = null;
                this.getMapa().getPersonagens()[posicaoInicial + avanco1] = this;
            }
        }
        else {
            Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + avanco2);
            Personagem p2 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + avanco1);
            if(p1 == null && p2 == null){
                this.getMapa().getPersonagens()[posicaoInicial] = null;
                this.getMapa().getPersonagens()[posicaoInicial + avanco2] = this;
            }
            else if(p2 == null){
                this.getMapa().getPersonagens()[posicaoInicial] = null;
                this.getMapa().getPersonagens()[posicaoInicial + avanco1] = this;
            }
        }
    }
}
