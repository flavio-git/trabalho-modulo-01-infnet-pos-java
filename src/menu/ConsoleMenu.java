package menu;

import model.Console;

import java.io.*;
import java.util.ArrayList;

public class ConsoleMenu {
    public static ArrayList<Console> listarConsoles() {
        ArrayList<Console> consoles = new ArrayList<>();

        String pathFile = "./files/consoles.txt";

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
                String marca = item[3].trim();

                Console console = new Console(nome, preco, codigo, marca);
                consoles.add(console);

                linha = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return consoles;
    }

    public static void cadastrarConsoles(ArrayList<Console> consoles) {
        try {
            File f = new File("./files/consoles.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Console c : consoles) {
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
