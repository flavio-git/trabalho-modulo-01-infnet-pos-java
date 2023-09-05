package test;

import menu.ConsoleMenu;
import model.Console;

import java.util.ArrayList;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c1 = new Console("Playstation 5", 4500.00f, 1020, "Sony");
        Console c2 = new Console("Switch LED", 3000.00f, 1030, "Nintendo");
        Console c3 = new Console("Series X", 4800.00f, 1020, "Xbox");

        ArrayList<Console> consoleArrayList = new ArrayList<>();
        consoleArrayList.add(c1);
        consoleArrayList.add(c2);
        consoleArrayList.add(c3);

        ConsoleMenu.cadastrarConsoles(consoleArrayList);

        consoleArrayList.forEach(System.out::println);
    }
}

