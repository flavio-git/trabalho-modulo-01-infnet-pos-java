package test;

import menu.CPUMenu;
import model.CPU;

import java.util.ArrayList;

public class CPUTest {
    public static void main(String[] args) {
        CPU c1 = new CPU("AMD Ryzen 7 3800XT", 1500f, 4030, 8, 16);
        CPU c2 = new CPU("Intel Core i9-12900", 4000f, 4040, 16, 24);
        CPU c3 = new CPU("AMD Ryzen 9 5900X", 2000f, 4020, 12, 24);

        ArrayList<CPU> cpuArrayList = new ArrayList<>();
        cpuArrayList.add(c1);
        cpuArrayList.add(c2);
        cpuArrayList.add(c3);

        CPUMenu.cadastrarCPUs(cpuArrayList);

        cpuArrayList.forEach(System.out::println);
    }

}
