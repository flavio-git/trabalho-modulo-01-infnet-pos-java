package test;

import menu.ClienteMenu;
import model.Cliente;

import java.util.ArrayList;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Ricardo Silva", "000.000.000-00", "ricardo@email.com");
        Cliente c2 = new Cliente("Gabriela Morais", "111.000.000-00", "morais.gabriela@email.com");
        Cliente c3 = new Cliente("Helena Castro", "222.000.000-00", "h.castro@email.com");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        ClienteMenu.cadastrarCliente(clientes);

        clientes.forEach(System.out::println);
    }
}
