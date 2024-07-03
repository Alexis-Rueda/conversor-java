package com.currencyconverter.currency;

import com.currencyconverter.models.ExchangePair;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    String USD = "Dolar";
    String MXN = "Peso Mexicano";
    String ARS = "Peso Argentino";
    String EUR = "Euro";
    String line = "************************************************";
    String str = "*****";

    public void show(){
        Scanner scanner  = new Scanner(System.in);
        boolean exit = false;

        System.out.println(line);
        System.out.println(str + " Bienvenido al Conversor de Moneda    " + str);

        while (!exit) {
            String base = "";
            String target = "";
            double amount;

            menu();

            try {
                int option = scanner.nextInt();

                ExchangePair exchangePair = getExchangePair(option);

                if (exchangePair != null) {
                    System.out.println("\nIngrese el valor que desea convertir:");
                    amount = scanner.nextDouble();

                    Conversor conversor = new Conversor();
                    conversor.showResult(exchangePair, amount);
                } else if (option == 7) {
                    exit = true;
                } else {
                    System.out.println("\nElección no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: entrada no válida. Intenta de nuevo.");
                scanner.next();
            }
            System.out.println(line + line + "\n");
        }
        scanner.close();
        System.out.println("¡Nos vemos pronto!");
    }

    private void menu() {
        System.out.println(line);
        System.out.println(str + " 1) " + MXN + "  ==> " + USD + "          " + str);
        System.out.println(str + " 2) " + USD + "          ==> " + MXN + "  " + str);
        System.out.println(str + " 3) " + MXN + "  ==> " + ARS + " " + str);
        System.out.println(str + " 4) " + ARS + " ==> " + MXN + "  " + str);
        System.out.println(str + " 5) " + MXN + "  ==> " + EUR + "           " + str);
        System.out.println(str + " 6) " + EUR + "           ==> " + MXN + "  " + str);
        System.out.println(str + " 7) Salir                             " + str);
        System.out.println(line+"\n");
        System.out.println("Eliga una opción valida:");
    }

    private ExchangePair getExchangePair(int option) {
        String base = "";
        String target = "";

        switch (option) {
            case 1:
                base = "MXN";
                target = "USD";
                break;
            case 2:
                base = "USD";
                target = "MXN";
                break;
            case 3:
                base = "MXN";
                target = "ARS";
                break;
            case 4:
                base = "ARS";
                target = "MXN";
                break;
            case 5:
                base = "MXN";
                target = "EUR";
                break;
            case 6:
                base = "EUR";
                target = "MXN";
                break;
            case 7:
                return null;
            default:
                return null;
        }

        return new ExchangePair(base, target);
    }
}
