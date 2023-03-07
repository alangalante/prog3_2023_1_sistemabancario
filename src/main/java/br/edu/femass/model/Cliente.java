package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.femass.diversos.Validador;

public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String endereco;
    private List<String> telefones = new ArrayList<String>();
    private String email;

    private static Long ultimoCodigo = 0L;

    public Cliente(
        String cpf,
        String nome,
        String telefone
    ) {
        if (Validador.validarCPF(cpf)==false) throw new IllegalArgumentException("CPF Inválido");
        this.cpf = cpf;
        this.nome = nome;
        this.telefones.add(telefone);
        
        this.id = ultimoCodigo+1;
        ultimoCodigo++;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    public void removerTelefone(String telefone) throws Exception {
        if (telefones.size()==1) {
            throw new Exception("O cliente tem que ter pelo menos um telefone");
        }
        this.telefones.remove(telefone);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    
}
