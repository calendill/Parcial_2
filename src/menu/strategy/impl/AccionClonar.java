package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccionClonar implements Accion {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<Juguete> aplicar(List<Juguete> juguetes) {
        System.out.println("¿Qué juguete quieres clonar?");
        AccionMostrar.mostrarElementos(juguetes);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        Juguete jugueteACopiar = juguetes.get(opcion-1);
        System.out.println("¿Cuántas veces lo quieres clonar?");
        int numeroDeVeces = scanner.nextInt();
        scanner.nextLine();
        List<Juguete> juguetesCopia = new ArrayList<>(juguetes);
        for(int i = 0; i < numeroDeVeces; i++) {
            Juguete jugueteClonado = jugueteACopiar.clone();
            jugueteClonado.setId(juguetesCopia.size()+1);
            juguetesCopia.add(jugueteClonado);
        }
        return juguetesCopia;
    }

    @Override
    public Integer getOpcion() {
        return 2;
    }
}
