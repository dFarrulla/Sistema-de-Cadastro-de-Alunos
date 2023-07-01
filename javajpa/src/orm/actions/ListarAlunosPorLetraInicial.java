package orm.actions;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class ListarAlunosPorLetraInicial {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Consultar alunos começando pela letra: ");
        String letraInicial = scanner.nextLine();

        // Consulta para listar os alunos filtrados pela letra inicial do nome
        List<Aluno> alunos = manager.createQuery("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE :letraInicial", Aluno.class)
            .setParameter("letraInicial", letraInicial.toLowerCase() + "%")
            .getResultList();

        // Exibir os dados dos alunos
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
            System.out.println("Naturalidade: " + aluno.getNaturalidade());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("----------------------");
        }

        scanner.close();
        manager.close();
        factory.close();
    }
}
