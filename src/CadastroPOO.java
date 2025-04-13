import java.io.IOException;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 * @author Altair
 */

public class CadastroPOO {
    //O código abaixo é para o primeiro procedimento. Para usá-lo, descomentar.
    /*public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Pessoa Física
        //repo1
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        PessoaFisica PF1 = new PessoaFisica(1, "Ana", "111.111.111-11", 25);
        PessoaFisica PF2 = new PessoaFisica(2, "Carlos", "222.222.222-22", 52);
        repo1.inserir(PF1);
        repo1.inserir(PF2);
    
        repo1.persistir("D_PessoasFisicas.txt");
        System.out.println("Dados de Pessoa Física Armazenados");
        
        //repo2
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("D_PessoasFisicas.txt");
        System.out.println("Dados de Pessoa Física Recuperados");
        for (PessoaFisica PF: repo2.obterTodos()) {
            PF.exibir();
            System.out.println("*******");
        }
        
        // Pessoa Jurídica
        //repo3
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        PessoaJuridica PJ1 = new PessoaJuridica(3, "XPTO Sales", "33.333.333/333-33");
        PessoaJuridica PJ2 = new PessoaJuridica(4, "XPTO Solutions", "44.444.444/444-44");
        repo3.inserir(PJ1);
        repo3.inserir(PJ2);
        
        repo3.persistir("D_PessoasJuridicas.txt");
        System.out.println("Dados de Pessoa Jurídica Armazenados");
        
        //repo4
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("D_PessoasJuridicas.txt");
        System.out.println("Dados de Pessoa Jurídica Recuperados");
        for (PessoaJuridica pj: repo4.obterTodos()) {
            pj.exibir();
            System.out.println("*******");
        }
    }  
}
*/
// Fim do primeiro procedimento.Para usá-, descomentar o bloco anterior e comentar
// a partir da próxima linha
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        int opcao;
    
        do {
            System.out.println("===============================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Persistir dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===============================");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Entrada inválida! Digite um número.");
                opcao = -1;
            }
        
            switch(opcao) {
                case 1 -> {
                    System.out.print("F - Física | J - Jurídica\n");
                    String tipo = scanner.nextLine().toUpperCase();
                    if (tipo.equals("F")) {
                        System.out.print("Digite o ID da pessoa: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Insira os dados...\n");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(scanner.nextLine());

                        repoPF.inserir(new PessoaFisica(id, nome, cpf, idade));
                        System.out.println("Pessoa Física adicionada.");
                    }
                    else if (tipo.equals("J")) {
                        System.out.print("Digite o ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Insira os dados...\n");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));
                        System.out.println("Pessoa Jurídica adicionada."); 
                    }                  
                }
            
                case 2 -> {
                    System.out.print("F - Física | J - Jurídica\n");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Digite o ID da pessoa: ");
                    int id = Integer.parseInt(scanner.nextLine());
            
                    if (tipo.equals("F")) {
                        PessoaFisica pf = repoPF.obter(id);
                        if (pf != null) {
                            System.out.println("Dados atuais:");
                            pf.exibir();
            
                            System.out.print("Altere os dados...\n");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("idade: ");
                            int idade = Integer.parseInt(scanner.nextLine());

                            repoPF.alterar(new PessoaFisica(id, nome, cpf, idade));
                            System.out.println("Pessoa Física alterada.");
                        }   
                       else {
                        System.out.println("Pessoa Física não encontrada.");
                        }
                    }           
                    else if(tipo.equals("J")) {
                        PessoaJuridica pj = repoPJ.obter(id);
                        if (pj != null) {
                        System.out.println("Dados atuais:");
                        pj.exibir();
                            
                            System.out.print("Altere os dados...\n");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = scanner.nextLine();

                            repoPJ.alterar(new PessoaJuridica(id, nome, cnpj));
                            System.out.println("Pessoa Jurídica alterada.");
                        } 
                        else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    }
                }
            
                case 3 -> {
                    System.out.print("F - Física | J - Jurídica\n");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Digite o ID da pessoa: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (tipo.equals("F")) {
                        repoPF.excluir(id);
                        System.out.println("Pessoa Física excluída.");
                    } 
                    else if (tipo.equals("J")) {
                        repoPJ.excluir(id);
                        System.out.println("Pessoa Jurídica excluída.");
                    }
                }
                
                case 4 -> {
                    System.out.print("F - Física | J - Jurídica\n");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Digite o ID da pessoa: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (tipo.equals("F")) {
                        PessoaFisica pf = repoPF.obter(id);
                        if (pf != null) {
                            pf.exibir();
                        } 
                        else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } 
                    else if (tipo.equals("J")) {
                        PessoaJuridica pj = repoPJ.obter(id);
                        if (pj != null) {
                            pj.exibir();
                        } 
                        else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    }
                }
                
                case 5 -> {
                    System.out.print("F - Física | J - Jurídica\n");
                    String tipo = scanner.nextLine().toUpperCase();

                    if (tipo.equals("F")) {
                        if (repoPF.obterTodos().isEmpty()) {
                            System.out.println("Nenhuma Pessoa Física Cadastrada");
                        }
                        else {
                            for (PessoaFisica pf : repoPF.obterTodos()) {
                            pf.exibir();
                            System.out.println("-------------------------");
                            }
                        }
                    } 
                    else if (tipo.equals("J")) {
                        if (repoPJ.obterTodos().isEmpty()) {
                            System.out.println("Nenhuma Pessoa Jurídica Cadastrada");
                        }
                        else {
                            for (PessoaJuridica pj : repoPJ.obterTodos()) {
                            pj.exibir();
                            System.out.println("-------------------------");
                            }
                        } 
                    }
                }
                
                case 6 -> {
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoPF.persistir(prefixo + ".fisica.bin");
                        repoPJ.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                }
                
                case 7 -> {
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoPF.recuperar(prefixo + ".fisica.bin");
                        repoPJ.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    }
                }
                
                case 0 -> {
                    System.out.println("Finalizando o programa...");
                }
                
                default -> System.out.println("Opção inválida!");
            }
        }
    while (opcao != 0);
    scanner.close();
    }
}
