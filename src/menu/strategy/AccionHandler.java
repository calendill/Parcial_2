package menu.strategy;

import menu.strategy.impl.AccionClonar;
import menu.strategy.impl.AccionCrear;
import menu.strategy.impl.AccionEliminar;
import menu.strategy.impl.AccionMostrar;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccionHandler {

    private List<Accion> acciones = List.of(
            new AccionMostrar(),
            new AccionClonar(),
            new AccionCrear(),
            new AccionEliminar()
    );
    private Map<Integer, Accion> strategy;

    public AccionHandler() {
        this.strategy = acciones.stream()
                .collect(Collectors.toMap(Accion::getOpcion, Function.identity()));
    }

    public Map<Integer, Accion> getStrategy() {
        return strategy;
    }
}
