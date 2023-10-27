package menu.strategy.impl;

import domain.Juguete;
import menu.factory.impl.CreadorCarrito;
import menu.factory.impl.CreadorPeluche;
import menu.strategy.Accion;
import utils.Kb;
import java.util.LinkedHashSet;
import java.util.Set;


public class AccionCrear implements Accion {


    private final CreadorPeluche creadorPeluche = new CreadorPeluche();
    private final CreadorCarrito creadorCarrito = new CreadorCarrito();

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        int opcion=Kb.leerEntero("\"1.Carrito\n" + "2.Peluche");
        Juguete jugueteCreado = crearJuguete(opcion);
        Set<Juguete> juguetesCopia = new LinkedHashSet<>(juguetes);
        jugueteCreado.setId(generarId(juguetes));
        juguetesCopia.add(jugueteCreado);
        return juguetesCopia;
    }

    private int generarId(Set<Juguete> juguetes) {
        return juguetes.size() + 1;
    }

    private Juguete crearJuguete(int opcion) {
        if(opcion == 1) {
            return creadorCarrito.crear();
        }
        if(opcion == 2) {
            return creadorPeluche.crear();
        }
        throw new RuntimeException("Opcion no valida");
    }

    @Override
    public Integer getOpcion() {
        return 1;
    }
}
