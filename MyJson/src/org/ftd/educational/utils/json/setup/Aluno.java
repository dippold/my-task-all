package org.ftd.educational.utils.json.setup;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.1 - 2018-06-20
 * 
 */
public class Aluno {
    
    private String cpf;
    private String nome;

    public Aluno(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }
    
    public String getCpf() {
        return cpf;
    }

    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
