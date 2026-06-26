import java.util.ArrayList;

public class Compra {

    private String nomeLista;
    private ArrayList<String> itensComprados;
    private double total;

    public Compra(String nomeLista) {
        this.nomeLista = nomeLista;
        this.itensComprados = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarItem(String descricao,
                              double qtd,
                              String unidade,
                              double preco) {

        itensComprados.add(
                descricao + " | " +
                qtd + " " + unidade +
                " | R$ " + preco);

        total += preco;
    }

    public void exibirRelatorio() {

        System.out.println("\n--- Relatório " + nomeLista + " ---");

        for (String item : itensComprados) {
            System.out.println(item);
        }

        System.out.printf("\nTOTAL: R$ %.2f%n", total);
    }

    public double getTotal() {
        return total;
    }
}