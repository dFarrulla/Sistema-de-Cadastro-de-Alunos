package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class RemoverAluno {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alunos");
        EntityManager em = emf.createEntityManager();

        // Identificador do aluno que será removido
        long alunoId = 1; // Substitua 1 pelo ID do aluno que deseja remover

        // Consulta o aluno pelo ID
        Aluno aluno = em.find(Aluno.class, alunoId);

        if (aluno != null) {
            // Iniciar uma transação
            em.getTransaction().begin();

            // Remover o aluno do banco de dados
            em.remove(aluno);

            // Commit da transação
            em.getTransaction().commit();

            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }

        em.close();
        emf.close();
    }
}
