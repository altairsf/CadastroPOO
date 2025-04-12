package model;
/**
 * @author Altair
 */
public class PessoaFisica extends Pessoa {
    private String CPF;
    private int idade;
    
    public PessoaFisica(int id, String nome, String CPF, int idade) {
        super(id, nome);
        this.CPF = CPF;
        this.idade = idade;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + CPF);
        System.out.println("Idade: " + idade);
    }
    
    public String getCpf() {
        return CPF;
    }

    public void setCpf(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
