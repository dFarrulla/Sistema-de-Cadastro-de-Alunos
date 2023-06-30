package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class AlterarAluno {

    public static void main(String[] args) {
    	
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        // Identificador do aluno que será alterado
        long alunoId = 1; // Substitua 1 pelo ID do aluno que deseja alterar

        // Consulta o aluno pelo ID
        Aluno aluno = manager.find(Aluno.class, alunoId);

        if (aluno != null) {
            // Altera os dados do aluno
            aluno.setNome("Novo Nome");
            aluno.setEmail("novoemail@example.com");
            aluno.setCpf("111.222.333-44");
            // Atualize os demais atributos conforme necessário

            // Iniciar uma transação
            manager.getTransaction().begin();

            // Atualiza o aluno no banco de dados
            manager.merge(aluno);

            // Commit da transação
            manager.getTransaction().commit();

            System.out.println("Aluno alterado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }

        manager.close();
        factory.close();
    }
}
