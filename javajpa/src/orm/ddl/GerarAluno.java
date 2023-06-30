package orm.ddl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GerarAluno {

    public static void main(String[] args) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("alunos");
        
        System.out.println("Tabela criada com sucesso!");

        factory.close();
    }
}
