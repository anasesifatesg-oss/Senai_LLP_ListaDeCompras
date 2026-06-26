import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<ListaCompra> listas = new ArrayList<>();
    static ArrayList<Compra> comprasRealizadas = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n------------------");
            System.out.println("Gestão de Compras");
            System.out.println("------------------");
            System.out.println("1. Nova Lista");
            System.out.println("2. Fazer Compras");
            System.out.println("3. Relatório");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    novaLista();
                    break;

                case 2:
                    fazerCompra();
                    break;

                case 3:
                    relatorio();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void novaLista() {

        System.out.print("Nome da lista: ");
        String nome = sc.nextLine();

        ListaCompra lista = new ListaCompra(nome);

        while (true) {

            System.out.print("\nDescrição do item (ENTER para sair): ");
            String descricao = sc.nextLine();

            if (descricao.isEmpty()) {
                break;
            }

            System.out.print("Unidade (UN/KG/LT): ");
            String unidade = sc.nextLine();

            System.out.print("Quantidade: ");
            double qtd = sc.nextDouble();
            sc.nextLine();

            lista.adicionarItem(
                    new item(descricao, unidade, qtd));
        }

        listas.add(lista);

        System.out.println("Lista salva com sucesso!");
    }

    private static void fazerCompra() {

        if (listas.isEmpty()) {
            System.out.println("Nenhuma lista cadastrada.");
            return;
        }

        for (int i = 0; i < listas.size(); i++) {
            System.out.println(
                    (i + 1) + " - " +
                    listas.get(i).getNome());
        }

        System.out.print("Escolha a lista: ");
        int escolha = sc.nextInt() - 1;
        sc.nextLine();

        ListaCompra lista = listas.get(escolha);

        Compra compra = new Compra(lista.getNome());

        System.out.println("\n--- Fazer Compras ---");

        for (item item : lista.getItens()) {

            System.out.println("\nProduto: "
                    + item.getDescricao());

            System.out.println("Qtd Lista: "
                    + item.getQuantidade()
                    + " " + item.getUnidade());

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            System.out.print("Quantidade Comprada: ");
            double qtdComprada = sc.nextDouble();

            sc.nextLine();

            compra.adicionarItem(
                    item.getDescricao(),
                    qtdComprada,
                    item.getUnidade(),
                    preco
            );
        }

        comprasRealizadas.add(compra);

        System.out.printf(
                "\nCompra finalizada. Total: R$ %.2f%n",
                compra.getTotal());
    }

    private static void relatorio() {

        if (comprasRealizadas.isEmpty()) {
            System.out.println("Nenhuma compra realizada.");
            return;
        }

        for (Compra compra : comprasRealizadas) {
            compra.exibirRelatorio();
        }
    }
}