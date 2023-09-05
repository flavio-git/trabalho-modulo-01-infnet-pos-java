import menu.*;
import model.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Console> consoleArrayList = ConsoleMenu.listarConsoles();
        ArrayList<JogosConsole> jogosConsoleArrayList = JogosConsoleMenu.listarConsoles();
        ArrayList<CPU> cpuArrayList = CPUMenu.listarCPUs();
        ArrayList<Cliente> clienteArrayList = ClienteMenu.listarClientes();
        ArrayList<Pedido> pedidoArrayList = PedidoMenu.listarPedidos();

        System.out.println("CONSOLES CADASTRADOS: ");
        consoleArrayList.forEach(System.out::println);

        System.out.println("JOGOS CONSOLES CADASTRADOS: ");
        jogosConsoleArrayList.forEach(System.out::println);

        System.out.println("CPUs CADASTRADOS: ");
        cpuArrayList.forEach(System.out::println);

        System.out.println("CLIENTES CADASTRADOS: ");
        clienteArrayList.forEach(System.out::println);

        System.out.println("PEDIDOS CADASTRADOS: ");
        pedidoArrayList.forEach(System.out::println);
    }

}
