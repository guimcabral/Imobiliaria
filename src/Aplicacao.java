// Importacao de pacotes

import login.*;
import imovel.*;
import usuario.*;
import imobiliaria.*;

import java.util.Scanner;

public class Aplicacao{

    public static void main(String[] args) throws FalhaAutenticacaoException{

        Funcionario funcionario = new Funcionario(123); // Instanciacao de Funcionario com codigo 123
        Imobiliaria imobiliaria = new Imobiliaria(); // Instanciacao de Imobiliaria

        Scanner scanner = new Scanner(System.in); // Scanner para leitura de dados

        int opcao = 1; // Opção do menu

        int auxInt1, auxInt2 = 0, auxInt3; // Inteiros auxiliares
        boolean auxBool1 = false, auxBool2; // Booleanos auxiliares
        float auxFloat; // Real auxiliar
        String auxString1, auxString2; // Strings auxiliares

        Imovel auxImovel; // Imovel auxiliar
        Cliente auxCliente; // Cliente auxiliar

        System.out.println("Aplicação Imobiliaria POO 2021/2");

        do{ // Solicita a senha 12345 para que o Funcionário possa "logar" no sistema. O login falha em 3 tentativas.
            System.out.print("Digite a senha do Funcionário >> ");
            auxInt1 = scanner.nextInt();
            try{
                funcionario.autentica(auxInt1);
                auxBool1 = funcionario.isAutenticado();
            }catch(Exception e){
                auxInt2++;
            }
        }while(!auxBool1 && auxInt2 < 3);


        if (auxInt2 != 3){

            while(opcao != 0){ // Itera sobre as opções do usuário até que ele resolva sair

                System.out.println("------ MENU ------");
                System.out.println("1: Cadastro de Cliente");
                System.out.println("2: Cadastro de Imóvel");
                System.out.println("3: Listar Imóveis");
                System.out.println("4: Colocar/Retirar Imóvel para/da Lista de Vendas");
                System.out.println("5: Colocar Imóvel para/da Lista de Locações");
                System.out.println("6: Locar/Devolver Imóvel Imóvel");
                System.out.println("7: Vender Imóvel");
                System.out.println("0: Sair");
                System.out.print("Digite uma opção >> ");

                opcao = scanner.nextInt();

                switch(opcao){
                    case 1:
                        System.out.println("--- Cadastro de Cliente ---");
                        System.out.print("Digite o nome do Cliente >> ");
                        auxString1 = scanner.next();
                        System.out.print("Digite o CPF do Cliente >> ");
                        auxString2 = scanner.next();
                        if (imobiliaria.registraCliente(funcionario, auxString1, auxString2))
                            System.out.println("Cliente cadastrado!");
                        else
                            System.out.println("Erro ao cadastrar Cliente!");
                        break;
                    case 2:
                        System.out.println("--- Cadastro de Imóvel ---");
                        System.out.println("1: Apartamento ");
                        System.out.println("2: Casa ");
                        System.out.print("Digite uma opção >> ");
                        opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                System.out.print("Digite o endereço da Casa >> ");
                                auxString1 = scanner.next();
                                System.out.print("Digite a metragem da Casa >> ");
                                auxFloat = scanner.nextFloat();
                                System.out.print("Digite o número de quartos da Casa >> ");
                                auxInt1 = scanner.nextInt();
                                System.out.print("Digite o número de banheiros da Casa >> ");
                                auxInt2 = scanner.nextInt();
                                System.out.print("A Casa tem pátio? >> ");
                                auxBool1 = scanner.nextBoolean(); // Espera "true" ou "false"
                                System.out.print("A Casa tem box? >> ");
                                auxBool2 = scanner.nextBoolean(); // Espera "true" ou "false"
                                auxImovel = new Casa(auxString1, auxFloat, auxInt1, auxInt2, auxBool1, auxBool2);
                                if (imobiliaria.registraImovel(funcionario, auxImovel))
                                    System.out.println("Casa cadastrada!");
                                else
                                    System.out.println("Erro ao cadastrar Casa!");
                                break;
                            case 2:
                                System.out.print("Digite o endereco do Apartamento >> ");
                                auxString1 = scanner.next();
                                System.out.print("Digite a metragem do Apartamento >> ");
                                auxFloat = scanner.nextFloat();
                                System.out.print("Digite o número de quartos do Apartamento >> ");
                                auxInt1 = scanner.nextInt();
                                System.out.print("Digite o número de banheiros do Apartamento >> ");
                                auxInt2 = scanner.nextInt();
                                System.out.print("Digite o andar do Apartamento >> ");
                                auxInt3 = scanner.nextInt();
                                System.out.print("O Apartamento tem garagem? >> ");
                                auxBool1 = scanner.nextBoolean(); // Espera "true" ou "false"
                                auxImovel = new Apartamento(auxString1, auxFloat, auxInt1, auxInt2, auxInt3, auxBool1);
                                if (imobiliaria.registraImovel(funcionario, auxImovel))
                                    System.out.println("Apartamento cadastrado!");
                                else
                                    System.out.println("Erro ao cadastrar Apartamento!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    case 3:
                        System.out.println("--- Listar Imóveis ---");
                        System.out.println("1: Imóveis para Aluguel");
                        System.out.println("2: Imóveis para Venda");
                        System.out.println("3: Todos Imóveis");
                        System.out.print("Digite uma opção >> ");
                        opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                imobiliaria.listaImoveisDisponiveisLocacao();
                                break;
                            case 2:
                                imobiliaria.listaImoveisDisponiveisVenda();
                                break;
                            case 3:
                                imobiliaria.listaImoveis();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    case 4:
                        System.out.println("--- Colocar/Retirar Imóvel na/da lista de Vendas ---");
                        System.out.println("1: Colocar Imóvel na lista de Vendas");
                        System.out.println("2: Remover Imóvel da lista de Vendas");
                        System.out.print("Digite uma opção >> ");
                        opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                if (imobiliaria.colocaImovelParaListaVendas(funcionario, auxInt1))
                                    System.out.println("Imóvel cadastrado na lista de Vendas!");
                                else
                                    System.out.println("Erro ao cadastrar Imóvel na lista de Vendas!");
                                break;
                            case 2:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                if(imobiliaria.removeImovelDaListaVendas(funcionario, auxInt1))
                                    System.out.println("Imóvel removido da lista de Vendas!");
                                else
                                    System.out.println("Erro ao remover Imóvel da lista de Vendas!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    case 5:
                        System.out.println("--- Colocar/Retirar Imóvel na/da lista de Locações ---");
                        System.out.println("1: Colocar Imóvel na lista de Locações ");
                        System.out.println("2: Remover Imóvel da lista de Locações ");
                        System.out.print("Digite uma opção >> ");
                        opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                if (imobiliaria.colocaImovelParaListaLocacoes(funcionario, auxInt1))
                                    System.out.println("Imóvel cadastrado na lista de Locações!");
                                else
                                    System.out.println("Erro ao cadastrar Imóvel na lista de Locações!");
                                break;
                            case 2:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                if(imobiliaria.removeImovelDaListaLocacoes(funcionario, auxInt1))
                                    System.out.println("Imóvel removido da lista de Locações!");
                                else
                                    System.out.println("Erro ao remover Imóvel da lista de Locações!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    case 6:
                        System.out.println("--- Locar/Devolver Imóvel ---");
                        System.out.println("1: Locar Imóvel ");
                        System.out.println("2: Devolver Imóvel ");
                        System.out.print("Digite uma opção >> ");
                        opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                System.out.print("Digite o CPF do Cliente >> ");
                                auxString1 = scanner.next();
                                if (imobiliaria.locaImovel(funcionario, auxInt1, auxString1))
                                    System.out.println("Imóvel locado!");
                                else
                                    System.out.println("Erro ao locar Imóvel!");
                                break;
                            case 2:
                                System.out.print("Digite o código do Imóvel >> ");
                                auxInt1 = scanner.nextInt();
                                System.out.print("Digite o CPF do Cliente >> ");
                                auxString1 = scanner.next();
                                if(imobiliaria.devolveImovel(funcionario, auxInt1, auxString1))
                                    System.out.println("Imóvel devolvido!");
                                else
                                    System.out.println("Erro ao devolver Imóvel!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    case 7:
                        System.out.println("--- Vender Imóvel ---");
                        System.out.print("Digite o código do Imóvel >> ");
                        auxInt1 = scanner.nextInt();
                        System.out.print("Digite o CPF do Cliente >> ");
                        auxString1 = scanner.next();
                        if (imobiliaria.vendeImovel(funcionario, auxInt1, auxString1))
                            System.out.println("Imóvel vendido!");
                        else
                            System.out.println("Erro ao vender Imóvel!");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
        else
            System.out.println("Funcionário não autenticado!");
        scanner.close();
    }
}