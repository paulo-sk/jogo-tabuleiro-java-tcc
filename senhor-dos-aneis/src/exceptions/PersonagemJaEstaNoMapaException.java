package exceptions;

import personagens.personagem_base.Personagem;

public class PersonagemJaEstaNoMapaException extends Exception{
    public PersonagemJaEstaNoMapaException(){
        super("Esse personagem ja existe no mapa");
    }
}
