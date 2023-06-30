package orm.actions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class InserirAluno {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o e-mail do aluno: ");
        String email = scanner.nextLine();

        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a data de nascimento do aluno (formato: dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite a naturalidade do aluno: ");
        String naturalidade = scanner.nextLine();

        System.out.print("Digite o endereço do aluno: ");
        String endereco = scanner.nextLine();

        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        System.out.println("Aluno cadastrado com sucesso!");

        manager.close();
        factory.close();
        scanner.close();
    }
}
