package test;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.personagem_base.Personagem;

import java.util.Arrays;

public class Mapa {
    private Personagem[] personagens = new Personagem[10];

    public void inserir(int posicao, Personagem personagem)  {
        try{
            if(personagens[posicao] != null)
                throw new PosicaoOcupadaException();
            personagens[posicao] = personagem;
        }
        catch (PosicaoOcupadaException e){
            e.printStackTrace();
        }

    }

    public int buscarPosicao(Personagem personagem){
        try{
            for (int i = 0; i < personagens.length; i++) {
                if (personagens[i] != null) {
                    if (personagens[i] == personagem)
                        return i;
                }
            }
            throw new PersonagemNaoEncontradoNoMapaException();
        }
        catch (PersonagemNaoEncontradoNoMapaException e){
            e.printStackTrace();
            return -1;
        }
    }

    public Personagem buscarCasa(int posicao){
        return personagens[posicao];
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

    public String exibir(){
        return Arrays.toString(this.personagens);
    }
}
