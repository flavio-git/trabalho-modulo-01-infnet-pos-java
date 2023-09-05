package menu;

import model.Console;
import model.JogosConsole;

import java.io.*;
import java.util.ArrayList;

public class JogosConsoleMenu {
    public static ArrayList<Console> consoles = ConsoleMenu.listarConsoles();

    public static ArrayList<JogosConsole> listarConsoles() {
        ArrayList<JogosConsole> jogosConsoleList = new ArrayList<>();

        String pathFile = "./files/jogosconsole.txt";

        try {
            File f = new File(pathFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            while (linha != null) {
                String[] item = linha.split(",");

                String nome = item[0].trim();
                float preco = Float.parseFloat(item[1].trim());
                int codigo = Integer.parseInt(item[2].trim());
                String marcaConsole = item[3].trim();

                Console console = procuraMarca(marcaConsole);

                JogosConsole jogo = new JogosConsole(nome, preco, codigo, console);
                jogosConsoleList.add(jogo);

                linha = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jogosConsoleList;
    }

    private static Console procuraMarca(String marca) {
        return consoles
                .stream()
                .filter(console -> console.getMarca().equalsIgnoreCase(marca))
                .findFirst()
                .orElse(null);
    }

    public static void cadastrarJogosConsole(ArrayList<JogosConsole> jogosConsole) {
        try {
            File f = new File("./files/jogosconsole.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (JogosConsole c : jogosConsole) {
                String nome = c.getNome();
                float preco = c.getPreco();
                int codigo = c.getCodigo();
                String marca = c.getMarca();
                double imposto = c.getImposto();

                pw.println(nome + "," + preco + "," + codigo + "," + marca + "," + imposto);
            }

            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
