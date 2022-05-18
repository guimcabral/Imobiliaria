package login;

public class FalhaAutenticacaoException extends Exception{
    public FalhaAutenticacaoException(String mensagem){
        super(mensagem);
    }
}
