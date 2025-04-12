import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 * @author Altair
 */
public class CadastroPOO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
