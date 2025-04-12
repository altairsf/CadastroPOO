package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Altair
 */
public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> lista = new ArrayList<>();
    
    public void inserir(PessoaFisica pessoa) {
        lista.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa) {
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
    
    public PessoaFisica obter(int id) {
        return lista.stream()
            .filter(p -> p.getID() == id)
            .findFirst()
            .orElse(null);
    }
    
    public List<PessoaFisica> obterTodos() {
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
            lista = (ArrayList<PessoaFisica>) in.readObject();
        }
    }
} 
