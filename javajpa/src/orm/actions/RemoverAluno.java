package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class RemoverAluno {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        // Identificador do aluno que será removido
        long alunoId = 1; // Substitua 1 pelo ID do aluno que deseja remover

        // Consulta o aluno pelo ID
        Aluno aluno = manager.find(Aluno.class, alunoId);

        if (aluno != null) {
            // Iniciar uma transação
            manager.getTransaction().begin();

            // Remover o aluno do banco de dados
            manager.remove(aluno);

            // Commit da transação
            manager.getTransaction().commit();

            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }

        manager.close();
        factory.close();
    }
}
