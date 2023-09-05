package test;

import menu.JogosConsoleMenu;
import model.Console;
import model.JogosConsole;

import java.util.ArrayList;

public class JogosConsoleTest {
    public static void main(String[] args) {
        Console c1 = new Console("Playstation 5", 4500.00f, 1020, "Sony");
        Console c2 = new Console("Switch LED", 3000.00f, 1030, "Nintendo");
        Console c3 = new Console("Series X", 4800.00f, 1040, "Xbox");

        JogosConsole j1 = new JogosConsole("Spiderman 2", 350.00f, 2020, c1);
        JogosConsole j2 = new JogosConsole("The Legend of Zelda", 400.00f, 2030, c2);
        JogosConsole j3 = new JogosConsole("Halo Infinite", 250.00f, 2040, c3);

        ArrayList<JogosConsole> jogosConsoleSet = new ArrayList<>();
        jogosConsoleSet.add(j1);
        jogosConsoleSet.add(j2);
        jogosConsoleSet.add(j3);

        JogosConsoleMenu.cadastrarJogosConsole(jogosConsoleSet);

        jogosConsoleSet.forEach(System.out::println);
    }
}
