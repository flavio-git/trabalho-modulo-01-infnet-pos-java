package menu;

import model.Cliente;
import model.Pedido;
import model.Produto;

import java.io.*;
import java.util.ArrayList;

public class PedidoMenu {
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static ArrayList<Pedido> listarPedidos() {
        produtos.addAll(ConsoleMenu.listarConsoles());
        produtos.addAll(JogosConsoleMenu.listarConsoles());
        produtos.addAll(CPUMenu.listarCPUs());

        clientes.addAll(ClienteMenu.listarClientes());

        ArrayList<Pedido> pedidos = new ArrayList<>();

        String pathFile = "./files/pedidos.txt";

        try {
            File f = new File(pathFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            while (linha != null) {
                String[] item = linha.split(",");

                boolean isWeb = Boolean.parseBoolean(item[0].trim());

                ArrayList<Produto> produtosBusca = new ArrayList<>();
                String[] codigosProdutos = item[1].split("-");
                for (String codigo : codigosProdutos) {
                    produtosBusca.add(procuraProduto(Integer.parseInt(codigo)));
                }

                String clienteNome = item[2].trim();
                Cliente cliente = procuraCliente(clienteNome);

                Pedido pedido = new Pedido(isWeb, produtosBusca, cliente);
                pedidos.add(pedido);

                linha = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }

    private static Produto procuraProduto(int codigo) {
        return produtos
                .stream()
                .filter(produto -> produto.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    private static Cliente procuraCliente(String nome) {
        return clientes
                .stream()
                .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public static void cadastraPedido(ArrayList<Pedido> pedidos) {
        try {
            File f = new File("./files/pedidos.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Pedido p : pedidos) {
                boolean isWeb = p.isWeb();
                String codigoProdutos = p.geraCodigoProdutos();
                String cliente = p.getCliente();

                pw.println(isWeb + "," + codigoProdutos + "," + cliente);
            }

            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
