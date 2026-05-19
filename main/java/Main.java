import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Funcionarios> lista = new ArrayList<>();
    static FuncionarioDAO dao = new FuncionarioDAO();

    //MENU PRINCIPAL
    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Desenvolvedor");
            System.out.println("3 - Cadastrar Estagiário");
            System.out.println("4 - Listar Funcionários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1 -> cadastrarGerente();
                case 2 -> cadastrarDesenvolvedor();
                case 3 -> cadastrarEstagiario();
                case 4 -> listarFuncionarios();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    //CADASTRAR CADA TIPO DE FUNCIONÁRIO
    private static void cadastrarGerente() {
        System.out.println("\n--- Cadastro de Gerente ---");

        String nome = lerString("Nome: ");
        String cpf  = lerString("CPF: ");
        double salarioBase    = lerDouble("Salário base: ");
        double bonusPercentual = lerDouble("Bônus percentual (%): ");

        Gerente g = new Gerente(nome, cpf, salarioBase, bonusPercentual);
        lista.add(g);
        dao.salvar(g);   // salva no banco de dados

        System.out.println("✔ Gerente cadastrado com sucesso!");
        System.out.printf("  Salário calculado: R$ %.2f%n", g.calcularSalario());
    }

    private static void cadastrarDesenvolvedor() {
        System.out.println("\n--- Cadastro de Desenvolvedor ---");

        String nome       = lerString("Nome: ");
        String cpf        = lerString("CPF: ");
        double salarioBase = lerDouble("Salário base: ");

        String senioridade;
        while (true) {
            senioridade = lerString("Nível de senioridade (junior / pleno / senior): ").toLowerCase();
            if (senioridade.equals("junior") ||
                    senioridade.equals("pleno")  ||
                    senioridade.equals("senior")) {
                break;
            }
            System.out.println("  Nível inválido! Digite junior, pleno ou senior.");
        }

        Desenvolvedor d = new Desenvolvedor(nome, cpf, salarioBase, senioridade);
        lista.add(d);
        dao.salvar(d);   // salva no banco de dados

        System.out.println("✔ Desenvolvedor cadastrado com sucesso!");
        System.out.printf("  Salário calculado: R$ %.2f%n", d.calcularSalario());
    }

    private static void cadastrarEstagiario() {
        System.out.println("\n--- Cadastro de Estagiário ---");

        String nome        = lerString("Nome: ");
        String cpf         = lerString("CPF: ");
        double salarioBase = lerDouble("Salário base: ");
        int cargaHoraria   = lerIntPositivo("Carga horária (horas/semana): ");

        Estagiario e = new Estagiario(nome, cpf, salarioBase, cargaHoraria);
        lista.add(e);
        dao.salvar(e);   // salva no banco de dados

        System.out.println("✔ Estagiário cadastrado com sucesso!");
        System.out.printf("  Salário calculado: R$ %.2f%n", e.calcularSalario());
    }
    
    //LISTAR TODOS OS FUNCIONÁRIOS CADASTRADOS
    private static void listarFuncionarios() {
        if (lista.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado ainda.");
            return;
        }

        System.out.println("\n========== LISTA DE FUNCIONÁRIOS ==========");
        for (int i = 0; i < lista.size(); i++) {
            Funcionarios f = lista.get(i);
            System.out.println("\n[" + (i + 1) + "] " + f.getClass().getSimpleName());
            System.out.println("    Nome : " + f.getNome());
            System.out.println("    CPF  : " + f.getCpf());
            System.out.printf( "    Salário: R$ %.2f%n", f.calcularSalario());

            if (f instanceof Gerente g) {
                System.out.printf("    Bônus : %.1f%%%n", g.getBonusPercentual());
            } else if (f instanceof Desenvolvedor d) {
                System.out.println("    Nível : " + d.getNivelSenioridade());
            } else if (f instanceof Estagiario e) {
                System.out.println("    Carga : " + e.getCargaHoraria() + "h/semana");
            }
        }
        System.out.println("============================================");
    }

    //FUNÇÕES CRIADAS PARA REALIZAREM VEFICAÇÃO
    //PARA STRING
    private static String lerString(String prompt) {
        String valor;
        do {
            System.out.print(prompt);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("  Campo obrigatório!");
            }
        } while (valor.isEmpty());
        return valor;
    }

    //PARA DOUBLE
    private static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().replace(",", ".");
            try {
                double valor = Double.parseDouble(entrada);
                if (valor < 0) {
                    System.out.println("  O valor não pode ser negativo!");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido! Digite um número (ex.: 3500.00).");
            }
        }
    }

    //PARA INT
    private static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("  Opção inválida! Digite um número inteiro: ");
            }
        }
    }

    //PARA INT E POSITIVO
    private static int lerIntPositivo(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor <= 0) {
                    System.out.println("  O valor deve ser maior que zero!");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido! Digite um número inteiro positivo.");
            }
        }
    }
}
