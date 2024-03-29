package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.femass.diversos.Validador;

public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String endereco;
    private List<String> telefones = new ArrayList<String>();
    private String email;
    private Boolean ativo;

    private static Long ultimoCodigo = 0L;

    public Cliente() {

    }
    
    public Cliente(
        String cpf,
        String nome,
        String telefone
    ) {
        if (Validador.validarCPF(cpf)==false) throw new IllegalArgumentException("CPF Inválido");
        this.cpf = cpf;
        this.nome = nome;
        this.telefones.add(telefone);
        this.ativo = true;
        
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
    
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    public static void atualizarUltimoId(Set<Cliente> clientes) {
        for (Cliente cliente: clientes) {
            if (cliente.getId().longValue()>ultimoCodigo) {
                ultimoCodigo = cliente.getId();
            }
        }
    }


    
}
