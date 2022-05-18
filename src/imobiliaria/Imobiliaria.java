package imobiliaria;

import imovel.Imovel;
import usuario.Cliente;
import usuario.Funcionario;

import java.util.ArrayList;
import java.util.Objects;

public class Imobiliaria {

    final int disponivel = -1;
    final int indisponivel = -2;

    // Guarda as referências dos objetos do tipo Cliente registrados na imobiliária.
    ArrayList<Cliente> clientes;
    // Guarda as referências dos objetos do tipo Imovel registrados na imobiliária.
    ArrayList<Imovel> imoveis;
    // Guarda um valor inteiro por Imovel – indicando se ele está (i) locado, (ii) disponível para locação ou (iii)
    // indisponível para locação. No primeiro caso, o inteiro se refere ao índice em clientes associados ao Cliente que
    // fez a locação. No segundo e terceiro casos, o inteiro tem valor -1 e -2, respectivamente. Este atributo possui
    // sempre o mesmo tamanho de imóveis.
    ArrayList<Integer> locacoes;
    // Guarda um valor lógico por Imovel - indicando se ele está ou não disponível para venda. Este atributo possui
    // sempre o mesmo tamanho de imóveis.
    ArrayList<Boolean> vendas;

    public Imobiliaria(){
        // Instancia todos os atributos.
        imoveis = new ArrayList<>();
        clientes = new ArrayList<>();
        locacoes = new ArrayList<>();
        vendas = new ArrayList<>();
    }

    public boolean registraImovel(Funcionario funcionario, Imovel imovel){
        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica se há um imóvel no mesmo endereço.
        for (Imovel i: imoveis) {
            if (Objects.equals(i.getEndereco(), imovel.getEndereco())){
                System.out.println("Há um imóvel no mesmo endereço.");
                return false;
            }
        }

        // Adiciona o imóvel à lista de imóveis, à lista de locações como indisponível e à lista de vendas como
        // indisponível.
        imoveis.add(imovel);
        locacoes.add(indisponivel);
        vendas.add(false);
        return true;
    }

    public boolean registraCliente(Funcionario funcionario, String nome, String cpf){
        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica se o cliente está na lista de clientes.
        for (Cliente c: clientes) {
            if (Objects.equals(c.getCpf(), cpf)){
                System.out.println("O CPF já está cadastrado.");
                return false;
            }
        }

        // Adiciona o cliente à lista de clientes.
        clientes.add(new Cliente(cpf, nome));
        return true;
    }

    public boolean colocaImovelParaListaLocacoes(Funcionario funcionario, int codigo){
        int index = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis para locação.
        if(locacoes.get(index) == disponivel){
            System.out.println("O imóvel já está na lista de imóveis para locação.");
            return false;
        }

        // Muda o estado para disponível para locação.
        locacoes.set(index, disponivel);
        return true;
    }

    public boolean removeImovelDaListaLocacoes(Funcionario funcionario, int codigo){
        int index = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis para locação.
        if(locacoes.get(index) != disponivel){
            System.out.println("O imóvel não está na lista de imóveis para locação.");
            return false;
        }

        // Muda o estado para indisponível para locação.
        locacoes.set(index, indisponivel);
        return true;
    }

    public boolean colocaImovelParaListaVendas(Funcionario funcionario, int codigo){
        int index = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis à venda.
        if(vendas.get(index)){
            System.out.println("O imóvel já está na lista de imóveis à venda.");
            return false;
        }

        // Muda o estado para disponível para venda.
        vendas.set(index, true);
        return true;
    }

    public boolean removeImovelDaListaVendas(Funcionario funcionario, int codigo){
        int index = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis à venda.
        if(!vendas.get(index)){
            System.out.println("O imóvel não está na lista de imóveis à venda.");
            return false;
        }

        // Muda o estado para indisponível para venda.
        vendas.set(index, false);
        return true;
    }

    public void listaImoveis(){
        System.out.println("------ TODOS OS IMÓVEIS ------");
        for (int i=0; i<imoveis.size(); i++)
            System.out.print("------ IMÓVEL " + (i+1) + " ------\n" + imoveis.get(i).toString() + "\n");
    }

    public void listaImoveisDisponiveisLocacao(){
        System.out.println("------ IMÓVEIS PARA LOCAÇÃO ------");
        for (int i=0; i<imoveis.size(); i++) {
            if(locacoes.get(i) == disponivel)
                System.out.print("------ IMÓVEL " + (i+1) + " ------\n" + imoveis.get(i).toString() + "\n");
        }
    }

    public void listaImoveisDisponiveisVenda(){
        System.out.println("------ IMÓVEIS PARA VENDA ------");
        for (int i=0; i<imoveis.size(); i++) {
            if(vendas.get(i))
                System.out.print("------ IMÓVEL " + (i+1) + " ------\n" + imoveis.get(i).toString() + "\n");
        }
    }

    public boolean locaImovel(Funcionario funcionario, int codigo, String cpf){
        int index_imovel = 0;
        int index_cliente = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do cliente na lista de clientes.
        for (Cliente c: clientes) {
            if (!Objects.equals(c.getCpf(), cpf)) {
                index_cliente++;
            }
            else {
                break;
            }
        }

        // Verifica se o cliente está na lista de clientes.
        if(index_cliente >= clientes.size()){
            System.out.println("O cliente não está na lista de clientes.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index_imovel++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index_imovel >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis para locação.
        if(locacoes.get(index_imovel) != disponivel){
            System.out.println("O imóvel não está na lista de imóveis para locação.");
            return false;
        }

        locacoes.set(index_imovel, index_cliente);
        return true;
    }

    public boolean devolveImovel(Funcionario funcionario, int codigo, String cpf){
        int index_imovel = 0;
        int index_cliente = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do cliente na lista de clientes.
        for (Cliente c: clientes) {
            if (!Objects.equals(c.getCpf(), cpf)) {
                index_cliente++;
            }
            else {
                break;
            }
        }

        // Verifica se o cliente está na lista de clientes.
        if(index_cliente >= clientes.size()){
            System.out.println("O cliente não está na lista de clientes.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index_imovel++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index_imovel >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }

        // Verifica se há o imóvel na lista de imóveis para locação.
        if(locacoes.get(index_imovel) == disponivel || locacoes.get(index_imovel) == indisponivel){
            System.out.println("O imóvel não está locado.");
            return false;
        }

        // Verifica se o cliente associado ao cpf recebido loca o imóvel associado ao código recebido.
        if(locacoes.get(index_imovel) == index_cliente){
            locacoes.set(index_imovel, disponivel);
            return true;
        }
        else
            return false;
    }

    public boolean vendeImovel(Funcionario funcionario, int codigo, String cpf){
        int index_imovel = 0;
        int index_cliente = 0;

        // Verifica se o usuário está autenticado.
        if(!funcionario.isAutenticado()){
            System.out.println("O funcionário não está autenticado.");
            return false;
        }

        // Verifica qual o índice do cliente na lista de clientes.
        for (Cliente c: clientes) {
            if (!Objects.equals(c.getCpf(), cpf)) {
                index_cliente++;
            }
            else {
                break;
            }
        }

        // Verifica se o cliente está na lista de clientes.
        if(index_cliente >= clientes.size()){
            System.out.println("O cliente não está na lista de clientes.");
            return false;
        }

        // Verifica qual o índice do imóvel na lista de imóveis.
        for (Imovel i: imoveis) {
            if (i.getCodigo() != codigo)
                index_imovel++;
            else
                break;
        }

        // Verifica se há o imóvel na lista de imóveis.
        if(index_imovel >= imoveis.size()){
            System.out.println("O imóvel não está na lista de imóveis.");
            return false;
        }


        if(vendas.get(index_imovel) && (locacoes.get(index_imovel) == disponivel || locacoes.get(index_imovel) == index_cliente)){
            locacoes.remove(index_imovel);
            vendas.remove(index_imovel);
            imoveis.remove(index_imovel);
            return true;
        }
        else
            return false;
    }
}