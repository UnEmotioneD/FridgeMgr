package kr.or.iei.controller;

import kr.or.iei.model.vo.*;
import kr.or.iei.viewer.FridgeViewer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FridgeController {
    ArrayList<Grocery> groceryList;
    FridgeViewer viewer;
    Scanner sc;

    public FridgeController() {
        groceryList = new ArrayList<>();
        viewer = new FridgeViewer();
        sc = new Scanner(System.in);
    }

    public void mainMethod() {
        int choice = -1;
        while (true) {
            try {
                choice = viewer.mainMenu(groceryList.size());
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }

            switch (choice) {
                case 1 -> enter();
                case 2 -> showAll();
                case 3 -> showSearched();
                case 4 -> inAndOut();
                case 5 -> move();
                case 6 -> checkIce();
                case 7 -> fix();
                case 0 -> System.out.println("Terminated");
            }
        }
    }

    public void enter() {
        System.out.println("----- Enter groceries -----");
        String category = viewer.takeCategory();
        switch (category) {
            case "f" -> category = "Fruit";
            case "v" -> category = "Vegetable";
            case "d" -> category = "Drink";
            case "m" -> category = "Meat";
            case "s" -> category = "Sea Food";
            default -> System.out.println("Wrong input");
        }

        String name = viewer.takeName(category);
        int amount = viewer.takeAmount(name);
        String where = viewer.takeWhere();

        switch (where) {
            case "t" -> where = "top";
            case "b" -> where = "bottom";
            default -> System.out.println("Wrong input");
        }

        switch (category) {
            case "Fruit" -> groceryList.add(new Fruit(category, name, amount, where));
            case "Vegetable" -> groceryList.add(new Vegetable(category, name, amount, where));
            case "Drink" -> groceryList.add(new Drink(category, name, amount, where));
            case "Meat" -> groceryList.add(new Meat(category, name, amount, where));
            case "Sea Food" -> groceryList.add(new Seafood(category, name, amount, where));
        }
    }

    public void showAll() {
        System.out.println("Category\tName\t\tWhere\t\tAmount\tDuration");
        for (Grocery grocery : groceryList) {
            System.out.println(grocery.toString());
        }
    }

    public void showSearched() {
        String where = viewer.searchFrig();
        ArrayList<String> inThere = new ArrayList<>();

        for (Grocery grocery : groceryList) {
            if ((where.equals("t") && grocery.getWhere().equals("top"))
                || (where.equals("b") && grocery.getWhere().equals("bottom"))) {
                System.out.print(grocery.getName() + "\t");
                inThere.add(grocery.getName());
            }
        }
        System.out.println();

        String name = viewer.searchByName();
        if (!inThere.contains(name)) {
            System.out.println(name + " is not in " + where);
        } else {
            for (Grocery grocery : groceryList) {
                if (grocery.getName().equals(name) && grocery.getWhere().equals(where)) {
                    System.out.println(grocery.toStringSimple());
                }
            }
        }
    }

    public void inAndOut() {

    }

    public void move() {

    }

    public void checkIce() {

    }

    public void fix() {

    }

}
