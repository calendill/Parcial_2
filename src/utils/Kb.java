package utils;

import java.util.Scanner;

public class Kb {

    public static int leerEntero(String mensaje) {
    	Scanner in = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        return in.nextInt();
    }

    public static double leerReal(String mensaje) {
    	Scanner in = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        return in.nextDouble();
    }
    
    public static String leerTexto(String mensaje) {
    	Scanner in = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        return in.nextLine();
    }     
}
