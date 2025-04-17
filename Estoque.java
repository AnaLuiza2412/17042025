import java.util.Scanner;

public class Estoque {
    private Produto[] produtos;
    private int quantidade;

    public Estoque() {
        produtos = new Produto[10]; // vetor com 10 posições
        quantidade = 0;
    }

    public void inserirProduto(String nome, double preco) {
        if (quantidade < 10) {
            produtos[quantidade] = new Produto(nome, preco);
            quantidade++;
        } else {
            System.out.println("Estoque cheio! Não é possível adicionar mais produtos.");
        }
    }

    public void listarProdutos() {
        if (quantidade == 0) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Lista de Produtos ---");
            for (int i = 0; i < quantidade; i++) {
                System.out.println(produtos[i]);
            }
        }
    }

    public void mostrarMediaPrecos() {
        if (quantidade == 0) {
            System.out.println("Nenhum produto para calcular a média.");
            return;
        }

        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += produtos[i].getPreco();
        }

        double media = soma / quantidade;
        System.out.printf("\nMédia de preços: R$ %.2f\n", media);
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Produtos ===");

        while (true) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Preço do produto: ");
            double preco = Double.parseDouble(scanner.nextLine());

            estoque.inserirProduto(nome, preco);

            if (estoque.quantidade >= 10) {
                System.out.println("Estoque cheio!");
                break;
            }

            System.out.print("Deseja adicionar outro produto? (s/n): ");
            String opcao = scanner.nextLine();
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }

        estoque.listarProdutos();
        estoque.mostrarMediaPrecos();

        scanner.close();
    }
}
