package menu.strategy;

import domain.Juguete;

import java.util.List;

public interface Accion {

    List<Juguete> aplicar(List<Juguete> juguetes);

    Integer getOpcion();
}
