package menu;

import domain.Juguete;
import domain.impl.Carrito;
import domain.impl.Peluche;
import menu.strategy.AccionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Menu instance = new Menu();
    private List<Juguete> juguetes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private final AccionHandler accionHandler = new AccionHandler();

    private Menu() {
    }

    public void mostrarMenu() {
        inicializarLista();
        int opcion = 0;
        do {
            System.out.println("Bienvenido al Menu");
            System.out.println("1.Crear\n" + "2.Clonar\n" + "3.Eliminar\n" + "4.Mostrar todos\n" + "5.Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion >= 5) {
                continue;
            }
            juguetes = accionHandler.getStrategy().get(opcion).aplicar(juguetes);
        } while (opcion != 5);
        System.out.println("Gracias por utilizar este Menú");
    }

    public static Menu getInstance() {
        return instance;
    }

    private void inicializarLista() {
        juguetes.add(Carrito.builder().id(1).color("Negro").numeroPuertas((short) 4).marca("Renault").build());
        juguetes.add(Peluche.builder().id(2).color("Negro").relleno("Algodon").materialExterior("Cuero").build());
    }

}
