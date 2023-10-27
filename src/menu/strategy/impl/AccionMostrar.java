package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;
import java.util.Set;

public class AccionMostrar implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        mostrarElementos(juguetes);
        return juguetes;
    }

    public static void mostrarElementos(Set<Juguete> juguetes) {
        juguetes.forEach(i -> System.out.println(i));
        System.out.println();
    }

    @Override
    public Integer getOpcion() {
        return 4; 
    }
}
