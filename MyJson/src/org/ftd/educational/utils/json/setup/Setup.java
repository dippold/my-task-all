package org.ftd.educational.utils.json.setup;

import org.ftd.educational.utils.json.interfaces.IJsonService;
import org.ftd.educational.utils.json.services.JsonService;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public class Setup {
    
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno("Fabio Dippold", "684.416.909-44");
        Aluno aluno2 = new Aluno("Liane Dippold", "416.909.684-45");
        
        Disciplina d = new Disciplina("poo", "Prog. Orientada a Objetos");        
        d.addAluno(aluno1);
        d.addAluno(aluno2);
        
        IJsonService service = JsonService.getInstance();
        
        System.out.println(service.getJsonObject(d));
        
        
    }
    
}
