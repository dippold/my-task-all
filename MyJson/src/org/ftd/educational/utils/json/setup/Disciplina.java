package org.ftd.educational.utils.json.setup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.1 - 2018-06-20
 * 
 */
public class Disciplina {
    private String sigla;
    private String nome;
    private List<Aluno> alunos;

    public Disciplina(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addAluno(Aluno aluno) {
        if (getAlunos() == null) {
            setAlunos(new ArrayList<>());
        }
        this.getAlunos().add(aluno);
    }
    
    public void removeAluno(Aluno aluno) {
        if (getAlunos() != null) {
            for (int i=1; i<alunos.size();i++) {
                Aluno o = alunos.get(i);
                if ((o.getCpf().equals(aluno.getCpf())) && (o.getNome().equals(aluno.getNome()))) {
                    alunos.remove(i);
                }                
            }            
        }        
    }    
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    

    
}
