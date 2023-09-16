package menu.strategy.impl;

import domain.Juguete;
import menu.factory.impl.CreadorCarrito;
import menu.factory.impl.CreadorPeluche;
import menu.strategy.Accion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccionCrear implements Accion {

    private final Scanner scanner = new Scanner(System.in);
    private final CreadorPeluche creadorPeluche = new CreadorPeluche();
    private final CreadorCarrito creadorCarrito = new CreadorCarrito();

    @Override
    public List<Juguete> aplicar(List<Juguete> juguetes) {
        System.out.println("1.Carrito \n" +
                "2.Peluche");
        int opcion = scanner.nextInt();
        List<Juguete> juguetesCopia = new ArrayList<>(juguetes);
        Juguete jugueteCreado = crearJuguete(opcion);
        jugueteCreado.setId(generarId(juguetes));
        juguetesCopia.add(jugueteCreado);
        return juguetesCopia;
    }

    private long generarId(List<Juguete> juguetes) {
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
