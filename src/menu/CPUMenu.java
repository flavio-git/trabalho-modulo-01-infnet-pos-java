package menu;

import model.CPU;

import java.io.*;
import java.util.ArrayList;

public class CPUMenu {
    public static ArrayList<CPU> listarCPUs() {
        ArrayList<CPU> cpus = new ArrayList<>();

        String pathFile = "./files/cpus.txt";

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
                int numeroNucleos = Integer.parseInt(item[3].trim());
                int numeroThreads = Integer.parseInt(item[4].trim());

                CPU cpu = new CPU(nome, preco, codigo, numeroNucleos, numeroThreads);
                cpus.add(cpu);

                linha = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cpus;
    }

    public static void cadastrarCPUs(ArrayList<CPU> cpus) {
        try {
            File f = new File("./files/cpus.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (CPU c : cpus) {
                String nome = c.getNome();
                float preco = c.getPreco();
                int codigo = c.getCodigo();
                int numeroNucleos = c.getNumeroNucleos();
                int numeroThreads = c.getNumeroThreads();
                double imposto = c.getImposto();

                pw.println(nome + "," + preco + "," + codigo + "," + numeroNucleos + "," + numeroThreads + "," + imposto);
            }

            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
