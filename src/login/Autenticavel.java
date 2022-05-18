package login;

public interface Autenticavel {

    public static int senhaPadrao = 12345;

    public void autentica(int senha) throws FalhaAutenticacaoException;
}
