package test;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.personagem_base.Personagem;

public class Mapa {
    private final Personagem[] personagens = new Personagem[10];

    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if(personagens[posicao] != null){
            throw new PosicaoOcupadaException();
        }
        for(Personagem p: this.personagens) {
            if (p != null && p.toString().equals(personagem.toString())){
                throw new PersonagemJaEstaNoMapaException();
            }
        }
        personagens[posicao] = personagem;
    }
    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException{
        for (int i = 0; i < personagens.length; i++) {
            if (personagens[i] != null) {
                if(personagens[i].equals(personagem))
                    return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException();
    }
    public Personagem buscarCasa(int posicao){
        return personagens[posicao];
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

    public String exibir(){
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for(int i = 0; i < this.personagens.length; i++){
            if(this.personagens[i] == null){
                sb.append(" |");
                continue;
            }
            sb.append(personagens[i]+"|");
        }
       String mapaFormatado = sb.toString();
        return mapaFormatado;
    }
}
