package model;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

/**
 * @author Altair
 */
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> lista = new ArrayList<>();
    
    public void inserir(PessoaJuridica pessoa) {
        lista.add(pessoa);
    }
    
    public void alterar(PessoaJuridica pessoa) {
        lista.stream()
            .filter(p -> p.getID() == pessoa.getID())
            .findFirst()
            .ifPresent(original -> {
                lista.set(lista.indexOf(original), pessoa);
             });
    }
    
    public void excluir(int id) {
        lista.removeIf(p -> p.getID() == id);
    }
    
    public PessoaJuridica obter(int id) {
        return lista.stream()
            .filter(p -> p.getID() == id)
            .findFirst()
            .orElse(null);
    }
    
    public List<PessoaJuridica> obterTodos() {
        return lista.stream().toList();
    }
    
    public void persistir (String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new 
        FileOutputStream(nomeArquivo))) {
            out.writeObject(lista);
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, 
        ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new 
        FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaJuridica>) in.readObject();
        }
    }
}
