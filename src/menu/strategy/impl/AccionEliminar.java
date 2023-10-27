package menu.strategy.impl;
import domain.Juguete;
import menu.strategy.Accion;
import utils.Kb;
import java.util.Set;
public class AccionEliminar implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        AccionMostrar.mostrarElementos(juguetes);
        int opcion=Kb.leerEntero("Que juguete desea Eliminar"+"\n");
        juguetes.removeIf(x -> x.getId()==opcion);
        AccionEliminarPorColor.reasignarID(juguetes);     
        return juguetes;
    }


    @Override
    public Integer getOpcion() {
        return 3;
    }
}