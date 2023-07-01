package orm.actions;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class ConsultarAluno {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Buscar po ID: ");
        Long id = sc.nextLong();

        try {
            Aluno aluno = manager.find(Aluno.class, id);

            if (aluno != null) {
                System.out.println("\nID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                System.out.println("Naturalidade: " + aluno.getNaturalidade());
                System.out.println("Endereço: " + aluno.getEndereco());
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } finally {
            scanner.close();
            manager.close();
            factory.close();
        }
    }
}
