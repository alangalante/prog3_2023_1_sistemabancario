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

    public static void main(String[] args) {
        Cliente c = new Cliente("37713421203", "Joao", "123");
    }
    
}
