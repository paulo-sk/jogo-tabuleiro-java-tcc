package exceptions;

public class PosicaoOcupadaException extends Exception{
        public PosicaoOcupadaException(){
            super("Personagem ja existe nessa posicao");
        }
}
