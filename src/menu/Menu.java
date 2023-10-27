package menu;

import domain.Juguete;
import domain.impl.Carrito;
import domain.impl.Peluche;
import menu.strategy.AccionHandler;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class Menu {

    private static final Menu instance = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private Set<Juguete> juguetes = new LinkedHashSet<>();
    private final AccionHandler accionHandler = new AccionHandler();

    private Menu() {
    }

    public void mostrarMenu() {
        inicializarLista();
        int opcion = 0;
        do {
            System.out.println("Bienvenido al Menu");
            System.out.println("1.Crear\n" + "2.Clonar\n" + "3.Eliminar\n" + "4.Mostrar todos\n" + "5.Filtrar Juguete\n" + "6.Imprimir Carrito Con mayor numero de puertas\n" + "7.Crear Mapa\n" + "8.Eliminar por Color\n" + "9.Salir\n");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion >= 9) {
                continue;
            }else {
            	juguetes=accionHandler.getStrategy().get(opcion).aplicar(juguetes);
            }
            
        } while (opcion != 9);
        System.out.println("Gracias por utilizar este Menú");
    }

    public static Menu getInstance() {
    	return instance;
    }
   

    private void inicializarLista() {
        juguetes.add(Carrito.builder().id(1).color("negro").numeroPuertas((short) 4).marca("volvo").build());
        juguetes.add(Peluche.builder().id(2).color("azul").relleno("papel").materialExterior("Cuero").build());
        juguetes.add(Carrito.builder().id(3).color("verde").numeroPuertas((short) 2).marca("Renault").build());
        juguetes.add(Peluche.builder().id(4).color("amarillo").relleno("Algodon").materialExterior("tela").build());
    }
}
