package orm.actions;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

public class AlterarAluno {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
            EntityManager manager = factory.createEntityManager();

            System.out.print("Forneça o ID do aluno para alterar os dados: ");
            Long alunoId = input.nextLong();

            Aluno aluno = manager.find(Aluno.class, alunoId);

            if (aluno != null) {
                System.out.println("Dados atuais do aluno:");
                exibirDadosAluno(aluno);

                System.out.println("\nDigite os novos dados:");

                System.out.print("Nome: ");
                input.nextLine(); // Limpa o buffer
                String nome = input.nextLine();
                aluno.setNome(nome);

                System.out.print("E-mail: ");
                String email = input.nextLine();
                aluno.setEmail(email);

                System.out.print("CPF: ");
                String cpf = input.nextLine();
                aluno.setCpf(cpf);

                System.out.print("Data de Nascimento: ");
                String dataNascimento = input.nextLine();
                aluno.setDataNascimento(dataNascimento);

                System.out.print("Naturalidade: ");
                String naturalidade = input.nextLine();
                aluno.setNaturalidade(naturalidade);

                System.out.print("Endereço: ");
                String endereco = input.nextLine();
                aluno.setEndereco(endereco);

                manager.getTransaction().begin();
                manager.merge(aluno); // Atualiza o aluno no banco de dados
                manager.getTransaction().commit();
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado!");
            }

            manager.close();
            factory.close();
        }
    }

    private static void exibirDadosAluno(Aluno aluno) {
        System.out.println("ID: " + aluno.getId());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("E-mail: " + aluno.getEmail());
        System.out.println("CPF: " + aluno.getCpf());
        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
        System.out.println("Naturalidade: " + aluno.getNaturalidade());
        System.out.println("Endereço: " + aluno.getEndereco());
    }
}
