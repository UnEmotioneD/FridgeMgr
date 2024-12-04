package kr.or.iei.viewer;

import java.util.Scanner;

public class FridgeViewer {
    Scanner sc;
    int mainMenuCount;

    public FridgeViewer() {
        sc = new Scanner(System.in);
        mainMenuCount = 0;
    }

    public int mainMenu(int size) {
        System.out.println("===== Refrigerator Management Program =====");
        System.out.println("1 Enter");
        if (size != 0) {
            System.out.println("2 showAll");
            System.out.println("3 showSearched");
            System.out.println("4 inAndOut");
            System.out.println("5 move");
            System.out.println("6 checkIce");
            System.out.println("7 fix");
        }
        System.out.println("0 Terminate");
        System.out.print("=> ");

        if (mainMenuCount != 0) {
            sc.next();
        }
        return sc.nextInt();
    }

    public String takeCategory() {
        System.out.println("What kind of grocery");
        System.out.println("Fruit/Vegetable/Drink/Meat/Seafood");
        System.out.println("f/v/d/m/s");
        System.out.print("=> ");
        return sc.next().toLowerCase();
    }

    public String takeName(String grocery) {
        System.out.print("What kind of " + grocery + " : ");
        return sc.next().toLowerCase();
    }

    public int takeAmount(String name) {
        System.out.print("How many " + name + " : ");
        return sc.nextInt();
    }

    public String takeWhere() {
        System.out.print("Top or Bottom ? (t / b) : ");
        return sc.next().toLowerCase();
    }

    public String searchFrig() {
        System.out.print("Search top or bottom (t / b) : ");
        return sc.next().toLowerCase();
    }

    public String searchByName() {
        System.out.print("What kind of grocery : ");
        return sc.next();
    }
}
