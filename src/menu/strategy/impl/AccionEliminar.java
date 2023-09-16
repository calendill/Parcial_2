package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccionEliminar implements Accion {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<Juguete> aplicar(List<Juguete> juguetes) {
        System.out.println("¿Qué juguete desea eliminar?");
        AccionMostrar.mostrarElementos(juguetes);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        List<Juguete> juguetesCopia = new ArrayList<>(juguetes);
        juguetesCopia.remove(opcion-1);
        reorganizarElementos(opcion, juguetesCopia);
        return juguetesCopia;
    }

    private void reorganizarElementos(int opcion, List<Juguete> juguetesCopia) {
        for(int i = opcion -1; i< juguetesCopia.size(); i++) {
            juguetesCopia.get(i).setId(i+1);
        }
    }

    @Override
    public Integer getOpcion() {
        return 3;
    }
}
