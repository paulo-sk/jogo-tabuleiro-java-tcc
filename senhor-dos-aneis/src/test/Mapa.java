package test;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.personagem_base.Personagem;

public class Mapa {
    private Personagem[] personagens = new Personagem[10];

    public void inserir(int posicao, Personagem personagem)  throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        //verifica se a posicao esta vazia
        try{
            if(personagens[posicao] != null)
                throw new PosicaoOcupadaException();
            personagens[posicao] = personagem;
            return;
        }
        catch (PosicaoOcupadaException e){
            e.printStackTrace();
        }

        //verifica se se personagem ja existe no mapa
        try{
            for(Personagem p: this.personagens){
                if(p.toString().equals(personagem.toString()))
                    System.out.println(p+": = "+personagem);
                    throw new PersonagemJaEstaNoMapaException();
            }
        }
        catch (PersonagemJaEstaNoMapaException e){
            e.printStackTrace();
        }

    }

    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException{
        try{
            for (int i = 0; i < personagens.length; i++) {
                if (personagens[i] != null) {
                    if (personagens[i].equals(personagem))
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
