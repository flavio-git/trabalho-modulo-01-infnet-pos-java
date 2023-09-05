package model;

import java.util.List;

public class Pedido {
    private boolean isWeb;
    private List<Produto> produtos;
    private Cliente cliente;
    private double totalPedido;

    public Pedido(boolean isWeb, List<Produto> produtos, Cliente cliente) {
        this.isWeb = isWeb;
        this.produtos = produtos;
        this.cliente = cliente;
        this.totalPedido = calculaTotalPedido();
    }

    public boolean isWeb() {
        return isWeb;
    }

    public String getCliente() {
        return cliente.getNome();
    }

    private float calculaTotalPedido() {
        float totalProdutos = 0;
        for (Produto p : produtos) {
            totalProdutos += p.getPreco();
        }
        return totalProdutos;
    }

    public String geraCodigoProdutos() {
        StringBuilder codigosPedidos = new StringBuilder();
        for (int i = 0; i < produtos.size(); i++) {
            if (i == (produtos.size() - 1)) {
                codigosPedidos.append(produtos.get(i).getCodigo());
            } else {
                codigosPedidos.append(produtos.get(i).getCodigo()).append("-");
            }
        }
        return codigosPedidos.toString();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "isWeb=" + isWeb +
                ", produtos=" + produtos +
                ", cliente=" + cliente +
                ", totalPedido=" + totalPedido +
                '}';
    }
}
