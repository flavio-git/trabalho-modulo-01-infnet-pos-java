package test;

import menu.PedidoMenu;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PedidoTest {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Ricardo Silva", "000.000.000-00", "ricardo@email.com");
        Cliente c2 = new Cliente("Gabriela Morais", "111.000.000-00", "morais.gabriela@email.com");
        Cliente c3 = new Cliente("Helena Castro", "222.000.000-00", "h.castro@email.com");

        Produto p1 = new Console("Playstation 5", 4500.00f, 1020, "Sony");
        Produto p2 = new JogosConsole("Halo Infinite", 250.00f, 2040, new Console("Series X", 4800.00f, 1040, "Xbox"));
        Produto p3 = new CPU("AMD Ryzen 7 3800XT", 1500f, 4030, 8, 16);

        ArrayList<Produto> lista1 = new ArrayList<>(Arrays.asList(p1, p2, p3));
        ArrayList<Produto> lista2 = new ArrayList<>(Arrays.asList(p1, p2));
        ArrayList<Produto> lista3 = new ArrayList<>(Arrays.asList(p1, p3));

        Pedido pedido1 = new Pedido(true, lista1, c1);
        Pedido pedido2 = new Pedido(true, lista2, c2);
        Pedido pedido3 = new Pedido(true, lista3, c3);

        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        PedidoMenu.cadastraPedido(pedidos);

        pedidos.forEach(System.out::println);
    }
}
