package menu.strategy.impl;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import domain.Juguete;
import domain.impl.Carrito;
import menu.strategy.Accion;

public class AccionMayorNumeroPuertas implements Accion {
	

	@Override
	public Set<Juguete> aplicar(Set<Juguete> juguetes) {
		Set<Juguete> juguetesCopia = new LinkedHashSet<>(juguetes);
		Optional<Carrito> carritoPuertas = juguetesCopia.stream()
			    .filter(x -> x instanceof Carrito)
			    .map(carrito -> (Carrito) carrito) // Convertir a tipo Carrito
			    .max(Comparator.comparing(Carrito::getNumeroPuertas));
			if (carritoPuertas.isPresent()) {
			    Carrito carritoMayorPuertas = carritoPuertas.get();
			    System.out.println(carritoMayorPuertas + "\n");		   
			} else {
			    System.out.print("No hay carrritos en la lista");
			}
		return juguetes;
	}

	@Override
	public Integer getOpcion() {
		return 6;
	}

}
//forEach(i -> System.out.println(i))