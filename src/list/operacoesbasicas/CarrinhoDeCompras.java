package list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoCompras;

    public CarrinhoDeCompras(){
        this.carrinhoCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinhoCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> removerItem = new ArrayList<>();
        for(Item i : carrinhoCompras){
            if(i.getNome().equalsIgnoreCase(nome))
                removerItem.add(i);
        }

        carrinhoCompras.removeAll(removerItem);
    }

    public double calcularValorTotal(){
        double valorTotal = 0.0;

        for(Item i : carrinhoCompras){
            valorTotal += (i.getPreco() * i.getQuantidade());
        }
        return valorTotal;
    }

    public void exibirItems(){
        System.out.println(carrinhoCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Pao", 0.75, 10);

        System.out.println(carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Pao");

        carrinhoDeCompras.adicionarItem("Pao", 0.75, 10);
        carrinhoDeCompras.adicionarItem("Leite", 5.62, 2);
        carrinhoDeCompras.adicionarItem("Po de Cafe", 4.5, 1);

        System.out.println(carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItems();
    }
}
