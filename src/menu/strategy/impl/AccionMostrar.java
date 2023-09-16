package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.List;

public class AccionMostrar implements Accion {

    @Override
    public List<Juguete> aplicar(List<Juguete> juguetes) {
        mostrarElementos(juguetes);
        return juguetes;
    }

    public static void mostrarElementos(List<Juguete> juguetes) {
        for(int i = 0; i < juguetes.size(); i++) {
            System.out.println((i+1) + "." + juguetes.get(i).toString());
        }
    }

    @Override
    public Integer getOpcion() {
        return 4;
    }
}
