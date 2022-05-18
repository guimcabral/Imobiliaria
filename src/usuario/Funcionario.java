package usuario;

import login.Autenticavel;
import login.FalhaAutenticacaoException;

public class Funcionario implements Autenticavel {

    private int senha;
    private int codigo;
    private boolean autenticado;

    public Funcionario(int codigo){
        this.codigo = codigo;
        this.autenticado = false;
        this.senha = Autenticavel.senhaPadrao;
    }

    public boolean isAutenticado(){
        return autenticado;
    }

    @Override
    public void autentica(int senha) throws FalhaAutenticacaoException {
        try{
            if(this.senha != senha)
                throw new FalhaAutenticacaoException("Senha incorreta.");
            autenticado = true;
        }catch (FalhaAutenticacaoException e){
            System.out.println(e.getMessage());
        }
    }
}
