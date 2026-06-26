import java.util.ArrayList;

public class ListaCompra {

    private String nome;
    private ArrayList<item> itens;

    public ListaCompra(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(item item) {
        itens.add(item);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<item> getItens() {
        return itens;
    }
}