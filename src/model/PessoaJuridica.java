package model;
/**
 * @author Altair
 */
public class PessoaJuridica extends Pessoa {
    private String CNPJ;

    public PessoaJuridica(int id, String nome, String CNPJ) {
        super(id, nome);
        this.CNPJ = CNPJ;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + CNPJ);
    }

    public String getCnpj() {
        return CNPJ;
    }

    public void setCnpj(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
