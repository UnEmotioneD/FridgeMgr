package kr.or.iei.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import kr.or.iei.model.vo.Drink;
import kr.or.iei.model.vo.FridgeInterface;
import kr.or.iei.model.vo.Fruit;
import kr.or.iei.model.vo.Grocery;
import kr.or.iei.model.vo.Meat;
import kr.or.iei.model.vo.Seafood;
import kr.or.iei.model.vo.Vegetable;
import kr.or.iei.viewer.FridgeViewer;

public class FridgeController implements FridgeInterface {
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
                case 1:
                    enter();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    showSearched();
                    break;
                case 4:
                    inAndOut();
                    break;
                case 5:
                    move();
                    break;
                case 6:
                    checkIce();
                    break;
                case 7:
                    fix();
                    break;
                case 0:
                    System.out.println("Terminated");
                    return;
                default:
                    break;
            }
        }
    }

    public void enter() {
        System.out.println("----- Enter groceries -----");
        String category = viewer.takeCategory();
        switch (category) {
            case "f":
                category = "Fruit";
                break;
            case "v":
                category = "Vegetable";
                break;
            case "d":
                category = "Drink";
                break;
            case "m":
                category = "Meat";
                break;
            case "s":
                category = "Sea Food";
                break;
            default:
                System.out.println("Wrong input");
                break;
        }

        String name = viewer.takeName(category);
        int amount = viewer.takeAmount(name);
        String where = viewer.takeWhere();

        switch (where) {
            case "t":
                where = "top";
                break;
            case "b":
                where = "bottom";
                break;
            default:
                System.out.println("Wrong input");
                break;
        }

        switch (category) {
            case "Fruit":
                groceryList.add(new Fruit(category, name, amount, where));
                break;
            case "Vegetable":
                groceryList.add(new Vegetable(category, name, amount, where));
                break;
            case "Drink":
                groceryList.add(new Drink(category, name, amount, where));
                break;
            case "Meat":
                groceryList.add(new Meat(category, name, amount, where));
                break;
            case "Sea Food":
                groceryList.add(new Seafood(category, name, amount, where));
                break;
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