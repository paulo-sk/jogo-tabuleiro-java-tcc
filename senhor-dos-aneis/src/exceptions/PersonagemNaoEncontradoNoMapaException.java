package exceptions;

public class PersonagemNaoEncontradoNoMapaException extends Exception{
    public PersonagemNaoEncontradoNoMapaException(){
        super("Personagem não existe no mapa.");
    }
}
