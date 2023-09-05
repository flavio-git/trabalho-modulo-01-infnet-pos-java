package menu;

import model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ClienteMenu {
    public static ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        String pathFile = "./files/clientes.txt";

        try {
            File f = new File(pathFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            while (linha != null) {
                String[] item = linha.split(",");

                String nome = item[0].trim();
                String cpf = item[1].trim();
                String email = item[2].trim();

                Cliente cliente = new Cliente(nome, cpf, email);
                clientes.add(cliente);

                linha = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public static void cadastrarCliente(ArrayList<Cliente> clientes) {
        try {
            File f = new File("./files/clientes.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Cliente c : clientes) {
                String nome = c.getNome();
                String cpf = c.getCpf();
                String email = c.getEmail();

                pw.println(nome + "," + cpf + "," + email);
            }

            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
